import React, {useState} from 'react';
import {Button, Col, Container, Form, Row, Alert} from "react-bootstrap";
import {useHistory, useLocation} from "react-router-dom";
import Cookies from "universal-cookie/lib";

const SignUp = ({props}) => {
    let history = useHistory();
    let location = useLocation();
    let cookies = new Cookies();

    const [email, setEmail] = useState("");
    const [username, setUsername] = useState("");
    const [age, setAge] = useState("");

    const [inProgress, setInProgress] = useState(false);
    const [success, setSuccess] = useState(false);

    const [database, setDatabase] = useState(cookies.get('database'));

    const signup = () => {
        (async () => {
            let response;
            if (database.equals('maria')) {
                 response = await fetch('/api/' + database + '/player/', {
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
            } else if (database.equals('mongo')) {
                response = await fetch('/api/' + database + '/player/', {
                    method: 'POST',
                    headers: {
                        "Content-type": "application/json"
                    },
                    body: JSON.stringify({
                        username: username,
                        age: age,
                        emailAddress: email,
                        boughtPets: [],
                        createdCharacters: [],
                        mongoGoldOffers: []
                    })
                });
            }

            setSuccess(response.ok);
            setInProgress(true);
        })();
        if (success) {
            history.push("/home/");
        }
    };

    const login = () => {
        (async () => {
            const playerId = await fetch('/api/' + database + '/player/' + username)
                .then((response) => response.json())
                .then((json) => {
                    return json.playerId;
                });

            if (playerId !== undefined) {
                cookies.set('playerId', playerId, {path: '/'});

                history.push('/home/');
            } else {
                setSuccess(false);
            }
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

                                {inProgress && success &&
                                    <div>
                                        <Alert variant="success" style={{marginTop: 16}}>Signup was successful!</Alert>
                                        <Button variant="danger" onClick={() => login()}>Play Now</Button>
                                    </div>
                                }

                                {inProgress && !success &&
                                <Alert variant="danger" style={{marginTop: 16}}>Signup was unsuccessful!</Alert>}
                            </Form>
                        </div>
                    </Col>
                </Row>
            </Container>
        </div>
    );
};
export default SignUp;
