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

const CharacterCreation = () => {
    let history = useHistory();
    const cookies = new Cookies();

    const [loaded, setLoaded] = useState(false);

    const [index, setIndex] = useState(0);
    const [success, setSuccess] = useState(false);
    const [inProgress, setInProgress] = useState(false);

    const [classes, setClasses] = useState([]);
    const [selectedClass, setSelectedClass] = useState({});

    const [characterName, setCharacterName] = useState("");

    const [playerId, setPlayerId] = useState(cookies.get('playerId'));
    const [database, setDatabase] = useState(cookies.get('database'));

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/class')
                .then((response) => response.json())
                .then((json) => setClasses(json))
                .then(() => handleSelect(0))
                .then(() => setLoaded(true));
        })();
    }, [loaded]);

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
            let response;
            if (database === 'maria') {
                response = await fetch('/api/' + database + '/character/create', {
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
            } else if (database === 'mongo') {
                response = await fetch('/api/' + database + '/character/create', {
                    method: 'POST',
                    headers: {
                        "Content-type": "application/json"
                    },
                    body: JSON.stringify({
                        characterName: characterName,
                        attack: selectedClass.bonusAttack + 100,
                        lifepointAmount: selectedClass.bonusLifepoints + 100,
                        characterClass: [{
                            bonusAttack: selectedClass.bonusAttack,
                            bonusLifepoints: selectedClass.bonusLifepoints,
                            className: selectedClass.className
                        }]
                    })
                });
            }

            history.goBack();
        })();
    }

    return (
        <div className="App">
            <div className="Creation-header">
                <div>
                    <Button type="button" variant="secondary" onClick={() => history.goBack()}> Go Back</Button> {' '}
                </div>
            </div>
            <Container className="App Home-content" style={{marginTop: 150}}>
                <Row>
                    <Col md="6">
                        <Image src={getImageFromClassName(selectedClass.className)} width="500" height="556"/>
                    </Col>
                    <Col md="4" className="justify-content-lg-center" style={{marginLeft: 60}}>
                        <div className="Creation-form">
                            <p className="Text-header1">Character Creation</p>
                            <Form>
                                <Row className="Creation-form-row">
                                    <Form.Group controlId="formCharacterName" style={{paddingBottom: 20}}>
                                        <Form.Label className="Text-header3">Choose a name for your
                                            character</Form.Label>
                                        <Form.Control type="name" placeholder="Enter name"
                                                      onChange={(text) => setCharacterName(text.target.value)}/>
                                        <Form.Text className="text-muted">
                                        </Form.Text>
                                    </Form.Group>

                                    <Form.Group>
                                        <Form.Label className="Text-header3">Choose a class for your
                                            character</Form.Label>
                                        <Carousel className="Creation-form-carousel" activeIndex={index}
                                                  interval={60000} onSelect={handleSelect}>
                                            {classes.map((charClass, idx) => {
                                                return (
                                                    <CarouselItem interval={60000}>
                                                        <p className="Text-subsubtitle">{charClass.className}</p>
                                                    </CarouselItem>
                                                );
                                            })}
                                        </Carousel>
                                    </Form.Group>
                                </Row>
                                <Row>
                                    <div className="Creation-form-preview">
                                        <p className="Text-header2">Preview</p>
                                        <p> Bonus Attack: <span
                                            style={{color: '#d62828'}}> {selectedClass.bonusAttack} </span></p>
                                        <p> Bonus Life Points: <span
                                            style={{color: '#40916c'}}> {selectedClass.bonusLifepoints}</span></p>
                                    </div>
                                </Row>
                                <Row>
                                    <div>
                                        <Button type="button" variant="success"
                                                onClick={() => createCharacter()}> Create </Button>
                                    </div>
                                </Row>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};
export default CharacterCreation;
