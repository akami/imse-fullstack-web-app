import React, {useEffect, useState} from 'react';
import {Button, Col, Container, Jumbotron, ListGroup, Row} from "react-bootstrap";
import {useHistory, useLocation} from 'react-router-dom';

import CharacterList from "../../components/characterList";
import Cookies from "universal-cookie/lib";

const Home = () => {
    const history = useHistory();
    const cookies = new Cookies();

    const [show, setShow] = useState(false);

    const [characters, setCharacters] = useState([]);
    const [playerId, setPlayerId] = useState(cookies.get('playerId'));

    useEffect(() =>  {
        let timer = setTimeout(() => setShow(true), 1);
        let mounted = true;

        if (mounted) {
            (async () => {
            await fetch('/api/character/' + playerId)
                .then((response) => response.json())
                .then((json) => setCharacters(json));
            })();
        }

        return function cleanup () {
            mounted = false;
            clearTimeout(timer);
        }
    },[]);

    return (
        <Container className="App">
            <Col md={0.5}> </Col>
            <Col md="auto" className="Home-content">
                <Row>
                    <p className="Text-header1">Your Characters {playerId}</p>
                </Row>
                <Row>
                    <Jumbotron>
                        <ListGroup>
                            <CharacterList characters={characters}/>
                        </ListGroup>
                    </Jumbotron>
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
