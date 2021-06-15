import React from 'react';
import { useHistory } from 'react-router-dom';
import {Button, Card, Form} from 'react-bootstrap';

import background from '../assets/background-greeting.png';

const Greeting = () => {
    let history = useHistory();

    return (
        <div className="App">
            <header className="Greeting-header-small">
                <div>
                    <p>
                        University of Vienna | IMSE SS2021
                    </p>
                </div>
                <div>
                    <Button variant="primary" type="button" onClick={() => history.push("/home")}> Sign Up</Button> {' '}
                    <Button variant="secondary" type="button" onClick={() => history.push("/home")}> Fill Db</Button>
                </div>
            </header>

            <body className="Greeting-content" style={{backgroundImage:  `url(${background})`, maxHeight: window.innerHeight, maxWidth: window.innerWidth}}>
                <div className="Greeting-text-card">
                    <p className="Greeting-title">Team 17 - The Game</p>
                    <p className="Greeting-subtitle">an IMSE-Project</p>
                    <p className="Greeting-subtitle" style={{fontSize: "medium"}}>by Katharina Höckner & Stefan Tschurtschenthaler</p>
                </div>
                <div className="Greeting-login-card" >
                    <Form>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Email address</Form.Label>
                            <Form.Control type="email" placeholder="Enter email" />
                            <Form.Text className="text-muted">
                            </Form.Text>
                        </Form.Group>

                        <Form.Group controlId="formBasicUserName">
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="username" placeholder="username" />
                        </Form.Group>
                    </Form>
                    <div>
                        <Button type="submit" onClick={() => history.push("/home")}> Play Now </Button>
                    </div>
                </div>
            </body>
        </div>
    );
}
export default Greeting;
