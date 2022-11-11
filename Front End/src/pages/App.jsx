// import logo from './logo.svg';
import '../App.css';

import Header from '../Components/Header.js';
import Footer from '../Components/Footer.js';
import Banner from '../Components/Banner.js';
import SobreNos from '../Components/SobreNos';
// import ListaUsuarios from '.src/Components/ListaUsuarios.js';
// import ListaMusicas from '.src/Components/ListaMusicas.js';
// import ListaGeneros from '.src/Components/ListaGeneros.js';
// import MusicBox from '.src/Components/MusicBox.js';  
import MusicList from '../Components/MusicList.js';

import {Routes, Route} from 'react-router-dom';
import {Link} from 'react-router-dom';

import Home from './Home';
import Sobre from './Sobre'; 
import Login from './Login';
import Register from './Register';
import Profile from './Profile';

import {createContext, useContext} from 'react';

function App() {

  return (

    <div className='body-container'>
    <Header></Header>
      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/sobrenos" element={<Sobre/>}/>
        <Route path="/login" element={<Login/>}/>
        <Route path="/registrar" element={<Register/>}/>
        <Route path="/perfil" element={<Profile/>}/>
      </Routes>
      <Footer></Footer>
    </div>

  );
}
export default App;
