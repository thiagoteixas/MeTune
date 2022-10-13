import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';

import { useState, useEffect, useRef } from 'react';

import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

function ListaGeneros () {
    
    const nomeRef = useRef(null);
    

    // Lista de Gêneros para exemplo, criar nova lista com requisição da api    
    let Generos = [
        {
            id: 1,
            nome: "Rock",
        },
        {
            id: 1,
            nome: "Jazz",           
        }
    ]
    
    const [count, setCount] = useState(atualizaTabela(Generos));


    function atualizaTabela (users) {
        console.log('atualiza tabela');
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
                    {users.map((Genero) =>
                    <tr>
                            <td>{Genero.id}</td>
                            <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomeGenero-'+Genero.id} defaultValue={Genero.nome}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Button variant="success" onClick={() => clickHandler(0, Genero.id)}>Editar</Button></td>
                            <td><Button variant="danger" onClick={() => clickHandler(1, Genero.id)}>Deletar</Button></td>
                    </tr>
                    )}
                </tbody>
            </Table>
        );

    }

    function clickHandler (op, id) {
        
        if ((op == 1)) {

            if (window.confirm('Deseja mesmo Deletar este Gênero? / Nome = '+document.getElementById('nomeGenero-'+id).value )) {

                // Requisição para deletar Gênero com base no id aqui
                alert('Gênero deletado!!!');

            }

        } else {

            if (window.confirm('Deseja mesmo Editar este Gênero? / Nome = '+document.getElementById('nomeGenero-'+id).value + ' / Autor = ' + document.getElementById('autorGenero-'+id).value + ' / Duração = ' + document.getElementById('duracaoGenero-'+id).value + ' ?' )) {

                var nome = document.getElementById('nomeGenero-'+id).value;
                
                // Requisição para editar Gênero aqui
                alert('Gênero editado!!!');

            }

        }

    }

    function pesquisarGeneros () {

        var nome = document.getElementById('pesquisa-Genero').value;

        // Requisição para pesquisar Gênero aqui

        // Alimentar lista de Gêneros com o resultado da requisição

        console.log(Generos);

        Generos = [
            {
                id: 1,
                nome: "Jazz",           
            }
        ]

        console.log(Generos);

        setCount(atualizaTabela(Generos));

    }

    function novoGenero () {

        var nome = nomeRef.current.value;

        // Requisição para inserção aqui com base nos parametros passados acima

    }

    return (

        <TableContainer>
        <h1>CRUD GÊNEROS</h1><br></br>
        
        <Form.Group className="mb-3">
            <Form.Label>Pesquisar Gênero por nomes:</Form.Label>
            <Form.Control type="text" id="pesquisa-Genero" placeholder="Ex: joao.18music..." />
            <Form.Text className="text-muted">
            </Form.Text>
        </Form.Group>
        <Button variant="dark" type="submit" onClick={() => pesquisarGeneros()}>
            Pesquisar
        </Button><br></br>
        {count}
        
        <Form>
                <h2>Cadastrar novo Gênero Musical</h2>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Descrição do Gênero</Form.Label>
                    <Form.Control type="text" placeholder="Ex: Mar das Rosas..." ref={nomeRef}/>
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group> 
                <Button variant="dark" onClick={() => novoGenero()}>
                    Cadastrar nova música
                </Button><br></br>
                </Form>
        
        </TableContainer>

    );

}

export default ListaGeneros;