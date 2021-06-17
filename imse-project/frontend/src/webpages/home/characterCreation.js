import React, {useState} from 'react';
import {Button, Carousel, CarouselItem, Col, Container, Form, Image, Row} from "react-bootstrap";

import Mage from "../../assets/mage.png";
import Fighter from "../../assets/fighter.png";
import Tank from "../../assets/tank.png";

import {useHistory} from "react-router-dom";

/**
 * TODO @kh:
 * - submission form creates new character in database
 * - styling
 */


const CharacterCreation = () => {
    let history = useHistory();
    const [selectedClass, setSelectedClass] = useState("Mage");
    const [index, setIndex] = useState(0);

    let classList = ["Mage", "Tank", "Fighter"];

    const handleSelect = (selectedIndex, e) => {
        setIndex(selectedIndex);

        for (let i = 0; i < classList.length; i++) {
            if (selectedIndex == i) {
                setSelectedClass(classList[i]);
            }
        }
    };

    const getImageFromClass = (cl) => {
        if (cl != null) {
            switch (cl) {
                case "Mage":
                    return Mage;
                    break;
                case "Tank":
                    return Tank;
                    break;
                case "Fighter":
                    return Fighter;
                    break;
            }
        }
    }

    return (
        <Container className="App Home-content" style={{marginTop: 150}}>
            <p className="Text-header1">Character Creation</p>
            <Row>
                <Col md="6">
                    <Image src={getImageFromClass(selectedClass)} width="460" height="500">
                    </Image>
                </Col>
                <Col md="4" style={{paddingTop:100}}>
                    <div className="Creation-form" >
                        <Form>
                            <Row>
                                <Form.Group controlId="formCharacterName">
                                    <Form.Label>Choose a name for your character</Form.Label>
                                    <Form.Control type="name" placeholder="Enter name"/>
                                    <Form.Text className="text-muted">
                                    </Form.Text>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Choose a class for your character</Form.Label>
                                    <Carousel activeIndex={index} interval={60000} onSelect={handleSelect}>
                                        <CarouselItem interval={60000}>
                                            <p>Mage</p>
                                        </CarouselItem>
                                        <CarouselItem interval={60000}>
                                            <p>Tank</p>
                                        </CarouselItem>
                                        <CarouselItem interval={60000}>
                                            <p>Fighter</p>
                                        </CarouselItem>
                                    </Carousel>
                                </Form.Group>
                            </Row>
                            <Row>
                                <p>Preview</p>
                                <p> Attack: 1000</p>
                            </Row>
                            <Row>
                                <Button type="submit" variant="success" onClick={() => {this.history.replace("/home")}}> Submit </Button>
                            </Row>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};
export default CharacterCreation;
