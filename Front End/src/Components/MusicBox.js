// import Button from 'react-bootstrap/Button';
// import Form from 'react-bootstrap/Form';
// import Table from 'react-bootstrap/Table';
import 'bootstrap/dist/css/bootstrap.css';
import React from 'react';

// import Axios from 'axios';
// import qs from 'qs';

import { BsFillPlayCircleFill } from "react-icons/bs";

import 'react-confirm-alert/src/react-confirm-alert.css'; // Import css

import { MusicBoxDiv } from './styles/Styles.js';

class MusicBox extends React.Component { 
    
    secondsToHms(d) {
        d = Number(d);
        var h = Math.floor(d / 3600);
        var m = Math.floor(d % 3600 / 60);
        var s = Math.floor(d % 3600 % 60);
    
        var hDisplay = h > 0 ? h + (h === 1 ? " hora " : " horas ") : "";
        var mDisplay = m > 0 ? m + (m === 1 ? " minuto " : " minutos ") : "";
        var sDisplay = s > 0 ? s + (s === 1 ? " segundo" : " segundos") : "";
        return hDisplay + mDisplay + sDisplay; 
    }

    constructor(props) {
        super(props);

        this.state = {
            autor : '',
        }
    }

    componentDidMount () {
        
        if (this.props.author != '') {            
            fetch('http://localhost:4567/user/' + this.props.author)
                .then(result => result.json())
                .then(dados => {
                this.setState({autor : dados.username});
            });
        }

    }

    render () {
        return (
            <div>
                <MusicBoxDiv>
                    <div className="musicbox-wrapper">
                        <div className="inner-left">
                            <div className="playbutton"> 
                                <BsFillPlayCircleFill size={70} className="playbutton-inner"></BsFillPlayCircleFill>
                            </div>
                        </div>
                        <div className="inner-right">
                            <h3>{this.props.name}</h3>
                            <a href="#"><small>{this.state.autor}</small></a>
                            <small>{this.secondsToHms(this.props.duration)}</small>
                        </div>
                    </div>
                </MusicBoxDiv>
            </div>
        );
    }


}

export default MusicBox;