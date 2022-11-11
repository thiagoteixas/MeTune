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
import ReactAudioPlayer from 'react-audio-player';

class MusicPlayer extends React.Component { 


    render () {
        return (
        <div>
        <ReactAudioPlayer
            src="./WhatsAppPtt2022-10-27at19.57.46.ogg"
            autoPlay
            controls
        />

        </div>
        );
    }


}

export default MusicPlayer;