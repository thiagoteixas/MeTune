
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

import Button from 'react-bootstrap/Button';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import '../App.css';
import FotoUsuario from '../Components/img/usuario.png'
import ListaMusicas from '../Components/ListaMusicas.js'

import Figure from 'react-bootstrap/Figure';
import { Navigate } from 'react-router-dom';

class ProfileComponent extends React.Component { 

    constructor(props) {

        super(props);

        this.state = {
            logged_user : [],
        }

    }

    componentDidMount() {    
        fetch('http://localhost:4567/user/'+this.props.user)
        .then(result => result.json())
        .then(dados => {
        console.log(dados);
        this.setState({logged_user : dados});
    });

    }

    desconectar() {


        if (window.confirm("Deseja realmente se desconectar?")== true) {
            localStorage.setItem("logged_user_id", 0);
            window.location.href = "/";
        }
    }

    render () {
        return(            
                <div className="profile-box">
                <div className="container-profile">
                    <h1>Visão Geral da Conta</h1>
                    <h2> Perfil </h2>

                    <Figure className="logo-metune-header">
                    <Figure.Image
                        width={350}
                        height={100}
                        alt="171x180"
                        src={FotoUsuario}
                    />
                    </Figure>
                    
                    <div className="about"> 
                        <h1>Quantidade de musicas:</h1>
                        <p>8</p>
                    </div>
                    
                    <div>
                        <h2>Detalhes</h2>
                        
                        <span className="negrito">Nome de usuário:</span> <p>{this.state.logged_user.username}</p>
                        <span className="negrito">E-Mail:</span> <p>{this.state.logged_user.email}</p>
                        
                        <img src="img/ico_twitter.png" className="ico"/>
                        <img src="img/ico_insta.png"  className="ico"/>
                        <img src="img/ico_facebook.png" className="ico"/>
                        
                    </div>
                    <div><br></br>                                
                    <Button variant="danger" onClick={() => this.desconectar()}>
                        Desconetar-se
                    </Button><br></br>
                    </div>

                </div>
                <div className="container-div-musicas">
                    <ListaMusicas user={this.props.user}></ListaMusicas>
                </div>
            </div>
        );
    }

}

export default ProfileComponent;