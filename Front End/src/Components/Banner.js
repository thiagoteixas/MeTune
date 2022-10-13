import {BannerContainer} from './styles/Styles.js';

function Banner() {

  return (

    <BannerContainer>

      <div>
        <h2>Bem vindo</h2>
        <h1>MeTune!</h1>
        <p>A plataforma para suas músicas favoritas!!</p>
        <span>Não tem um cadastro?</span>
        <a href="#login-cadastro"><button>Cadastre-se agora</button></a>
      </div>

    </BannerContainer>

  );

}

export default Banner;