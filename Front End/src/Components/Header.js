import React from 'react';
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import 'bootstrap/dist/css/bootstrap.min.css';

import Logo from './img/logo.jpg';
import LogoMetune from './img/metune.jpg'

import Figure from 'react-bootstrap/Figure';

import { BsFillPersonFill, BsSearch, BsFillHeartFill } from "react-icons/bs";

import {Link} from 'react-router-dom';

import '../App.css';

function Header () {

    var logged_in;

    console.log('local teste', localStorage.getItem("logged_user_id"));

    if (localStorage.getItem("logged_user_id") != '0' ) {
      logged_in = "/perfil"
    } else {
      logged_in = "/login"
    }

    return (
        <Navbar bg="light" expand="lg">
          <Container fluid>
            <Navbar.Brand href="#">
                <Link to="/"><Figure className="logo-header">
                <Figure.Image
                    width={110}
                    height={100}
                    alt="171x180"
                    src={Logo}
                />
                </Figure>
                <Figure className="logo-metune-header">
                <Figure.Image
                    width={350}
                    height={100}
                    alt="171x180"
                    src={LogoMetune}
                />
                </Figure></Link>
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
              <Nav
                className="me-auto my-2 my-lg-0 justify-content-end menu-header"
                style={{ maxHeight: '100px' }}
                navbarScroll
              >
              {/*<BsFillHeartFill size={50} className="icon-header" color="red" />
               <BsSearch size={50} className="icon-header" color="white" />*/ }
              <Link to={logged_in}><BsFillPersonFill size={60} className="icon-header" color="white" /></Link>
              </Nav>
            </Navbar.Collapse>
          </Container>
        </Navbar>
      );
}

export default Header;