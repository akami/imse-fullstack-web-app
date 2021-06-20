import React, { useState } from 'react';
import { Tabs, Tab } from 'react-bootstrap';

import 'bootstrap/dist/css/bootstrap.min.css'

import Home from "../../webpages/home/home";

const TopTabBar = () => {
    const [key, setKey] = useState("home");

    return (
        <Tabs defaultActiveKey={key} id="home" onSelect={(k) => setKey(k)}>
            <Tab eventKey="home" title="Home" id="home">
                <Home/>
            </Tab>
        </Tabs>
    );
}
export default TopTabBar;
