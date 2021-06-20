import React, {useEffect, useState} from 'react';
import {useHistory} from 'react-router-dom';
import {Alert, Button, Col, Container, Form, Row} from 'react-bootstrap';
import Cookies from "universal-cookie/lib";

const Login = () => {
    let history = useHistory();
    const cookies = new Cookies();

    const [username, setUsername] = useState("");

    const [success, setSuccess] = useState(true);

    const [database, setDatabase] = useState("maria");

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
                    <Button variant="danger" type="button" onClick={() => history.push("/admin")}> Admin </Button> {' '}
                    <Button variant="success" type="button" onClick={() => history.push("/signup")}> Sign
                        Up</Button> {' '}
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
                    <Col md={3} style={{paddingTop: 300}}>
                        <div className="Greeting-login-card">
                            <Form>
                                <Form.Group controlId="formBasicUserName">
                                    <Form.Label>Username</Form.Label>
                                    <Form.Control type="username" placeholder="Enter username"
                                                  onChange={(text) => setUsername(text.target.value)}/>
                                </Form.Group>
                                <Button type="button" variant="success" onClick={() => login()}
                                        style={{marginTop: 16}}> Play Now </Button>
                                {!success &&
                                <Alert variant="danger"> Username invalid! </Alert>
                                }
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
