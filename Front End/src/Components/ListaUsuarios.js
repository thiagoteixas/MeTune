import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';

import { useState, useEffect, useRef } from 'react';

import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

function ListaUsuarios () {
    
    const nomeRef = useRef(null);
    const emailRef = useRef(null);
    const senhaRef = useRef(null);
    const premiumRef = useRef(null);

    // Lista de usuários para exemplo, criar nova lista com requisição da api    
    let usuarios = [
        {
            id: 1,
            userName: "vitor1992-11",
            email: "vitorjota@exemplo.com",
            premium: 0
        },
        {
            id: 2,
            userName: "musico.joao.2022",
            email: "joaovitormusicista@exemplo.com",
            premium: 1            
        }
    ]
    
    const [count, setCount] = useState(atualizaTabela(usuarios));
  
    // Similar to componentDidMount and componentDidUpdate:
   /*useEffect(() => {
        
        atualizaTabela(usuarios);

    }, [count]);*/


    function atualizaTabela (users) {
        console.log('atualiza tabela');
        return (            
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome de Usuário</th>
                        <th>Email</th>
                        <th>Premium</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((usuario) =>
                    <tr>
                            <td>{usuario.id}</td>
                            <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomeUsuario-'+usuario.id} defaultValue={usuario.userName}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Form.Group><Form.Control type="text" id={'emailUsuario-'+usuario.id} defaultValue={usuario.email}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Form.Select aria-label="Default select example" id={'premiumUsuario-'+usuario.id} selected={usuario.premium}><option value="1">Sim</option><option value="0">Não</option></Form.Select></td>
                            <td><Button variant="success" onClick={() => clickHandler(0, usuario.id)}>Editar</Button></td>
                            <td><Button variant="danger" onClick={() => clickHandler(1, usuario.id)}>Deletar</Button></td>
                    </tr>
                    )}
                </tbody>
            </Table>
        );

    }

    function clickHandler (op, id) {
        
        if ((op == 1)) {

            if (window.confirm('Deseja mesmo Deletar este usuário? / Nome = '+document.getElementById('nomeUsuario-'+id).value + ' / Email = ' + document.getElementById('emailUsuario-'+id).value + ' / Premium = ' + document.getElementById('premiumUsuario-'+id).value + ' ?' )) {

                // Requisição para deletar usuário com base no id aqui
                alert('Usuário deletado!!!');

            }

        } else {

            if (window.confirm('Deseja mesmo Editar este usuário? / Nome = '+document.getElementById('nomeUsuario-'+id).value + ' / Email = ' + document.getElementById('emailUsuario-'+id).value + ' / Premium = ' + document.getElementById('premiumUsuario-'+id).value + ' ?' )) {

                var nome = document.getElementById('nomeUsuario-'+id).value;
                var email = document.getElementById('emailUsuario-'+id).value;
                var premium = document.getElementById('premiumUsuario-'+id).value;
                
                // Requisição para editar usuário aqui
                alert('Usuário editado!!!');

            }

        }

    }

    function pesquisarUsuarios () {

        var nome = document.getElementById('pesquisa-usuario').value;

        // Requisição para pesquisar usuário aqui

        // Alimentar lista de usuários com o resultado da requisição

        console.log(usuarios);

        usuarios = [
            {                 
                id: 1,
                userName: "vitor1992-11",
                email: "vitordjklasjkldçaskjlrjklasjota@exemplo.com",
                premium: 0
            }           
        ]

        console.log(usuarios);

        setCount(atualizaTabela(usuarios));

    }

    function novoUsuario () {

        var nome = nomeRef.current.value;
        var email = emailRef.current.value;
        var senha = senhaRef.current.value;
        var premium = premiumRef.current.value;

        // Requisição para inserção aqui com base nos parametros passados acima

    }

    return (

        <TableContainer>
        <h1>CRUD USUÁRIOS</h1><br></br>
        
        <Form.Group className="mb-3">
            <Form.Label>Pesquisar Usuário por nomes:</Form.Label>
            <Form.Control type="text" id="pesquisa-usuario" placeholder="Ex: joao.18music..." />
            <Form.Text className="text-muted">
            </Form.Text>
        </Form.Group>
        <Button variant="dark" type="submit" onClick={() => pesquisarUsuarios()}>
            Pesquisar
        </Button><br></br>
        {count}
        
        <Form>
                <h2>Cadastrar novo Usuário</h2>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>E-mail</Form.Label>
                    <Form.Control type="text" placeholder="Ex: joao@exemplo.com" ref={emailRef}/>
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>          
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Nome de usuário</Form.Label>
                    <Form.Control type="text" placeholder="Ex: joao124..." ref={nomeRef} />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>     
                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Senha</Form.Label>
                    <Form.Control type="password" placeholder="" ref={senhaRef} />
                </Form.Group>
                <Form.Label>Usuário Premium</Form.Label>
                <Form.Select aria-label="Default select example" ref={premiumRef}><option value=""></option><option value="1">Sim</option><option value="0">Não</option></Form.Select>
                <Button variant="dark" onClick={() => novoUsuario()}>
                    Cadastrar novo usuário
                </Button><br></br>
                </Form>
        </TableContainer>

    );

}

export default ListaUsuarios;