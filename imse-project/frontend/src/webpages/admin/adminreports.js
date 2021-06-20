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
                    <Button variant="secondary" type="button" onClick={() => history.push("")}> Go Back </Button> {' '}
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
                    <Tab eventKey="popular-skins" title="Popular Skins" id="popular-skins">
                        <ResultList url={'/api/maria/skin/report'}
                                    headers={['Class ID', 'Skin ID', 'Skin Name', 'Amount Bought']}
                                    fieldNames={['characterClassId', 'skinId', 'skinName', 'boughtAmount']}/>
                    </Tab>
                </Tabs>
            </Container>
        </div>
    );
};
export default AdminReports;
