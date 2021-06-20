import React, {useEffect, useState} from 'react';

const Gold = () => {
    const [database, setDatabase] = useState('maria');

    useEffect(() => {
            (async () => {
                await fetch('/api/' + database + '/character-skin/' + characterId)
                    .then((response) => response.json())
                    .then((json) => setBoughtSkins(json));
            })();
    }

    ), [];
    return (
        <div>

        </div>
    );
};
export default Gold;
