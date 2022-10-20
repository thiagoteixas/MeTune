import logo from './logo.svg';
import './App.css';


import Header from './Components/Header.js';
import Banner from './Components/Banner.js';
import Login from './Components/Login.js';
// import ListaUsuarios from './Components/ListaUsuarios.js';
import ListaMusicas from './Components/ListaMusicas.js';
import ListaGeneros from './Components/ListaGeneros.js';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <div className="banner">
      <Banner></Banner>
      <Login></Login>
      <ListaMusicas></ListaMusicas>
      <ListaGeneros></ListaGeneros>
      </div>
    </div>
  );
}
export default App;
