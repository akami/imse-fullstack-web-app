import React from 'react';
import {Button, Col, Container, Figure, Image, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

import Mage from "../assets/mage.png";
import Fighter from "../assets/fighter.png";
import Knight from "../assets/knight.png";
import Priest from "../assets/priest.png";
import Ranger from "../assets/ranger.png";
import Thief from "../assets/thief.png";

const Character = ({character}) => {
    let history = useHistory();

    const getImageFromClassId = (classId) => {
        switch (classId) {
            case 0:
                return Mage;
            case 1:
                return Knight;
            case 2:
                return Priest;
            case 3:
                return Fighter;
            case 4:
                return Ranger;
            case 5:
                return Thief;
        }

        return undefined;
    }

    // TODO @kh fetch from database
    const getClassNameFromClassId = (classId) => {
        switch (classId) {
            case 0:
                return "Mage";
            case 1:
                return "Knight";
            case 2:
                return "Priest";
            case 3:
                return "Fighter";
            case 4:
                return "Ranger";
            case 5:
                return "Thief";
        }

        return undefined;
    }

    return (
        <Container style={{padding: 8}}>
            <div className="Character-container">
                <Row>
                    <Col md={4}>
                        <Figure>
                            <Image src={getImageFromClassId(character.characterClassId)} width="280" height="300"/>
                        </Figure>
                    </Col>
                    <Col md={4} style={{paddingTop: 16}}>
                        <div className="Creation-form" >
                            <p className="Text-header2">{character.characterName}</p>
                            <p className="Text-subtitle">{getClassNameFromClassId(character.characterClassId)}</p>
                            <p> Attack: <span style={{color: '#d62828'}}> {character.attack} </span></p>
                            <p> Life Points: <span style={{color: '#40916c'}}> {character.lifepointAmount}</span></p>
                        </div>
                    </Col>
                    <Col md={4} className="d-flex justify-content-lg-center" style={{paddingTop: 16}}>
                        <div>
                            <Row style={{marginTop: 50}}>
                                    <Button
                                        variant="primary"
                                        type="button"
                                        onClick={() => history.push("/quests")}
                                    >
                                        Start Game
                                    </Button> {' '}
                            </Row>
                            <Row style={{marginTop: 16}}>
                                <Button variant="secondary" type="button" > View Skins</Button>
                            </Row>
                            <Row style={{marginTop: 8}}>
                                <Button  variant="secondary" type="button"> View Pets</Button>
                            </Row>
                        </div>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};
export default Character;
