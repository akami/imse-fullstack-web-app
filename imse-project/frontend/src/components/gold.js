import React, {useEffect, useState} from 'react';
import Cookies from "universal-cookie/lib";
import {Image} from "react-bootstrap";

import Coins from '../assets/coins.png'
import {useHistory} from "react-router-dom";

const Gold = () => {
    let history = useHistory();
    let cookies = new Cookies();

    const [database, setDatabase] = useState('maria');
    const [playerId, setPlayerId] = useState(cookies.get('playerId'));
    const [goldAmount, setGoldAmount] = useState(0);

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/player/gold/' + playerId)
                .then((response) => response.json())
                .then((json) => setGoldAmount(json))
                .then((json) => console.log(json));
        })();
        cookies.set('goldAmount', goldAmount, {path: '/'})
    }, [playerId, goldAmount]);

    return (
        <div style={{marginRight: '8px'}}>
            <Image src={Coins} width={20} height={'auto'}/> {' '}
            <span className="Text-subtitle">{goldAmount}</span>
        </div>
    );
};
export default Gold;
