import React from 'react';
import Skin from "./skin";

const SkinList = ({skins}) => {
    return (
        <div>
            {
                Array.isArray(skins) &&
                skins.length >= 1 &&
                skins.map((skin) => {
                    return (
                        <Skin skin={skin}/>
                    );
                })

            }
        </div>
    );
};
export default SkinList;
