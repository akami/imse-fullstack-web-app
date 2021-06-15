import React from 'react';
import {Button, Image} from "react-bootstrap";

const Character= ({character}) => {
    return(
        <div className="Character-container">
            <Image src={character.img} className="Character-image"/>
            <div className="Character-description">
                <p>{character.charClass}</p>
                <p>{character.name}</p>
                <p>{character.attack}</p>
            </div>
            <div>
                <Button variant="primary" type="button"> Start Game </Button> {' '}
                <Button variant="secondary" type="button"> View Skins</Button> {' '}
                <Button variant="secondary" type="button"> View Pets</Button>
            </div>
        </div>
    );
};
export default Character;
