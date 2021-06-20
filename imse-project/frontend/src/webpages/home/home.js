import React, {useEffect, useState} from 'react';
import {Button, Col, Container, Row} from "react-bootstrap";
import {useHistory} from 'react-router-dom';

import CharacterList from "../../components/characterList";
import Gold from "../../components/gold";
import Cookies from "universal-cookie/lib";

const Home = () => {
    const history = useHistory();
    const cookies = new Cookies();

    const [characters, setCharacters] = useState([]);
    const [playerId] = useState(cookies.get('playerId'));
    const [database, setDatabase] = useState("maria");

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/character/' + playerId)
                .then((response) => response.json())
                .then((json) => setCharacters(json));
        })();
    }, [playerId]);

    return (
        <div className="App">
            <div className="Creation-header2">
                <Gold/>
                <div>
                    <Button type="button" variant="danger" onClick={() => history.goBack()}> Log Out</Button> {' '}
                </div>
            </div>
        <Container className="App">
            <Col md={0.5}> </Col>
            <Col md="auto" className="Home-content">
                <Row>
                    <p className="Text-header1">Your Characters</p>
                </Row>
                <Row>
                    <CharacterList characters={characters}/>
                </Row>
                <Row className="align-content-end">
                    <div>
                        <Button type="button" variant="success" size="lg"
                                onClick={() => history.push("/create")}> Create New Character </Button>
                    </div>
                </Row>
            </Col>
            <Col md={0.5}> </Col>
        </Container>
        </div>
    );
}
export default Home;
