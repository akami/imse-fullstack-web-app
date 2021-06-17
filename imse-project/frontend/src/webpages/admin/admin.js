import React, {useState} from 'react';
import {useHistory} from "react-router-dom";
import {Button, Container, Tab, Tabs} from "react-bootstrap";
import ResultList from "../../components/data/resultList";

const Admin = () => {
    let history = useHistory();
    const [selectedTab, setSelectedTab] = useState('players');

    const fillDb = () => {
        const url = '/api/initialize';
        (async () => {
            const response = await fetch(url)
                .then((response) => {
                    console.log(response);
                });
            return response;
        })();
    };

    const clearDb = () => {
        const url = '/api/clear';
        (async () => {
                const response = await fetch(url)
                    .then((response) => {
                        console.log(response);
                    });

                return response;
            }
        )();
    };

    return (
        <div className="App">
            <div className="Greeting-header-small">
                <div>
                    <p>
                        University of Vienna | IMSE SS2021
                    </p>
                </div>
                <div>
                    <Button variant="success" type="button" onClick={() => fillDb()}> Fill Db</Button> {' '}
                    <Button variant="success" type="button" onClick={() => clearDb()}> Clear Db</Button> {' '}
                    <Button variant="secondary" type="button" onClick={() => history.push("")}> Go Back </Button> {' '}
                </div>
            </div>
            <Container className="App Home-content" style={{marginTop: 50}}>
                <p className="Text-header1">Database Overview</p>
                <Tabs activeKey={selectedTab} id="database" onSelect={(key) => setSelectedTab(key)}>
                    <Tab eventKey="players" title="Players" id="players">
                        <ResultList url={'/api/player'}
                                    headers={['Player ID', 'Username', 'Age', 'E-Mail Address']}
                                    fieldNames={['playerId', 'username', 'age', 'emailAddress']}/>
                    </Tab>
                    <Tab eventKey="characters" title="Characters" id="characters">
                        <ResultList url={'/api/character'}
                                    headers={['Character ID', 'Name', 'Attack', 'Life Points', 'Player ID', 'Class ID']}
                                    fieldNames={['characterId', 'characterName', 'attack', 'lifepointAmount', 'playerId', 'characterClassId']}/>
                    </Tab>
                    <Tab eventKey="classes" title="Classes" id="classes">
                        <ResultList url={'/api/class'}
                                    headers={['Class ID', 'Bonus Attack', 'Bonus Life Points', 'Class Name']}
                                    fieldNames={['classId', 'bonusAttack', 'bonusLifepoints', 'className']}/>
                    </Tab>
                    <Tab eventKey="pets" title="Pets" id="pets">
                        <ResultList url={'/api/pet'}
                                    headers={['Pet ID', 'Pet Name', 'Gold Price']}
                                    fieldNames={['petId', 'petName', 'goldPrice']}/>
                    </Tab>
                    <Tab eventKey="player-pets" title="Player Pets" id="player-pets">
                        <ResultList url={'/api/player-pet'}
                                    headers={['Player ID', 'Pet ID']}
                                    fieldNames={['playerId', 'petId']}/>
                    </Tab>
                    <Tab eventKey="skins" title="Skins" id="skins">
                        <ResultList url={'/api/skin'}
                                    headers={['Skin ID', 'Class ID', 'Skin Name', 'Gold Price']}
                                    fieldNames={['skinId', 'classId', 'skinName', 'goldPrice']}/>
                    </Tab>
                    <Tab eventKey="quests" title="Quests" id="quests">
                        <ResultList url={'/api/quest'}
                                    headers={['Quest ID', 'Quest Name', 'Client Name', 'Quest Reward ID']}
                                    fieldNames={['questId', 'questName', 'clientName', 'questRewardId']}/>
                    </Tab>
                    <Tab eventKey="quest-rewards" title="Quest Rewards" id="quest-rewards">
                        <ResultList url={'/api/quest-reward'}
                                    headers={['Quest Reward ID', 'Gold Amount', 'Experience Amount']}
                                    fieldNames={['questRewardId', 'goldAmount', 'experienceAmount']}/>
                    </Tab>
                    <Tab eventKey="monsters" title="Monsters" id="monsters">
                        <ResultList url={'/api/monster'}
                                    headers={['Monster ID', 'Monster Name', 'Attack', 'Life Point Amount', 'Challenge Rating', 'Monster Loot ID']}
                                    fieldNames={['monsterId', 'monsterName', 'attack', 'lifepointAmount', 'challengeRating', 'monsterLootId']}/>
                    </Tab>
                    <Tab eventKey="monster-loot" title="Monster Loot" id="monster-loot">
                        <ResultList url={'/api/monster-loot'}
                                    headers={['Loot ID', 'Gold Amount', 'Experience Amount']}
                                    fieldNames={['lootId', 'goldAmount', 'experienceAmount']}/>
                    </Tab>
                </Tabs>
            </Container>
        </div>
    );
};
export default Admin;
