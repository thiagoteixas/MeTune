import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

import Axios from 'axios';
import qs from 'qs';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

class Listamusicas extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            musicas : [],
        }

    }

    componentDidMount() {        
        
        fetch("http://localhost/modelo/atividade/getall")
        .then(result => result.json())
        .then(dados => {
            this.setState({musicas : dados});
        });
        
    }

    componentDidUpdate () {

        console.log('update');

    }

    criarmusica () {

        var nome = document.getElementById('criar-musica-nome');
        var autor = document.getElementById('criar-musica-autor');
        var duracao = document.getElementById('criar-musica-duracao');

        const params = {
            nome : nome.value,
            autor : autor.value,
            duracao : duracao.value
        }

        Axios.post('http://localhost/modelo/projeto/create', qs.stringify((params)))
        .then(resp => {

            this.setState(resp.data);

            (resp.data.length === 0) ? alert('Não foi possivel criar o Registro!') : alert('Registro criado com sucesso!', resp.data);

        });

    }

    pesquisarmusica () {
        
        var nome = document.getElementById('pesquisa-musica');

        const params = {
            nome : nome.value
        }

        Axios.post('http://localhost/modelo/projeto/get', qs.stringify((params)))
        .then(resp => {

            this.setState(resp.data);

            (resp.data.length === 0) ? alert('Não foi possivel encontrar o Registro!') : alert('Registro encontrado!', resp.data);

        });


    }

    editarmusica (id) {

        if (!window.confirm('Deseja editar esse registro??')) return;
    
        console.log('teste');

        var nome = document.getElementById('nomemusica-'+id);
        var autor = document.getElementById('autormusica-'+id);
        var duracao = document.getElementById('duracaomusica-'+id);

        const params = {
            id : id,
            nome : nome.value,
            autor : autor.value,
            duracao : duracao.value
        }



        Axios.post('http://localhost/modelo/projeto/update', qs.stringify((params)))
        .then(resp => {

            var result = resp.data;

            (result.length === 0) ? alert('Não foi possivel editar o Registro!') : alert('Registro editado com sucesso!', result);

        });

    }

    deletarmusica (id) {

        console.log('id deleta',id);

        if (!window.confirm('Deseja deletar esse registro??')) return;

        const params = {
            id: id.toString(),
        };


        Axios.post('http://localhost/modelo/projeto/delete', qs.stringify((params)))
        .then(resp => {

            var result = resp.data;

            (result.length === 0) ? alert('Não foi possivel deletar a Registro!') : alert('Registro deletado com sucesso!', result);

        });

    }

    loadTabela () {

        return (                        
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Autor</th>
                        <th>Duracao</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        {this.state.musicas.map((musica) => 
                            <tr>                        
                                <td>{musica.id}</td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomemusica-'+musica.id} defaultValue={musica.nome} key={musica.nome}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'autormusica-'+musica.id} defaultValue={musica.autor} key={musica.autor}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'duracaomusica-'+musica.id} defaultValue={musica.duracao} key={musica.duracao}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Button variant="success" onClick={() => this.editarmusica(musica.id)}>Editar</Button></td>
                                <td><Button variant="danger" onClick={() => this.deletarmusica(musica.id)}>Deletar</Button></td>
                            </tr>                            
                        )}
                </tbody>
            </Table>
        );

    }
        
    render () {

        return (

            <TableContainer>
            <h1>CRUD MÚSICAS</h1><br></br>
            
            <Form.Group className="mb-3">
                <Form.Label>Pesquisar Músicas por nome:</Form.Label>
                <Form.Control type="text" id="pesquisa-musica" placeholder="Ex: joao.18music..."/>
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            <Button variant="dark" onClick={() => this.pesquisarmusica()}>
                Pesquisar
            </Button><br></br>
            {this.loadTabela()}
            <Form>
                    <h2>Cadastrar nova Música</h2>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Nome da Música</Form.Label>
                        <Form.Control type="text" placeholder="Ex: Rosas dos Mares..." id="criar-musica-nome"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Autor da Música</Form.Label>
                        <Form.Control type="text" placeholder="Ex: joao.musico233..." id="criar-musica-autor"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Duração</Form.Label>
                        <Form.Control type="text" placeholder="Ex: 3:25..." id="criar-musica-duracao"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Button variant="dark" onClick={() => this.criarmusica()}>
                        Cadastrar nova música
                    </Button><br></br>
                    </Form>
            
            </TableContainer>

        );

    }

}

export default Listamusicas;