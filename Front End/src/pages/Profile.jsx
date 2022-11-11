// import logo from '.src/logo.svg';
import '../App.css';

import React from 'react';
import FotoUsuario from '../Components/img/usuario.png'
import ListaMusicas from '../Components/ListaMusicas.js'

import Figure from 'react-bootstrap/Figure';
import ProfileComponent from '../Components/ProfileComponent';

function Profile() {

    const user = localStorage.getItem('logged_user_id');
    return(
        <ProfileComponent user={user}></ProfileComponent>
    )
}

export default Profile;
