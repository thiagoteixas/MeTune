import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useRef } from 'react';
import 'bootstrap/dist/css/bootstrap.css';

import { LoginContainer } from './styles/Styles.js';

function Login () {

    const nomeRef = useRef(null);

    return( 
        <div>
        <LoginContainer>            
            <h1>CADASTRO E LOGIN</h1>
            <div className="wrapper">
                <Form>
                <h2>Cadastrar-se</h2>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Novo nome de Usuário</Form.Label>
                    <Form.Control type="text" placeholder="Ex: joao.18music..." />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>          
                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Nova senha</Form.Label>
                    <Form.Control type="password" placeholder="" />
                </Form.Group>
            
            <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Confirme sua senha</Form.Label>
                <Form.Control type="password" placeholder="" />
            </Form.Group>
                <Button variant="dark" type="submit">
                    Cadastrar-se
                </Button><br></br>
                </Form>
                <Form>
                <h2>Entrar</h2>
                <Form.Group className="mb-3" controlId="formBasicEmail">
                    <Form.Label>Nome de Usuário</Form.Label>
                    <Form.Control type="text" placeholder="Ex: joao.18music..." />
                    <Form.Text className="text-muted">
                    </Form.Text>
                </Form.Group>
            
                <Form.Group className="mb-3" controlId="formBasicPassword">
                    <Form.Label>Senha</Form.Label>
                    <Form.Control type="password" placeholder="" />
                </Form.Group>
                <Button variant="dark" type="submit">
                    Entrar
                </Button><br></br>
                </Form>

            </div>
        </LoginContainer>
        </div>

    );

}

export default Login;