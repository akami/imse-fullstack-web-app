import React, {useEffect, useState} from 'react';
import Cookies from "universal-cookie/lib";
import {Button, Container, Row} from "react-bootstrap";

import {useHistory} from "react-router-dom";
import SkinList from "../../components/skinList";
import Gold from "../../components/gold";

const CharacterSkins = () => {
    const history = useHistory();
    const cookies = new Cookies();

    const [skins, setSkins] = useState([]);
    const [classId] = useState(cookies.get('classId'));
    const [database, setDatabase] = useState(cookies.get('database'));

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/skin/' + classId)
                .then((response) => response.json())
                .then((json) => setSkins(json));
        })();
    }, [classId]);

    return (
        <div className="App">
            <div className="Creation-header">
                    <Gold/>
                    <Button type="button" variant="secondary" onClick={() => history.goBack()}> Go Back</Button> {' '}
            </div>
            <Container className="App Home-content">
                <Row>
                    <p className="Text-header1">Available Skins for Your Character</p>
                </Row>
                <SkinList skins={skins}/>
                <Row className="align-content-end">
                </Row>
            </Container>
        </div>
    );
};

export default CharacterSkins;
