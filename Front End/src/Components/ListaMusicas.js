import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

import Axios from 'axios';
import qs from 'qs';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';
import { Navigate } from 'react-router-dom';

import {Link, useNavigate} from 'react-router-dom';
class Listamusicas extends React.Component {
    

    constructor(props) {
        super(props);

        this.state = {
            musicas : [],
        }

    }

    componentDidMount() {        
        
        fetch("http://localhost:4567/song")
        .then(result => result.json())
        .then(dados => {
            this.setState({musicas : dados});
        });
        
    }

    componentDidUpdate () {

        console.log('update');

    }

    async criarmusica () {

        var nome = document.getElementById('criar-musica-nome');
        var autor = document.getElementById('criar-musica-autor');
        var duracao = document.getElementById('criar-musica-duracao');

        console.log('autor', autor.value);

        const params = {
            name : nome.value,
            author_id : autor.value,
            duration : duracao.value
        }

        const request = await fetch('http://localhost:4567/song', {
            method: 'POST',
            mode: 'no-cors',
            body: JSON.stringify(params),
            headers: {
              'Content-type': 'application/json; charset=UTF-8',
            },
          });

          if(request) {
              window.location.href = '/perfil';
          }

    }

    async editarmusica (id) {

        if (!window.confirm('Deseja editar esse registro??')) return;
    
        console.log('teste');

        var nome = document.getElementById('nomemusica-'+id);
        var duracao = document.getElementById('duracaomusica-'+id);

        const params = {
            id : id,
            name : nome.value,
            duration : duracao.value
        }

        const request = await fetch('http://localhost:4567/song/update/'+id, {
            method: 'POST',
            mode: 'no-cors',
            body: JSON.stringify(params),
            headers: {
              'Content-type': 'application/json; charset=UTF-8',
            },
          });

          if(request) {
              window.location.href = '/perfil';
          }
          

    }

    async deletarmusica (id) {

        console.log('id deleta',id);

        if (!window.confirm('Deseja deletar esse registro??')) return;

        const params = {
            id: id.toString(),
        };

        const request = await fetch('http://localhost:4567/song/delete/'+id, {
            method: 'GET',
            mode: 'no-cors',
            headers: {
              'Content-type': 'application/json; charset=UTF-8',
            },
          });

        if(request) {
            window.location.href = '/perfil';
        }

    }

    loadTabela () {

        return (                        
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Duracao</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                        {this.state.musicas.map((musica) =>
                            {   if (musica.author === parseInt(this.props.user, 10)) {
                                    return <tr><td><Form.Group className="mb-3"><Form.Control type="text" id={'nomemusica-'+musica.id} defaultValue={musica.name} key={musica.name}/><Form.Text className="text"></Form.Text></Form.Group></td> <td><Form.Group className="mb-3"><Form.Control type="text" id={'duracaomusica-'+musica.id} defaultValue={musica.duration} key={musica.duration}/><Form.Text className="text"></Form.Text></Form.Group></td><td><Button variant="success" onClick={() => this.editarmusica(musica.id)}>Editar</Button></td><td><Button variant="danger" onClick={() => this.deletarmusica(musica.id)}>Deletar</Button></td></tr>   
                                }                         
                            })}
                </tbody>
            </Table>
        );

    }
        
    render () {

        return (

            <TableContainer>
            <h1>SUAS MÚSICAS</h1><br></br>
            {this.loadTabela()}
            <Form>
                    <h2>Cadastrar nova Música</h2>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Nome da Música</Form.Label>
                        <Form.Control type="text" placeholder="Ex: Rosa dos Mares..." id="criar-musica-nome"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Duração da Música (Em segundos)</Form.Label>
                        <Form.Control type="text" placeholder="Ex: 120..." id="criar-musica-duracao"/>
                        <Form.Text className="text-muted">
                        </Form.Text>
                    </Form.Group> 
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Control type="hidden" placeholder="" id="criar-musica-autor" defaultValue={parseInt(this.props.user, 10)} key={parseInt(this.props.user, 10)}/>
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