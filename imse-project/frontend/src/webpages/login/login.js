import React, {useState} from 'react';
import {useHistory} from 'react-router-dom';
import {Button, Col, Container, Form, Row} from 'react-bootstrap';

const Login = () => {
    let history = useHistory();
    const [authDetails, setAuthDetails] = useState(["", ""]);



return (
    <div className="App">
        <div className="Greeting-header-small">
            <div>
                <p>
                    University of Vienna | IMSE SS2021
                </p>
            </div>
            <div>
                <Button variant="danger" type="button" onClick={() => history.push("/admin")}> Admin </Button> {' '}
                <Button variant="success" type="button" onClick={() => history.push("/signup")}> Sign Up</Button> {' '}
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
                                <Form.Control type="email" placeholder="Enter email" onChange={(text) => setAuthDetails([text.target.value, authDetails[1]])}/>
                                <Form.Text className="text-muted">
                                </Form.Text>
                            </Form.Group>

                            <Form.Group controlId="formBasicUserName">
                                <Form.Label>Username</Form.Label>
                                <Form.Control type="username" placeholder="Enter username" onChange={(text) => setAuthDetails([authDetails[0], text.target.value])}/>
                            </Form.Group>
                            <Button type="submit" variant="success" onClick={() => this.username.history.push("/home")}
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
export default Login;
