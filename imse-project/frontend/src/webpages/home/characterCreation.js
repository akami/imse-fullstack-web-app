import React, {useEffect, useState} from 'react';
import {Button, Carousel, CarouselItem, Col, Container, Form, Image, Row} from "react-bootstrap";

import Mage from "../../assets/mage.png";
import Fighter from "../../assets/fighter.png";
import Knight from "../../assets/knight.png";
import Priest from "../../assets/priest.png";
import Ranger from "../../assets/ranger.png";
import Thief from "../../assets/thief.png";

import {useHistory} from "react-router-dom";
import Cookies from "universal-cookie/lib";

// TODO @kh

const CharacterCreation = () => {
    let history = useHistory();
    const cookies = new Cookies();

    const [index, setIndex] = useState(0);
    const [success, setSuccess] = useState(false);
    const [inProgress, setInProgress] = useState(false);

    const [classes, setClasses] = useState([]);
    const [selectedClass, setSelectedClass] = useState([]);

    const [characterName, setCharacterName] = useState("");
    const [playerId, setPlayerId] = useState(cookies.get('playerId'));

    useEffect(() =>  {
        let mounted = true;

        if (mounted) {
            (async () => {
                await fetch('/api/class')
                    .then((response) => response.json())
                    .then((json) => setClasses(json));
            })();
        }

        return function cleanup () {
            mounted = false;
        }
    },[]);

    const handleSelect = (selectedIndex, e) => {
        setIndex(selectedIndex);

        for (let i = 0; i < classes.length; i++) {
            if (selectedIndex === i) {
                setSelectedClass(classes[i]);
            }
        }
    };

    const getImageFromClassName = (cl) => {
        if (cl != null) {
            switch (cl) {
                case "Mage":
                    return Mage;
                    break;
                case "Knight":
                    return Knight;
                    break;
                case "Fighter":
                    return Fighter;
                    break;
                case "Priest":
                    return Priest;
                    break;
                case "Ranger":
                    return Ranger;
                    break;
                case "Thief":
                    return Thief;
                    break;
            }
        }
    }

    const createCharacter = () => {
        (async () => {
            const response = await fetch('/api/character', {
                method: 'POST',
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify({
                    characterName: characterName,
                    attack: selectedClass.bonusAttack + 100,
                    lifepointAmount: selectedClass.bonusLifepoints + 100,
                    playerId: playerId,
                    characterClassId: selectedClass.classId
                })
            });

            history.goBack();
        })();
    }

    return (
        <Container className="App Home-content" style={{marginTop: 150}}>
            <p className="Text-header1">Character Creation</p>
            <Row>
                <Col md="6">
                    <Image src={getImageFromClassName(selectedClass.className)} width="460" height="500"/>
                </Col>
                <Col md="4" style={{paddingTop:100}}>
                    <div className="Creation-form" >
                        <Form>
                            <Row>
                                <Form.Group controlId="formCharacterName">
                                    <Form.Label>Choose a name for your character</Form.Label>
                                    <Form.Control type="name" placeholder="Enter name" onChange={(text) => setCharacterName(text.target.value)}/>
                                    <Form.Text className="text-muted">
                                    </Form.Text>
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Choose a class for your character</Form.Label>
                                    <Carousel activeIndex={index} interval={60000} onSelect={handleSelect}>
                                        {classes.map((charClass, idx) => {
                                            return (
                                                <CarouselItem interval={60000}>
                                                    <p>{charClass.className}</p>
                                                </CarouselItem>
                                            );
                                        })}
                                    </Carousel>
                                </Form.Group>
                            </Row>
                            <Row>
                                <p className="Text-header2">Preview</p>
                                <p> Bonus Attack: {selectedClass.bonusAttack}</p>
                                <p> Bonus Life Points: {selectedClass.bonusLifepoints}</p>
                            </Row>
                            <Row>
                                <Button type="button" variant="success" onClick={() => createCharacter()}> Create </Button>
                            </Row>
                        </Form>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};
export default CharacterCreation;
