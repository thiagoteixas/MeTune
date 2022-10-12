import Carousel from 'react-bootstrap/Carousel';
import styled from 'styled-components';

import imgBanner from '../img/banner.png';

const BannerContainer = styled.div`
  height: 50vh;
  display: flex;
  align-items:center;
  justify-content:center;
  background-image: url(${imgBanner});
  background-position: center;
  background-size: cover;
  text-align: center;
  position: relative;

  text-align: center;

  &:after {

    content: "";
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;

    background-color: rgba(46,46,46,0.8);

  }

  div {

    z-index: 10;

  }

  h2 {

    text-transform: uppercase;
    font-size: 1.2rem;
    color: white;
    margin: 0;
    margin-bottom: 1rem;

  }

  h1 {

    font-size: 2.8rem;
    font-weight: bold;
    color: black;
    padding: 0px 25px;
    margin-bottom: 1rem;

    background-color: white;

  }

  p{

    font-size: 1rem;
    color: white;
    font-weight: bold;

  }

  span {

    color: white;
    font-weight: 600;
    margin-bottom: 10px;

  }

  button {

    min-width: 150px;
    border: solid 2px #FFFFFF;
    border-radius: 42px;
    display: block;
    align-items: center;
    text-align: center;
    color: white;
    background-color: transparent;
    font-size: 1rem;
    padding: 10px 15px;
    margin: auto;
    transition: 0.35s all;
    font-weight: bold;
    margin-top: 10px;

  }

  button:hover {

    background-color: white;
    color: black;

  }



`;

function Banner() {

  return (

    <BannerContainer>

      <div>
        <h2>Bem vindo</h2>
        <h1>MeTune!</h1>
        <p>A plataforma para suas músicas favoritas!!</p>
        <span>Não tem um cadastro?</span>
        <button>Cadastre-se agora</button>
      </div>

    </BannerContainer>

  );

}

export default Banner;