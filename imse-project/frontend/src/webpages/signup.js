import React from 'react';
import {Button, Form} from "react-bootstrap";
import {useHistory} from "react-router-dom";

const SignUp = () => {
    let history = useHistory();

    return (
        <div className="App">
            <div className="Greeting-header-small">
                <div>
                    <p>
                        University of Vienna | IMSE SS2021
                    </p>
                </div>
                <div>
                    <Button variant="primary" type="button" onClick={() => history.push("/")}> Login </Button> {' '}
                </div>
            </div>

            <div className="container Greeting-content" style={{margin: "unset", maxWidth: "unset"}}>
                <div className="row justify-content-sm-center">
                    <div className="col-sm-3">
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
                                <Button type="submit" onClick={() => history.push("/home")}
                                        style={{marginTop: 16}}> Sign Up </Button>
                            </Form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};
export default SignUp;
