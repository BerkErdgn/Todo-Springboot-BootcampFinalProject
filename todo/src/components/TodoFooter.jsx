import React from 'react';
import { FaGithub, FaLinkedin, FaEnvelope } from 'react-icons/fa';

function TodoFooter() {


  return (
    <footer style={{backgroundColor: '#24a2b8', color: 'white',padding: '20px 0',textAlign: 'center',position: 'relative',bottom: 0,width: '100%', }}>
      <div style={{display: 'flex',flexDirection: 'column',alignItems: 'center',justifyContent: 'center'}}>
        <div style={{marginBottom: '10px'}}>
          <a  
          href="https://github.com/BerkErdgn" 
          target="_blank" 
            rel="noopener noreferrer" 
            style={{color: 'white',margin: '0 15px', textDecoration: 'none'}}
          >
            <FaGithub size={24} />
          </a>
          <a 
            href="https://www.linkedin.com/in/berk-erdgn/" 
            target="_blank" 
            rel="noopener noreferrer" 
            style={{color: 'white',margin: '0 15px' 
            }}
          >
            <FaLinkedin size={24} />
          </a>
          <a 
            href="mailto:erdgnberk@gmail.com" 
            style={{color: 'white',margin: '0 15px' }}
          >
            <FaEnvelope size={24} />
          </a>
        </div>
        <div style={{width: '90%', height: '1px',backgroundColor: 'white',  margin: '10px auto'}}></div>
        <div style={{fontSize: '14px'}}>
          © 2024 Copyright:
          <a 
            href="/" 
            target="_blank" 
            rel="noopener noreferrer" 
            style={{color: 'white', textDecoration: 'none',marginLeft: '5px', marginRight: '5px' }} 
            onMouseOver={(e) => e.target.style.textDecoration = 'underline'} 
            onMouseOut={(e) => e.target.style.textDecoration = 'none'}
          >
            Berk Erdoğan
          </a>
        </div>
      </div>
    </footer>
  );// end return
}// end function TodoFooter

export default TodoFooter;
