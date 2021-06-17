import React from 'react';
import {Button, Col, Container, Figure, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

import Mage from "../assets/mage.png";
import Fighter from "../assets/fighter.png";
import Tank from "../assets/tank.png";

const Character = (character) => {
 let history = useHistory();

 const getImageFromClassId = () => {
     switch (character.characterClassID) {
         case 0:
             return (Mage);
             break;
         case 1:
             return (Fighter);
             break;
         case 2:
             return (Tank);
             break;
         default:
             return (Mage);
     }
 }

    return(
        <Container className=" Character-container" style={{paddingBottom: 16}}>
            <Row style={{backgroundColor: "white"}}>
                <Col md="auto">
                    <Row>
                        <Figure>
                            <Figure.Image src={getImageFromClassId()} width="172" height="180"/>
                        </Figure>
                    </Row>
                    <Row>
                        <Button variant="secondary" type="button"> View Skins</Button> {' '}
                        <Button style={{marginTop: 8}} variant="secondary" type="button"> View Pets</Button>
                    </Row>

                </Col>
                <Col md={8}>
                    <div className="Character-description">
                        <p>{character.charClass}</p>
                        <p>{character.name}</p>
                        <p>{character.attack}</p>
                    </div>
                </Col>
                <Col md={2} className="d-flex justify-content-lg-center">
                    <div>
                        <Button variant="primary" type="button" onClick={() => history.push("/quests")}> Start Game </Button> {' '}
                    </div>
                </Col>
            </Row>
        </Container>
    );
};
export default Character;
