import React from 'react';
import Character from "./character";

const CharacterList = ({characters}) => {
    return (
        <div>
            {

                Array.isArray(characters) &&
                characters.length >= 1 &&
                characters.map((character) => {
                    return (
                        <Character character={character}/>
                    );
                })

            }
        </div>
    );
};
export default CharacterList;
