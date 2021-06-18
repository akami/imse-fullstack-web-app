import React, {useEffect, useState} from 'react';
import {Button, Col, Container, Jumbotron, ListGroup, Row} from "react-bootstrap";
import {useHistory} from 'react-router-dom';

import CharacterList from "../../components/characterList";
import Cookies from "universal-cookie/lib";

const Home = () => {
    const history = useHistory();
    const cookies = new Cookies();

    const [characters, setCharacters] = useState([]);
    const [playerId] = useState(cookies.get('playerId'));

    useEffect(() => {
        (async () => {
            await fetch('/api/character/' + playerId)
                .then((response) => response.json())
                .then((json) => setCharacters(json));
        })();
    }, [playerId]);

    return (
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
    );
}
export default Home;
