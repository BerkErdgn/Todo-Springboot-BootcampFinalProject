import React from 'react'
import { Navbar, Container } from 'react-bootstrap';
import { Journals } from 'react-bootstrap-icons';

function TodoHeader() {
  
  return (
    <Navbar style={{ backgroundColor: '#24a2b8' }}> 
            <Container>
                <Navbar.Brand href="/">
                    <Journals size={30} color="white" />{' '}
                    <span style={{ fontWeight: 'bold', color: 'white' }}>Todo-Bootcamp Final Project</span>
                </Navbar.Brand>
            </Container>
    </Navbar>
  ) // end return
}// end function TodoHeader

export default TodoHeader