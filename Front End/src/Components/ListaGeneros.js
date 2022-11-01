import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';

import React from 'react';

>>>>>>> main
import Axios from 'axios';
import qs from 'qs';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

class ListaGeneros extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            generos : [],
        }

    }

    componentDidMount() {        
        
        fetch('localhost:4567/tag')
          .then((result) => result.json())
          .then((dados) => {
            this.setState({ generos: dados });
          });
        
    }

    componentDidUpdate () {

        console.log('update');

    }

    criarGenero () {

        var nome = document.getElementById('criar-genero');

        const params = {
            descricao : nome.value
        }

        Axios.post('localhost:4567/tag/', qs.stringify(params)).then(
          (resp) => {
            this.setState(resp.data);

            resp.data.length === 0
              ? alert('Não foi possivel criar o Registro!')
              : alert('Registro criado com sucesso!', resp.data);
          }
        );
    }

    pesquisarGenero () {
        
        var nome = document.getElementById('pesquisa-genero');

        const params = {
            nome : nome.value
        }

        Axios.post('localhost:4567/tag/2', qs.stringify((params)))
        .then(resp => {

            this.setState(resp.data);

            (resp.data.length === 0) ? alert('Não foi possivel encontrar o Registro!') : alert('Registro encontrado!', resp.data);

        });


    }

    editarGenero (id) {

        if (!window.confirm('Deseja editar esse registro??')) return;
    
        console.log('teste');

        var nome = document.getElementById('nomeGenero-'+id);

        const params = {
            id: id,
            descricao: nome.value
        };

        Axios.post(`localhost:4567/tag/update/${id}`, qs.stringify(params)).then((resp) => {
          var result = resp.data;

          result.length === 0
            ? alert('Não foi possivel editar a Registro!')
            : alert('Registro editada com sucesso!', result);
        });

    }

    deletarGenero (id) {

        console.log('id deleta',id);

        if (!window.confirm('Deseja deletar esse registro??')) return;

        const params = {
            id: id.toString(),
        };

        Axios.post(`http://localhost:4567/tag/delete/${id}`, qs.stringify((params)))
        .then(resp => {

            var result = resp.data;

            (result.length === 0) ? alert('Não foi possivel deletar a Registro!') : alert('Registro deletar com sucesso!', result);

        });

    }

    loadTabela () {

        return (                        
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Descrição Gênero</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        {this.state.generos.map((genero) => 
                            <tr>                        
                                <td>{genero.id}</td>
                                <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomeGenero-'+genero.id} defaultValue={genero.descricao} key={genero.descricao}/><Form.Text className="text"></Form.Text></Form.Group></td>
                                <td><Button variant="success" onClick={() => this.editarGenero(genero.id)}>Editar</Button></td>
                                <td><Button variant="danger" onClick={() => this.deletarGenero(genero.id)}>Deletar</Button></td>
                            </tr>                            
                        )}
                </tbody>
            </Table>
        );

    }
        
    render () {

        return (

            <TableContainer>
            <h1>CRUD GÊNEROS</h1><br></br>
            
            <Form.Group className="mb-3">
                <Form.Label>Pesquisar Gênero por nomes:</Form.Label>
                <Form.Control type="text" placeholder="Ex: joao.18music..." id="pesquisa-genero"/>
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            <Button variant="dark" onClick={() => this.pesquisarGenero()}>
                Pesquisar
            </Button><br></br>
            {this.loadTabela()}
            <Form>
                    <h2>Cadastrar novo Gênero Musical</h2>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Descrição do Gênero</Form.Label>
                        <Form.Control type="text" placeholder="Ex: Jazz..." id="criar-genero"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Button variant="dark" onClick={() => this.criarGenero()}>
                        Cadastrar nova música
                    </Button><br></br>
                    </Form>
            
            </TableContainer>

        );

    }

}

export default ListaGeneros;
