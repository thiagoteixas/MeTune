import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

import Axios from 'axios';
import qs from 'qs';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

class Listausuarios extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            usuarios : [],
        }

    }

    componentDidMount() {        
        
        fetch("http://localhost/modelo/atividade/getall")
        .then(result => result.json())
        .then(dados => {
            this.setState({usuarios : dados});
        });
        
    }

    componentDidUpdate () {

        console.log('update');

    }

    criarusuario () {

        var nome = document.getElementById('criar-usuario-nome');
        var email = document.getElementById('criar-usuario-email');
        var senha = document.getElementById('criar-usuario-senha');

        const params = {
            nome : nome.value,
            email : email.value,
            senha : senha.value
        }

        Axios.post('http://localhost/modelo/projeto/create', qs.stringify((params)))
        .then(resp => {

            this.setState(resp.data);

            (resp.data.length === 0) ? alert('Não foi possivel criar o Registro!') : alert('Registro criado com sucesso!', resp.data);

        });

    }

    pesquisarusuario () {
        
        var nome = document.getElementById('pesquisa-usuario');

        const params = {
            nome : nome.value
        }

        Axios.post('http://localhost/modelo/projeto/get', qs.stringify((params)))
        .then(resp => {

            this.setState(resp.data);

            (resp.data.length === 0) ? alert('Não foi possivel encontrar o Registro!') : alert('Registro encontrado!', resp.data);

        });


    }

    editarusuario (id) {

        if (!window.confirm('Deseja editar esse registro??')) return;
    
        console.log('teste');

        var nome = document.getElementById('nomeusuario-'+id);
        var email = document.getElementById('emailusuario-'+id);

        const params = {
            id : id,
            nome : nome.value,
            email : email.value,
        }



        Axios.post('http://localhost/modelo/projeto/update', qs.stringify((params)))
        .then(resp => {

            var result = resp.data;

            (result.length === 0) ? alert('Não foi possivel editar o Registro!') : alert('Registro editado com sucesso!', result);

        });

    }

    deletarusuario (id) {

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
                        <th>Nome de Usuário</th>
                        <th>E-Mail</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        {this.state.usuarios.map((usuario) => 
                            <tr>                        
                                <td>{usuario.id}</td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomeusuario-'+usuario.id} defaultValue={usuario.nome} key={usuario.nome}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'emailusuario-'+usuario.id} defaultValue={usuario.email} key={usuario.email}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Button variant="success" onClick={() => this.editarusuario(usuario.id)}>Editar</Button></td>
                                <td><Button variant="danger" onClick={() => this.deletarusuario(usuario.id)}>Deletar</Button></td>
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
                <Form.Control type="text" id="pesquisa-usuario" placeholder="Ex: joao.18music..."/>
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            <Button variant="dark" onClick={() => this.pesquisarusuario()}>
                Pesquisar
            </Button><br></br>
            {this.loadTabela()}
            <Form>
                    <h2>Cadastrar nova Música</h2>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Nome de Usuário</Form.Label>
                        <Form.Control type="text" placeholder="Ex: joao.musico233..." id="criar-usuario-nome"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>E-mail</Form.Label>
                        <Form.Control type="text" placeholder="Ex: joao@exemplo.com..." id="criar-usuario-email"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Senha</Form.Label>
                        <Form.Control type="password" placeholder="" id="criar-usuario-senha"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Button variant="dark" onClick={() => this.criarusuario()}>
                        Cadastrar nova música
                    </Button><br></br>
                    </Form>
            
            </TableContainer>

        );

    }

}

export default Listausuarios;