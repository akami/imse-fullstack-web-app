import React, {useState} from 'react';
import {Button, Col, Container, Row, Tab, Tabs} from "react-bootstrap";
import ResultList from "../../components/data/resultList";
import {useHistory} from "react-router-dom";

const AdminReports = () => {
    let history = useHistory();

    const [selectedTab, setSelectedTab] = useState('popular-skins');

    return (
        <div className="App">
            <div className="Greeting-header-small">
                <div>
                    <p>
                        University of Vienna | IMSE SS2021
                    </p>
                </div>
                <div>
                    <Button variant="secondary" type="button" onClick={() => history.push("/admin")}> Go Back </Button> {' '}
                </div>
            </div>
            <Container className="App Home-content" style={{marginTop: 50}}>
                <Row>
                    <Col md={2}> </Col>
                    <Col md={8}>
                        <p className="Text-header1">Report Overview</p>
                    </Col>
                    <Col md={2}>
                    </Col>

                </Row>

                <Tabs activeKey={selectedTab} id="database" onSelect={(key) => setSelectedTab(key)}>
                    <Tab eventKey="popular-skins-maria" title="Popular Skins MariaDb" id="popular-skins-maria">
                        <ResultList url={'/api/maria/skin/report'}
                                    headers={['Class ID', 'Skin ID', 'Skin Name', 'Amount Bought']}
                                    fieldNames={['characterClassId', 'skinId', 'skinName', 'boughtAmount']}/>
                    </Tab>
                    <Tab eventKey="popular-skins-mongo" title="Popular Skins MongoDb" id="popular-skins-mongo">
                        <ResultList url={'/api/mongo/skin/report'}
                                    headers={['Skin ID', 'Amount Bought']}
                                    fieldNames={['skinId', 'boughtAmount']}/>
                    </Tab>
                    <Tab eventKey="popular-classes-maria" title="Popular Classes MariaDb" id="popular-classes-maria">
                        <ResultList url={'/api/maria/class/report'}
                                    headers={['Class ID', 'Class Name', 'Amount Created']}
                                    fieldNames={['characterClassId', 'characterClassName', 'characterAmount']}/>
                    </Tab>
                    <Tab eventKey="popular-classes-mongo" title="Popular Classes MongoDb" id="popular-classes-mongo">
                        <ResultList url={'/api/mongo/class/report'}
                                    headers={['Class ID', 'Amount Created']}
                                    fieldNames={['classId', 'counter']}/>
                    </Tab>
                </Tabs>
            </Container>
        </div>
    );
};
export default AdminReports;
