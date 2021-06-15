import './App.css';
import './styles/Greetings.css';

import React, { useState, useEffect } from 'react';

import Root from './webpages';
function App() {
  const [characters, setCharacters] = useState([]);
  //
  // useEffect(() => {
  //     let mounted = true;
  //
  //     if (mounted) {
  //         // TODO @kh
  //         // (async () => {
  //         //     let response = await fetch('/api/characters');
  //         //     let body = await response.json();
  //         // })();
  //
  //
  //         setTimeout(() => {
  //             // do nothing and wait for 3 seconds
  //         }, 3000)
  //     }
  //
  //     return () =>  {
  //         mounted = false;
  //     }
  //
  // },[]);

  return (
        <div>
            <Root/>
        </div>
  );
}

export default App;
