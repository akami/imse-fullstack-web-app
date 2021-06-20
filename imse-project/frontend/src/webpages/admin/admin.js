import React, {useEffect, useState} from 'react';
import {useHistory} from "react-router-dom";
import {Button, Col, Container, Row, Tab, Tabs} from "react-bootstrap";
import ResultList from "../../components/data/resultList";
import Cookies from "universal-cookie/lib";

const Admin = () => {
    let history = useHistory();
    let cookies = new Cookies();

    const [selectedTab, setSelectedTab] = useState('players');
    const [database, setDatabase] = useState(cookies.get('database'));

    // reload page on database change
    useEffect(() => {}, [database])

    const fillDb = () => {
        const url = '/api/initialize';
        (async () => {
            await fetch(url)
                .then((response) => {
                    console.log(response);
                });
        })();
    };

    const clearDb = () => {
        const url = '/api/clear';
        (async () => {
                await fetch(url)
                    .then((response) => {
                        console.log(response);
                    });
            }
        )();
    };

    const migrateDb = () => {
        const url = '/api/migrate';
        (async () => {
                await fetch(url)
                    .then((response) => {
                        console.log(response);
                    });
            }
        )();

        // set cookie to opposite database
        cookies.set('database', (database === 'maria' ? 'mongo' : 'maria'), {path: '/'});
        setDatabase(cookies.get('database'));
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
                    <Button variant="primary" type="button" onClick={() => history.push("/admin/reports")}> Reports</Button> {' '}
                    <Button variant="success" type="button" onClick={() => fillDb()}> Fill Db</Button> {' '}
                    <Button variant="success" type="button" onClick={() => clearDb()}> Clear Db</Button> {' '}
                    <Button variant="secondary" type="button" onClick={() => history.push("")}> Go Back </Button> {' '}
                </div>
            </div>
            <Container className="App Home-content" style={{marginTop: 50}}>
                <Row>
                    <Col md={2}> </Col>
                    <Col md={8}>
                        <p className="Text-header1">Database Overview</p>
                    </Col>
                    <Col md={2}>
                        <Button variant="primary" type="button" onClick={() => migrateDb()}> To {cookies.get('database')}</Button> {' '}
                    </Col>

                </Row>

                <Tabs activeKey={selectedTab} id="database" onSelect={(key) => setSelectedTab(key)}>
                    <Tab eventKey="players" title="Players" id="players">
                        <ResultList url={'/api/maria/player'}
                                    headers={['Player ID', 'Username', 'Age', 'E-Mail Address']}
                                    fieldNames={['playerId', 'username', 'age', 'emailAddress']}/>
                    </Tab>
                    <Tab eventKey="characters" title="Characters" id="characters">
                        <ResultList url={'/api/maria/character'}
                                    headers={['Character ID', 'Name', 'Attack', 'Life Points', 'Player ID', 'Class ID']}
                                    fieldNames={['characterId', 'characterName', 'attack', 'lifepointAmount', 'playerId', 'characterClassId']}/>
                    </Tab>
                    <Tab eventKey="classes" title="Classes" id="classes">
                        <ResultList url={'/api/maria/class'}
                                    headers={['Class ID', 'Bonus Attack', 'Bonus Life Points', 'Class Name']}
                                    fieldNames={['classId', 'bonusAttack', 'bonusLifepoints', 'className']}/>
                    </Tab>
                    <Tab eventKey="pets" title="Pets" id="pets">
                        <ResultList url={'/api/maria/pet'}
                                    headers={['Pet ID', 'Pet Name', 'Gold Price']}
                                    fieldNames={['petId', 'petName', 'goldPrice']}/>
                    </Tab>
                    <Tab eventKey="player-pets" title="Player Pets" id="player-pets">
                        <ResultList url={'/api/maria/player-pet'}
                                    headers={['Player ID', 'Pet ID']}
                                    fieldNames={['playerId', 'petId']}/>
                    </Tab>
                    <Tab eventKey="skins" title="Skins" id="skins">
                        <ResultList url={'/api/maria/skin'}
                                    headers={['Skin ID', 'Class ID', 'Skin Name', 'Gold Price']}
                                    fieldNames={['skinId', 'classId', 'skinName', 'goldPrice']}/>
                    </Tab>
                    <Tab eventKey="character-skins" title="Character Skins" id="character-skins">
                        <ResultList url={'/api/maria/character-skin'}
                                    headers={['Character ID', 'Skin ID']}
                                    fieldNames={['characterId', 'skinId']}/>
                    </Tab>
                    <Tab eventKey="quests" title="Quests" id="quests">
                        <ResultList url={'/api/maria/quest'}
                                    headers={['Quest ID', 'Quest Name', 'Client Name', 'Quest Reward ID']}
                                    fieldNames={['questId', 'questName', 'clientName', 'questRewardId']}/>
                    </Tab>
                    <Tab eventKey="quest-rewards" title="Quest Rewards" id="quest-rewards">
                        <ResultList url={'/api/maria/quest-reward'}
                                    headers={['Quest Reward ID', 'Gold Amount', 'Experience Amount']}
                                    fieldNames={['questRewardId', 'goldAmount', 'experienceAmount']}/>
                    </Tab>
                    <Tab eventKey="monsters" title="Monsters" id="monsters">
                        <ResultList url={'/api/maria/monster'}
                                    headers={['Monster ID', 'Monster Name', 'Attack', 'Life Point Amount', 'Challenge Rating', 'Monster Loot ID']}
                                    fieldNames={['monsterId', 'monsterName', 'attack', 'lifepointAmount', 'challengeRating', 'monsterLootId']}/>
                    </Tab>
                    <Tab eventKey="allied-monsters" title="Allied Monsters" id="allied-monsters">
                        <ResultList url={'/api/maria/allied-monster'}
                                    headers={['Monster1 ID', 'Monster2 ID']}
                                    fieldNames={['monsterId1', 'monsterId2']}/>
                    </Tab>
                    <Tab eventKey="character-monsters" title="Slayed Monsters" id="character-monsters">
                        <ResultList url={'/api/maria/character-monster'}
                                    headers={['Monster ID', 'Character ID', 'Slayed Amount']}
                                    fieldNames={['monsterId', 'characterId', 'slayAmount']}/>
                    </Tab>
                    <Tab eventKey="monster-loot" title="Monster Loot" id="monster-loot">
                        <ResultList url={'/api/maria/monster-loot'}
                                    headers={['Loot ID', 'Gold Amount', 'Experience Amount']}
                                    fieldNames={['lootId', 'goldAmount', 'experienceAmount']}/>
                    </Tab>
                </Tabs>
            </Container>
        </div>
    );
};
export default Admin;
