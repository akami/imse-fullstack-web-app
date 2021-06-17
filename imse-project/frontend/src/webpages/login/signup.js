import React, {useState} from 'react';
import {Button, Col, Container, Form, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

const SignUp = () => {
    let history = useHistory();

    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [age, setAge] = useState("");

    const [inProgress, setInProgress] = useState(false);
    const [success, setSuccess] = useState(false);

    const signup = () => {
        (async () => {
            const response = await fetch('/api/player', {
                method: 'POST',
                headers: {
                    "Content-type": "application/json"
                },
                body: JSON.stringify({
                    emailAddress: email,
                    username: username,
                    age: age
                })
            });

            setSuccess(response.ok);
            setInProgress(true);
        })();
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
                                    <Form.Control type="email" placeholder="Enter email"
                                                  onChange={(text) => setEmail(text.target.value)}/>
                                    <Form.Text className="text-muted">
                                    </Form.Text>
                                </Form.Group>

                                <Form.Group controlId="formBasicUserName">
                                    <Form.Label>Username</Form.Label>
                                    <Form.Control type="username" placeholder="Enter username"
                                                  onChange={(text) => setUsername(text.target.value)}/>
                                </Form.Group>

                                <Form.Group controlId="formBasicAge">
                                    <Form.Label>Age</Form.Label>
                                    <Form.Control type="age" placeholder="Enter age"
                                                  onChange={(text) => setAge(text.target.value)}/>
                                </Form.Group>

                                <Button type="button" variant="success" onClick={() => signup()}> Sign
                                    Up </Button>

                                {inProgress && success && <p>Signup was successful!</p>}
                                {inProgress && !success && <p>Signup was unsuccessful!</p>}
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};
export default SignUp;
