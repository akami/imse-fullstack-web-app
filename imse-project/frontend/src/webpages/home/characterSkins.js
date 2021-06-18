import React, {useEffect, useState} from 'react';
import Cookies from "universal-cookie/lib";
import Character from "../../components/character";

const CharacterSkins = () => {
    const cookies = new Cookies();
    const [skins, setSkins] = useState([]);

    const [classId] = useState(cookies.get('classId'));

    useEffect(() => {
        (async () => {
            await fetch('/api/skin/' + classId)
                .then((response) => response.json())
                .then((json) => setSkins(json))
                .then((json) => console.log(json));
        })();
    }, [classId]);

    return(
        <div>
            {
                Array.isArray(skins) &&
                skins.length >= 1 &&
                skins.map((skin) => {
                    return (
                        <p>{skin.skinName}: {skin.goldPrice}</p>
                    );
                })

            }

        </div>
    );
}
export default CharacterSkins;
