import React from 'react';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import 'bootstrap/dist/css/bootstrap.min.css';

import Logo from '../img/logo.jpg';
import LogoMetune from '../img/metune.jpg'

import Image from 'react-bootstrap/Image'
import Figure from 'react-bootstrap/Figure';

import { BsFillPersonFill } from "react-icons/bs";

import '../App.css';

function Header () {
    return (
        <Navbar bg="light" expand="lg">
          <Container fluid>
            <Navbar.Brand href="#">
                <Figure className="logo-header">
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
                </Figure>
            </Navbar.Brand>
            <Navbar.Toggle aria-controls="navbarScroll" />
            <Navbar.Collapse id="navbarScroll">
              <Nav
                className="me-auto my-2 my-lg-0 justify-content-end menu-header"
                style={{ maxHeight: '100px' }}
                navbarScroll
              >
                <Nav.Link href="#action1">Home</Nav.Link>
                <Nav.Link href="#action2">Link</Nav.Link>
                <NavDropdown title="Link" id="navbarScrollingDropdown">
                  <NavDropdown.Item href="#action3">Action</NavDropdown.Item>
                  <NavDropdown.Item href="#action4">
                    Another action
                  </NavDropdown.Item>
                  <NavDropdown.Divider />
                  <NavDropdown.Item href="#action5">
                    Something else here
                  </NavDropdown.Item>
                </NavDropdown>
              </Nav>
              <Form className="d-flex">
                <Form.Control
                  type="search"
                  placeholder="Quero escutar..."
                  className="me-2"
                  aria-label="Pesquisar"
                />
                <Button variant="light">Vamos Lá!</Button>
              </Form>
              <BsFillPersonFill />
            </Navbar.Collapse>
          </Container>
        </Navbar>
      );
}

export default Header;