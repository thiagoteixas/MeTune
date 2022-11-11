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

import { MusicLists } from './styles/Styles.js';

class MusicList extends React.Component { 

    constructor(props) {

        var n = 0;

        super(props);

        this.state = {
            songs : [],
        }

    }

    componentDidMount () {
        fetch('http://localhost:4567/home')
          .then(result => result.json())
          .then(dados => {
            console.log(dados);
            this.setState({songs : dados.musicas});
        });
    }

    componentDidUpdate () {

    }

    render () {
        return (
            <div>                
                <h3>{this.props.title}</h3>
                <MusicLists>
                    <div className="listaMusicas" id="list">                        
                    {this.state.songs.map((song) => 
                        {
                            if (this.props.user == null) {
                                return <MusicBox name={song.name} author={song.author} duration={song.duration} tipo={this.props.tipo} userid={this.props.id}></MusicBox>                      
                            } 
                        }
                    )}
                    </div>
                </MusicLists>
            </div>
        );
    }


}

export default MusicList;