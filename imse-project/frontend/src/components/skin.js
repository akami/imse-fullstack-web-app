import React, {useEffect} from 'react';
import {Button, Col, Container, Figure, Image, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

const Skin = ({skin}) => {
    let history = useHistory();

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
                <p>{skin.skinId}</p>
                <p>{skin.classId}</p>
                <p>{skin.skinName}</p>
                <p>{skin.goldPrice}</p>
            </div>
        </Container>
    );
};
export default Skin;
