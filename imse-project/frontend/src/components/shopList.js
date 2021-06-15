import React from 'react';
import ShopItem from "./shopItem";

const ShopList = ({shopList}) => {
    return (
        <div>
            {shopList.map((item, idx) => {
                return (<ShopItem item={item}/>);
            })}
        </div>
    );
};
export default ShopList;
