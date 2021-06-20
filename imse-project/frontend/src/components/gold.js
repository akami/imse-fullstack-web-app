import React, {useEffect, useState} from 'react';
import Cookies from "universal-cookie/lib";
import {Button, Col, Container, Image, Row} from "react-bootstrap";

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
        <Container>
            <Row>
                <Col md={2}/>
                <Col md={2}>
                    <Image src={Coins} width={20} height={20}/>
                </Col>
                <Col md={2}>
                    <p className="Text-subtitle">{goldAmount}</p>
                </Col>
                <Col md={1}/>
            </Row>
        </Container>
    );
};
export default Gold;
