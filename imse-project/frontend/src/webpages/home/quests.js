import React from 'react';
import {Accordion, Button, Card, Col, Container} from "react-bootstrap";
import {useHistory} from "react-router-dom";

// TODO @kh
const Quests = () => {
    let history = useHistory();

    let quests = [{
        name: "test",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut" +
            " labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea" +
            " rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor" +
            " sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna" +
            "aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd" +
            "gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
    }, {
        name: "test1",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            "ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et" +
            "ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum " +
            "dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore " +
            "magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita" +
            " kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."
    }, {
        name: "test2",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            "ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et" +
            " ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum " +
            "dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore " +
            "magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita" +
            " kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }, {
        name: "test3",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            "ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores " +
            "et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum" +
            " dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore " +
            "magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita" +
            " kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }, {
        name: "test4",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            "ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et" +
            " ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum " +
            "dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna " +
            "aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd" +
            " gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }, {
        name: "test5",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            " ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores " +
            "et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum " +
            "dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore " +
            "magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita" +
            " kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }, {
        name: "test6",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            " ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores " +
            "et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum" +
            " dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore" +
            " magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita " +
            "kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }, {
        name: "test7",
        description: "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt" +
            " ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores " +
            "et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum" +
            " dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore" +
            " magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita " +
            "kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet."

    }];

    let completedQuests = [{
        name: "test1"
    }, {
        name: "test"
    }]

    return (
        <Container>
            <Accordion>
                {quests.map((quest, idx) => {
                    return (
                        <Card>
                            <Card.Header>
                                <Col>
                                    <Accordion.Toggle as={Button} variant="light" eventKey="idx">
                                        {quest.name}
                                    </Accordion.Toggle>
                                    {completedQuests.findIndex((completedQuest) => {
                                        return completedQuest.name === quest.name
                                    }) >= 0 ?
                                        <Button type="button" variant="outline-secondary"
                                                disabled="true">Completed</Button>
                                        :
                                        <Button type="button" onClick={() => {history.push("/start")}}>Start Quest</Button>}
                                </Col>
                            </Card.Header>
                            <Accordion.Collapse eventKey="idx">
                                <Card.Body>{quest.description}</Card.Body>
                            </Accordion.Collapse>
                        </Card>
                    );

                })}
            </Accordion>
        </Container>
    );
};
export default Quests;
