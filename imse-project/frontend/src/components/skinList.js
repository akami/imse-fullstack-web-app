import React from 'react';
import Skin from "./skin";
import {Row} from "react-bootstrap";

const SkinList = ({skins}) => {
    return (
        <Row style={{margin: 16}}>
            {
                Array.isArray(skins) &&
                skins.length >= 1 &&
                skins.map((skin) => {
                    return (
                        <Skin skin={skin}/>
                    );
                })

            }
        </Row>
    );
};
export default SkinList;
