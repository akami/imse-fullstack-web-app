import React from 'react';
import {Button} from "react-bootstrap";

const ShopItem = ({item}) => {
    return (
        <div>
            <p>{item.name}</p>
            <Button variant="primary" type="button"> Buy </Button>
        </div>
    );
};
export default ShopItem;
