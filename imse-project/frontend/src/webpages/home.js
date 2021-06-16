import React from 'react';
import {Button, Jumbotron, ListGroup} from "react-bootstrap";
import { useHistory } from 'react-router-dom';
import CharacterList from "../components/characterList";
import Mage from "../assets/mage.png";
import Fighter from "../assets/fighter.png";
import Tank from "../assets/tank.png";

const Home = () => {
    let history = useHistory();
    let characters = [{
        name: "Poppy",
        charClass: "Mage",
        attack: 1000,
        img: Mage
    },{
        name: "Darius",
        charClass: "Fighter",
        attack: 1000,
        img: Fighter
    }, {
        name: "Björn",
        charClass: "Tank",
        attack: 1000,
        img: Tank
    }]

    return (
        <div>
            <div>
                <Button type="button" onClick={() => history.push("/create")}> Create New Character </Button>
            </div>
            <Jumbotron>
                <ListGroup>
                    <CharacterList characters={characters}/>
                </ListGroup>
            </Jumbotron>
        </div>
    );
}
export default Home;
