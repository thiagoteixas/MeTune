import logo from './logo.svg';
import './App.css';


import Header from './Components/Header.js';
import Banner from './Components/Banner.js';

function App() {
  return (
    <div className="App">
      <Header></Header>
      <div className="banner">
      <Banner></Banner>
      </div>
    </div>
  );
}

export default App;
