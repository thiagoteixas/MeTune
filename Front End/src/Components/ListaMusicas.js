import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';

import { useState, useEffect, useRef } from 'react';

import { confirmAlert } from 'react-confirm-alert'; // Import
import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { TableContainer } from './styles/Styles.js';

function ListaMusicas () {
    
    const nomeRef = useRef(null);
    const autorRef = useRef(null);
    const duracaoRef = useRef(null);
    

    // Lista de Músicas para exemplo, criar nova lista com requisição da api    
    let musicas = [
        {
            id: 1,
            nome: "Estrelas do mar",
            autor: "musico.joao.2022",
            duracao: "3:20"
        },
        {
            id: 1,
            nome: "Estrelas do sol",
            autor: "musico.joao.2022",
            duracao: "2:48"            
        }
    ]
    
    const [count, setCount] = useState(atualizaTabela(musicas));
  
    // Similar to componentDidMount and componentDidUpdate:
   /*useEffect(() => {
        
        atualizaTabela(musicas);

    }, [count]);*/


    function atualizaTabela (users) {
        console.log('atualiza tabela');
        return (            
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome da Música</th>
                        <th>Autor</th>
                        <th>Duração</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    {users.map((musica) =>
                    <tr>
                            <td>{musica.id}</td>
                            <td><Form.Group className="mb-3"><Form.Control type="text" id={'nomemusica-'+musica.id} defaultValue={musica.nome}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Form.Group><Form.Control type="text" id={'autormusica-'+musica.id} defaultValue={musica.autor}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Form.Group><Form.Control type="text" id={'duracaomusica-'+musica.id} defaultValue={musica.duracao}/><Form.Text className="text"></Form.Text></Form.Group></td>
                            <td><Button variant="success" onClick={() => clickHandler(0, musica.id)}>Editar</Button></td>
                            <td><Button variant="danger" onClick={() => clickHandler(1, musica.id)}>Deletar</Button></td>
                    </tr>
                    )}
                </tbody>
            </Table>
        );

    }

    function clickHandler (op, id) {
        
        if ((op == 1)) {

            if (window.confirm('Deseja mesmo Deletar este Música? / Nome = '+document.getElementById('nomemusica-'+id).value + ' / Autor = ' + document.getElementById('autormusica-'+id).value + ' / Duração = ' + document.getElementById('duracaomusica-'+id).value + ' ?' )) {

                // Requisição para deletar Música com base no id aqui
                alert('Música deletada!!!');

            }

        } else {

            if (window.confirm('Deseja mesmo Editar este Música? / Nome = '+document.getElementById('nomemusica-'+id).value + ' / Autor = ' + document.getElementById('autormusica-'+id).value + ' / Duração = ' + document.getElementById('duracaomusica-'+id).value + ' ?' )) {

                var nome = document.getElementById('nomemusica-'+id).value;
                var autor = document.getElementById('autormusica-'+id).value;
                var duracao = document.getElementById('duracaomusica-'+id).value;
                
                // Requisição para editar Música aqui
                alert('Música editada!!!');

            }

        }

    }

    function pesquisarmusicas () {

        var nome = document.getElementById('pesquisa-musica').value;

        // Requisição para pesquisar Música aqui

        // Alimentar lista de Músicas com o resultado da requisição

        console.log(musicas);

        musicas = [
            {
                id: 1,
                nome: "Estrelas do sol",
                autor: "musico.joao.2022",
                duracao: "2:48"            
            }    
        ]

        console.log(musicas);

        setCount(atualizaTabela(musicas));

    }

    function novaMusica () {

        var nome = nomeRef.current.value;
        var autor = autorRef.current.value;
        var duracao = duracaoRef.current.value;

        // Requisição para inserção aqui com base nos parametros passados acima

    }

    return (

        <TableContainer>
        <h1>CRUD MÚSICAS</h1><br></br>
        
        <Form.Group className="mb-3">
            <Form.Label>Pesquisar Música por nomes:</Form.Label>
            <Form.Control type="text" id="pesquisa-musica" placeholder="Ex: joao.18music..." />
            <Form.Text className="text-muted">
            </Form.Text>
        </Form.Group>
        <Button variant="dark" type="submit" onClick={() => pesquisarmusicas()}>
            Pesquisar
        </Button><br></br>
        {count}
        
        <Form>
                <h2>Cadastrar nova Música</h2>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Nome da Música</Form.Label>
                    <Form.Control type="text" placeholder="Ex: Mar das Rosas..." ref={nomeRef}/>
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>          
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Autor da Música</Form.Label>
                    <Form.Control type="text" placeholder="Ex: joao124..." ref={autorRef} />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>     
                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Duração da música</Form.Label>
                    <Form.Control type="text" placeholder="Ex: 3:21..." ref={duracaoRef} />
                </Form.Group>
                <Button variant="dark" onClick={() => novaMusica()}>
                    Cadastrar nova música
                </Button><br></br>
                </Form>
        </TableContainer>

    );

}

export default ListaMusicas;