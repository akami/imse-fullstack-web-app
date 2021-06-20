import React, {useState} from 'react';
import {Button, Col, Container, Figure, Image, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

import Mage from "../assets/mage.png";
import Fighter from "../assets/fighter.png";
import Knight from "../assets/knight.png";
import Priest from "../assets/priest.png";
import Ranger from "../assets/ranger.png";
import Thief from "../assets/thief.png";
import Cookies from "universal-cookie/lib";

const Character = ({character}) => {
    const cookies = new Cookies();
    let history = useHistory();

    const [database, setDatabase] = useState(cookies.get('database'));

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

    const redirectToSkinsView = (classId, characterId) => {
        cookies.set('classId', classId, {path: '/'});
        cookies.set('characterId', characterId, {path: '/'});
        history.push("/skins");
    }

    return (
        <Container style={{padding: 8}}>
            <div className="Character-container">
                <Row>
                    <Col md={4}>
                        <Figure>
                            <Image
                                src={getImageFromClassId((database === 'maria') ? character.characterClassId : character.characterClass.classId)}
                                width="280" height="300"/>
                        </Figure>
                    </Col>
                    <Col md={4} style={{paddingTop: 16}}>
                        <div className="Creation-form">
                            <p className="Text-header2">{character.characterName}</p>
                            <p className="Text-subtitle">{getClassNameFromClassId((database === 'maria') ? character.characterClassId : character.characterClass.classId)}</p>
                            <p> Attack: <span style={{color: '#d62828'}}> {character.attack} </span></p>
                            <p> Life Points: <span style={{color: '#40916c'}}> {character.lifepointAmount}</span></p>
                        </div>
                    </Col>
                    <Col md={4} className="d-flex justify-content-lg-center" style={{paddingTop: 16}}>
                        <div>
                            <Row style={{marginTop: 50}}>
                            </Row>
                            <Row style={{marginTop: 16}}>
                                <div>
                                    <Button variant="secondary"
                                            type="button"
                                            onClick={() => redirectToSkinsView((database === 'maria') ? character.characterClassId : character.characterClass.classId, character.characterId)}
                                    > View Skins
                                    </Button>
                                </div>
                            </Row>
                            <Row style={{marginTop: 8}}>
                            </Row>
                        </div>
                    </Col>
                </Row>
            </div>
        </Container>
    );
};
export default Character;
