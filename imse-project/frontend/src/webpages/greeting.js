import React from 'react';
import {useHistory} from 'react-router-dom';
import {Button, Col, Container, Form, Row} from 'react-bootstrap';

const Greeting = () => {
    let history = useHistory();

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
)
();
}
;

return (
    <div className="App">
        <div className="Greeting-header-small">
            <div>
                <p>
                    University of Vienna | IMSE SS2021
                </p>
            </div>
            <div>
                <Button variant="success" type="button" onClick={() => history.push("/signup")}> Sign Up</Button> {' '}
                <Button variant="secondary" type="button" onClick={() => fillDb()}> Fill Db</Button> {' '}
                <Button variant="secondary" type="button" onClick={() => clearDb()}> Clear Db</Button>
            </div>
        </div>

        <Container className="Greeting-content" style={{margin: "unset", maxWidth: "unset"}}>
            <Row className="h-100">
                <Col md={1}></Col>
                <Col md={6} className="Greeting-text-card" style={{paddingTop: 300}}>
                    <p className="Text-title">The IMSE Quest</p>
                    <p className="Text-subtitle">a database game</p>
                    <p className="Text-subsubtitle">by Katharina Höckner & Stefan
                        Tschurtschenthaler</p>
                </Col>
                <Col md={3} style={{paddingTop: 280}}>
                    <div className="Greeting-login-card">
                        <Form>
                            <Form.Group controlId="formBasicEmail">
                                <Form.Label>Email address</Form.Label>
                                <Form.Control type="email" placeholder="Enter email"/>
                                <Form.Text className="text-muted">
                                </Form.Text>
                            </Form.Group>

                            <Form.Group controlId="formBasicUserName">
                                <Form.Label>Username</Form.Label>
                                <Form.Control type="username" placeholder="Enter username"/>
                            </Form.Group>
                            <Button type="submit" variant="success" onClick={() => history.push("/home")}
                                    style={{marginTop: 16}}> Play Now </Button>
                        </Form>
                    </div>
                </Col>
                <Col md={1}></Col>
            </Row>
        </Container>
    </div>
);
}
export default Greeting;
