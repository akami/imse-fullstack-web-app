import React from 'react';
import Character from "./character";

const CharacterList = (characters) => {

    return (
        <div>
            {
                Array.from(characters).map((char) => {
                    return (
                        <Character character={char}/>
                    );
                })

            }
        </div>
    );
};
export default CharacterList;
