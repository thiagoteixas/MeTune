// import logo from '.src/logo.svg';
import '../App.css';

import React from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';

import { useState } from 'react';

import SobreNos from '../Components/SobreNos';
// import ListaUsuarios from '.src/Components/ListaUsuarios.js';
// import ListaMusicas from '.src/Components/ListaMusicas.js';
// import ListaGeneros from '.src/Components/ListaGeneros.js';
// import MusicBox from '.src/Components/MusicBox.js';

import useAuth from '../hooks/useAuth';

import {Link, useNavigate} from 'react-router-dom';

function Login() {

    const { signin } = useAuth();
    const navigate = useNavigate();

    const[email, setEmail] = useState('');
    const[senha, setSenha] = useState('');
    const[error, setError] = useState(''); 
    
    async function handleLogin() {
        
        if (!email  || !senha) {
            setError("Preencha todos os campos");
            return;
        }

        console.log('teste login')

        var username = document.getElementById("nome-usuario");
        var password = document.getElementById("senha-usuario");
        console.log(username.value, password.value);

        console.log('inicio');

        
          fetch('http://localhost:4567/user/validation/'+username.value+'/'+ password.value)
          .then(result => result.json())
          .then(dados => {
            console.log(dados);
            if (dados == null) {
                setError('Nome de usuário ou senha incorretos!')
                localStorage.setItem("logged_user_id", 0);
            } else {
                alert("Bem-vindo ao MeTune");
                localStorage.setItem("logged_user_id", dados.id);
                console.log('teste localstorage', localStorage.getItem("logged_user_id"));
                navigate('/perfil');
            }
        });

        //alert("Bem-vindo ao MeTune");
        //navigate('/perfil');

    }

    async function testeUpdate() {

        var username = document.getElementById("nome-usuario");
        var password = document.getElementById("senha-usuario");
        console.log(username.value, password.value);

        console.log('inicio');
        const request = await fetch('http://localhost:4567//user/validation/'+username.value+'/'+ password.value, {
            method: 'POST',
            mode: 'no-cors',
            body: JSON.stringify({ name:'testeupdate', duration:120, author_id: 41 }),
            headers: {
              'Content-type': 'application/json; charset=UTF-8',
            },
          });
    }

    return(<div className="login-box">
        
        <form className="login" method="post"> 
            <p className="login-title">Para continuar, faça login no MeTune </p>
            
            <div className="field">
                <label for="email">Seu Nome de usuário:</label>
                <Form.Group className="mb-3"><Form.Control type="email" placeholder='exemplo@email.com' id="nome-usuario" value={email} onChange={(e) => [setEmail(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>  

            <div className="field">
                <label for="senha">Senha:</label>
                <Form.Group className="mb-3"><Form.Control type="password" value={senha} id="senha-usuario" onChange={(e) => [setSenha(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>
            <label className="error-message">{error}</label><br></br>
            <Button variant="success" onClick={handleLogin}>Entrar</Button>

            <div>
                Não tem uma conta?<br></br>
                <strong><Link to="/registrar">Registre-se aqui!</Link></strong>
            </div>

        </form>
    </div>)
}

export default Login;
