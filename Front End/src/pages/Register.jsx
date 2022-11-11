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

function Register() {

    const { signup } = useAuth();
    const navigate = useNavigate();

    const[email, setEmail] = useState('');
    const[username, setUsername] = useState('');
    const[emailConf, setEmailConf] = useState('');
    const[senha, setSenha] = useState('');
    const[error, setError] = useState(''); 
    
    async function handleRegister() {
        
        if (!email || !emailConf || !senha) {
            setError("Preencha todos os campos");
            return;
        } else if (email !== emailConf) {
            setError("Os e-mails não são iguais")
        }
        
        console.log('inicio');
        const request = await fetch('http://localhost:4567/user', {
            method: 'POST',
            mode: 'no-cors',
            body: JSON.stringify({ email: emailConf, username: username, password: senha }),
            headers: {
              'Content-type': 'application/json; charset=UTF-8',
            },
          });

        if(request) {alert('usuário cadastrado com sucesso!') } else { alert('Erro ao cadastrar o usuário!') }
        navigate('/login');

    }

    return(<div className="login-box">
        
        <form className="login" method="post"> 
            <p className="login-title">Crie sua conta no MeTune </p>
            
            <div className="field">
                <label for="email">Seu Nome de Usuário:</label>
                <Form.Group className="mb-3"><Form.Control type="text" placeholder='Ex.: joao888.musical' value={username} onChange={(e) => [setUsername(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>  
            
            <div className="field">
                <label for="email">Seu E-Mail:</label>
                <Form.Group className="mb-3"><Form.Control type="email" placeholder='exemplo@email.com' value={email} onChange={(e) => [setEmail(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>  
            
            <div className="field">
                <label for="email">Confirme seu E-mail</label>
                <Form.Group className="mb-3"><Form.Control type="email" placeholder='exemplo@email.com' value={emailConf} onChange={(e) => [setEmailConf(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>  

            <div className="field">
                <label for="senha">Nova Senha:</label>
                <Form.Group className="mb-3"><Form.Control type="password" value={senha} onChange={(e) => [setSenha(e.target.value), setError("")]}/><Form.Text className="text"></Form.Text></Form.Group>
            </div>
            <label className="error-message">{error}</label><br></br>
            <Button variant="success" onClick={handleRegister}>Cadastrar</Button>

            <div>
                Já tem uma conta?<br></br>
                <strong><Link to="/login">Realize o login aqui!</Link></strong>
            </div>

        </form>
    </div>)
}

export default Register;
