import React from 'react';

import {BrowserRouter as Router, Route,} from "react-router-dom";

import Login from "../webpages/login/login";
import SignUp from "../webpages/login/signup";

import TopTabBar from "../components/navigation/topTabBar";

import CharacterCreation from "../webpages/home/characterCreation";
import Quests from "../webpages/home/quests";
import QuestContext from "../webpages/home/questContext";

import Admin from "./admin/admin";

const Root = () => {
    return (
        <Router>
            <Route exact path="/" component={Login}/>
            <Route exact path="/signup" component={SignUp}/>
            <Route exact path="/admin" component={Admin}/>
            <Route exact path="/home" component={TopTabBar}/>
            <Route exact path="/create" component={CharacterCreation}/>
            <Route exact path="/quests" component={Quests}/>
            <Route exact path="/start" component={QuestContext}/>
        </Router>
    );
};
export default Root;
