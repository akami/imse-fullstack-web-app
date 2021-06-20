import React, {useEffect, useState} from 'react';
import Cookies from "universal-cookie/lib";
import {Button, Col, Container, Row} from "react-bootstrap";

import {useHistory} from "react-router-dom";
import SkinList from "../../components/skinList";

const CharacterSkins = () => {
    const history = useHistory();
    const cookies = new Cookies();
    const [skins, setSkins] = useState([]);

    const [classId] = useState(cookies.get('classId'));
    const [database, setDatabase] = useState("maria");

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/skin/' + classId)
                .then((response) => response.json())
                .then((json) => setSkins(json))
                .then((json) => console.log(json));
        })();
    }, [classId]);

    return(
        <Container className="App">
            <Col md={0.5}> </Col>
            <Col md="auto" className="Home-content">
                <Row>
                    <p className="Text-header1">Available Skins</p>
                </Row>
                <Row>
                    <SkinList list={skins}/>
                </Row>
                <Row className="align-content-end">
                </Row>
            </Col>
            <Col md={0.5}> </Col>
            <div>
                {
                    Array.isArray(skins) &&
                    skins.length >= 1 &&
                    skins.map((skin) => {
                        return (
                            <p>{skin.skinName}: {skin.goldPrice}</p>
                        );
                    })

                }

            </div>
        </Container>

    );
}
export default CharacterSkins;
