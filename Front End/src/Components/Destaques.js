import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

import Axios from 'axios';
import qs from 'qs';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { DestaquesDiv } from './styles/Styles.js';

class Destaques extends React.Component {

    render () {
        return (

            <DestaquesDiv>
                <div className="destaques-box">
                    <h1> DESTAQUES DA SEMANA </h1>
                    <div className="lista-destaque">
                        <div className="item-lista">
                            <div className="item-titulo">
                                <h2>titulo musica aqui</h2>
                            </div>
                            <div className="item-info">
                                <span className="item-autor">mc dindin</span>
                                <span className="item-duracao">3:29</span>
                            </div>
                            <div className="botao-play">

                            </div>
                        </div>
                    </div>
                </div>
            </DestaquesDiv>

        );
    }

}

export default Destaques;