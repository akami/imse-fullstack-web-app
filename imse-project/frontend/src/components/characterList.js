import React from 'react';
import Character from "./character";

const CharacterList = ({characters}) => {
    return(
        <div>
            {characters.map((char, idx) => {
                return(<Character character={char}/>);
            })}
        </div>
    );
};
export default CharacterList;
