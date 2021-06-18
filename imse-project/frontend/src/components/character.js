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
        <Container className=" Character-container" style={{paddingBottom: 16}}>
            <Row style={{backgroundColor: "white"}}>
                <Col md="auto">
                    <Row>
                        <Figure>
                            <Image src={getImageFromClassId(character.characterClassId)} width="172" height="180"/>
                        </Figure>
                    </Row>
                    <Row>
                        <Button variant="secondary" type="button"> View Skins</Button>
                        <Button style={{marginTop: 8}} variant="secondary" type="button"> View Pets</Button>
                    </Row>

                </Col>
                <Col md={8}>
                    <div className="Character-description">
                        <p>{character.characterName}</p>
                        <p>{character.attack}</p>
                        <p>{character.lifepointAmount}</p>
                        <p>{getClassNameFromClassId(character.characterClassId)}</p>
                    </div>
                </Col>
                <Col md={2} className="d-flex justify-content-lg-center">
                    <div>
                        <Button variant="primary" type="button" onClick={() => history.push("/quests")}>Start
                            Game</Button>
                    </div>
                </Col>
            </Row>
        </Container>
    );
};
export default Character;
