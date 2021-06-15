import React from 'react';

import {BrowserRouter as Router, Route,} from "react-router-dom";

import Greeting from "./greeting";
import TopTabBar from "../components/navigation/topTabBar";

const Root = () => {
    return (
        <Router>
            <Route exact path="/" component={Greeting}/>
            <Route exact path="/home" component={TopTabBar}/>
        </Router>
    );
};
export default Root;
