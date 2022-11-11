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

export const MusicLists = styled.div `

display: inline-block;
padding: 30px 20px;
width: 33%;
overflow-x: hidden;
overflow-y: scroll;
height: 300px;
width: fit-content;


/* width */
::-webkit-scrollbar {
  width: 10px;
}

/* Track */
::-webkit-scrollbar-track {
  box-shadow: inset 0 0 2px grey; 
  border-radius: 10px;
}
 
/* Handle */
::-webkit-scrollbar-thumb {
  background: black; 
  border-radius: 10px;
}


h3 {
  width: 100%;
  text-align: center;
}



`;

export const MusicBoxDiv = styled.div`

.musicbox-wrapper {
  width: 450px;
  height: 100px;
  margin: 15px auto;
  background: red;
  display: block;
  background: #d9d9d9;
  border-radius: 20px;
  overflow: hidden;
  border: solid 2px black;
}

.inner-left {
  float: left;
  height: 100%;
  width: 30%;
  display: flex;
  background: #b4b4b4;
  align-items: center;
  justify-content: center;
}

.playbutton {
  margin: 10px;
  height: 100%;
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
}

.playbutton-inner {
  transition: 0.5s all;
  width: fit-content;
  border-radius: 50%;
  border: solid;
  border-width: 0px;
  border-color: transparent;
  color: black;
  cursor: pointer;
}

.playbutton-inner:hover {
   color: white;
   border-color: black;
   border-width: 2px;
   background: black;
}

.inner-right {
  padding-top: 10px;
  display: flex;  
  align-items: center;
  justify-content: center;
  flex-direction: column;
}

.inner-right h3 {
  cursor: pointer;
  transition: 0.5s all;
}

.inner-right h3:hover {
  font-size: 28px;
}

.inner-right a {
  color: black;
  text-decoration: none;
}

.inner-right a:hover {
  text-decoration: underline;
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

export const SobreNosDiv = styled.div`

display: flex;
align-items: center;
justify-content: center;

.SobreNos {
  margin-top: 100px;
  margin-bottom: 100px;
  width: 60%;
  border: solid 2px black;
  padding: 5px;
  border-radius: 20px;
}

.sobre-title {color: #09101a;}

.sobre-text {background-color: #5c5e61; color: white; padding: 5px; text-align: center;}

.sobre-span {font-weight: bold;}

.sobre-table {width: 100%;}

.sobre-td {text-align: center; font-weight: bold; background-color: lightgray;}


`;