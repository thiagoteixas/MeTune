import styled from 'styled-components';

import imgBanner from '../img/banner.png';

export const LoginContainer = styled.div`

align-items:center;
justify-content:center;
margin: 50px 0px;

form {
    margin: 0px 30px;
    width: 50%;
}

.wrapper {

    justify-content:center;
    display: flex;
    position: relative;
    margin-left: auto;
    margin-right: auto;
    padding: 20px;
    border-radius: 20px;
    width: 60%;

    background-color: #e0e0e0;
    
    box-shadow: 5px 5px 5px rgba(45,45,45,0.5);

}

h1 {

  text-align: center;
  
}


h2 {

    text-align: center;
    padding: 10px;
    text-transform: uppercase;

}

a {

    margin-top: 20px;

}

button {

    width: 100%;

}

`;

export const BannerContainer = styled.div`

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

a {

  text-decoration: none;

}

`;

export const TableContainer = styled.div`

align-items:center;
margin: 50px 0px;
position: relative;
margin-left: auto;
margin-right: auto;
width: 60%;

h1 {

  text-align: center;
  
}

table {
  margin-top: 20px;
  width: 100%;
}

select {

  margin-bottom: 20px;

}

`;