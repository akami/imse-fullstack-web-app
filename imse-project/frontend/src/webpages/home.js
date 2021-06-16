import React from 'react';
import {Button, Col, Container, Jumbotron, ListGroup, Row} from "react-bootstrap";
import { useHistory } from 'react-router-dom';
import CharacterList from "../components/characterList";
import Mage from "../assets/mage.png";
import Fighter from "../assets/fighter.png";
import Tank from "../assets/tank.png";

const Home = () => {
    let history = useHistory();
    let characters = [{
        name: "Poppy",
        charClass: "Mage",
        attack: 1000,
        img: Mage
    },{
        name: "Darius",
        charClass: "Fighter",
        attack: 1000,
        img: Fighter
    }, {
        name: "Björn",
        charClass: "Tank",
        attack: 1000,
        img: Tank
    }]

    return (
        <Container className="App">
            <Col md={0.5}></Col>
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
                        <Button type="button" variant="success" size="lg" onClick={() => history.push("/create")}> Create New Character </Button>
                    </div>
                </Row>
            </Col>
            <Col md={0.5}></Col>
        </Container>
    );
}
export default Home;
