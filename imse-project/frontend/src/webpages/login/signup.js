import React, { useState } from 'react';
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

const SignUp = () => {
    let history = useHistory();
    const [authDetails, setAuthDetails] = useState("", "");

    return (
        <div className="App">
            <div className="Greeting-header-small">
                <div>
                    <p>
                        University of Vienna | IMSE SS2021
                    </p>
                </div>
                <div>
                    <Button variant="success" type="button" onClick={() => history.push("/")}> Login </Button> {' '}
                </div>
            </div>

            <Container className="Greeting-content" style={{margin: "unset", maxWidth: "unset"}}>
                <Row className="justify-content-sm-center">
                    <Col sm={3} style={{paddingTop: 280}}>
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
                                <Button type="submit" variant="success" onClick={() => history.push("/home")}
                                        style={{marginTop: 16}}> Sign Up </Button>
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};
export default SignUp;
