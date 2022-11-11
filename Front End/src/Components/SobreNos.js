// import Button from 'react-bootstrap/Button';
// import Form from 'react-bootstrap/Form';
// import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

// import Axios from 'axios';
// import qs from 'qs';

import { BsFillPlayCircleFill } from "react-icons/bs";
import MusicBox from './MusicBox.js';

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { SobreNosDiv } from './styles/Styles.js';

class MusicList extends React.Component { 

    render () {
        return (
            <div>
                <SobreNosDiv>
                    <div className="SobreNos">
                        <h3 className="sobre-title">Sobre nós :</h3>
                        <p className="sobre-text">
                            <span className="sobre-span"> Gosto não se discute! </span><br/>  Rede Social de Música Independente.  Recomendações de músicas novas baseadas no gosto musical do  <span className="sobre-span">usuário</span>.
                        </p>
                        <table className="sobre-table">
                            <tr>
                                <td className="sobre-td" colspan="2">Criado por:</td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li> Marco Aurélio de Noronha Santos</li>
                                        <li> Thiago Teixeira Oliveira </li>
                                        <li> Henrique Temponi Maia</li>
                                        <li> Eduarda Silva Santos Nunis</li>
                                        <li> João Vitor Gonzaga Jota</li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td className="sobre-td" colspan="2">Materia:</td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li>Trabalho Interdisciplinar II: </li>
                                        <li>Bancos de Dados e Sistemas Inteligentes</li>
                            
                                    </ul>
                                </td>
                            </tr>
                        </table>   
                    </div>
                </SobreNosDiv>                
            </div>
        );
    }


}

export default MusicList;