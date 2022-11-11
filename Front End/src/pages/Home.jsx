// import logo from '.src/logo.svg';
import '../App.css';

import React from 'react';

import Header from '../Components/Header.js';
import Footer from '../Components/Footer.js';
import Banner from '../Components/Banner.js';
import SobreNos from '../Components/SobreNos';
// import ListaUsuarios from '.src/Components/ListaUsuarios.js';
// import ListaMusicas from '.src/Components/ListaMusicas.js';
// import ListaGeneros from '.src/Components/ListaGeneros.js';
// import MusicBox from '.src/Components/MusicBox.js';
import MusicPlayer from '../Components/MusicPlayer.js';
import MusicList from '../Components/MusicList.js';

function Home()  {
    return (<div>
        <div className="banner">
        <Banner></Banner>
        </div>
        <div className="main-content">
            <div className="listBox">
                <h3>Recomendações</h3>
                <MusicList></MusicList>
            </div>
            <div className="listBox">
                <h3>Novas Músicas</h3>
                <MusicList></MusicList>
            </div>
            <div className="listBox">
                <h3>Minhas Músicas</h3>
                <MusicList user={parseInt(localStorage.getItem("logged_user_id"), 10)}></MusicList>
            </div>
        </div>
    </div>);
}

export default Home;
