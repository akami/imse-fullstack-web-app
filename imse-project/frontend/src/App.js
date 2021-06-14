import logo from './logo.svg';
import './App.css';

import React, { useState, useEffect } from 'react';
import CharacterList from "./components/CharacterList";

function App() {
  const [characters, setCharacters] = useState(undefined);

  useEffect(() => {
      let mounted = true;

      if (mounted) {
          (async () => {
              let response = await fetch('/api/characters');
              let body = await response.json();
          })();


          setTimeout(() => {
              // do nothing and wait for 3 seconds
          }, 3000)
      }

      return () =>  {
          mounted = false;
      }

  },[]);

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
        <CharacterList characters={characters}/>
    </div>
  );
}

export default App;
