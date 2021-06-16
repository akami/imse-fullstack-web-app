import React from 'react';

import {BrowserRouter as Router, Route,} from "react-router-dom";

import Greeting from "./greeting";
import TopTabBar from "../components/navigation/topTabBar";
import SignUp from "./signup";
import CharacterCreation from "./characterCreation";
import Quests from "./quests";
import QuestContext from "./questContext";

const Root = () => {
    return (
        <Router>
            <Route exact path="/" component={Greeting}/>
            <Route exact path="/signup" component={SignUp}/>
            <Route exact path="/home" component={TopTabBar}/>
            <Route exact path="/create" component={CharacterCreation}/>
            <Route exact path="/quests" component={Quests}/>
            <Route exact path="/start" component={QuestContext}/>
        </Router>
    );
};
export default Root;
