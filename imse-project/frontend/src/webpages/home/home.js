import React, {useEffect, useState} from 'react';
import {Button, Col, Container, Jumbotron, ListGroup, Row} from "react-bootstrap";
import {useHistory} from 'react-router-dom';

import CharacterList from "../../components/characterList";

import Mage from "../../assets/mage.png";
import Fighter from "../../assets/fighter.png";
import Tank from "../../assets/tank.png";

const Home = (authDetails) => {
    let history = useHistory();
    const [show, setShow] = useState(false);
    const [characters, setCharacters] = useState([]);


    useEffect(() =>  {
        let timer = setTimeout(() => setShow(true), 1);
        let mounted = true;

        let url = '/api/character';

        if (mounted) {
            (async () => {
                const response = await fetch(url, {
                    method: 'GET',
                    headers: {
                        'Authorization': 'Basic ' + Buffer.from(authDetails[0] + ":" + authDetails[1]).toString('base64')
                    }
                })
                    .then((response) => {
                        setCharacters(response.body);
                    });
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
                    <p className="Text-header1">Your Characters</p>
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
