import React from 'react';
import {Button, Col, Container, Figure, Image, Row} from "react-bootstrap";

const Character= ({character}) => {
    return(
        <Container className=" Character-container">
            <Row className="row" style={{backgroundColor: "white"}}>
                <Col md="auto">
                    <Row>
                        <Figure>
                            <Figure.Image src={character.img} width="172" height={"180"}/>
                        </Figure>
                    </Row>
                    <Row>
                        <Button variant="secondary" type="button"> View Skins</Button> {' '}
                        <Button style={{top: 16}} variant="secondary" type="button"> View Pets</Button>
                    </Row>

                </Col>
                <Col md lg="2">
                    <div className="Character-description">
                        <p>{character.charClass}</p>
                        <p>{character.name}</p>
                        <p>{character.attack}</p>
                    </div>
                </Col>
                <Col md lg="2">
                    <div>
                        <Button variant="primary" type="button"> Start Game </Button> {' '}
                    </div>
                </Col>
            </Row>
        </Container>
    );
};
export default Character;
