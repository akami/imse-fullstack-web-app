import React, {useEffect, useState} from 'react';
import {Button, Col, Container, Image, Row} from "react-bootstrap";
import {useHistory} from "react-router-dom";

import Coins from '../assets/coins.png'

import ThiefSkin1 from '../assets/skins/thief-skin1.png';
import ThiefSkin2 from '../assets/skins/thief-skin2.png';
import ThiefSkin3 from '../assets/skins/thief-skin3.png';
import ThiefSkin4 from '../assets/skins/thief-skin4.png';
import ThiefSkin5 from '../assets/skins/thief-skin5.png';

import FighterSkin1 from '../assets/skins/fighter-skin1.png';
import FighterSkin2 from '../assets/skins/fighter-skin2.png';
import FighterSkin3 from '../assets/skins/fighter-skin3.png';
import FighterSkin4 from '../assets/skins/fighter-skin4.png';
import FighterSkin5 from '../assets/skins/fighter-skin5.png';

import MageSkin1 from '../assets/skins/mage-skin1.png';
import MageSkin2 from '../assets/skins/mage-skin2.png';
import MageSkin3 from '../assets/skins/mage-skin3.png';
import MageSkin4 from '../assets/skins/mage-skin4.png';
import MageSkin5 from '../assets/skins/mage-skin5.png';

import RangerSkin1 from '../assets/skins/ranger-skin1.png';
import RangerSkin2 from '../assets/skins/ranger-skin2.png';
import RangerSkin3 from '../assets/skins/ranger-skin3.png';
import RangerSkin4 from '../assets/skins/ranger-skin4.png';
import RangerSkin5 from '../assets/skins/ranger-skin5.png';

import PriestSkin1 from '../assets/skins/priest-skin1.png';
import PriestSkin2 from '../assets/skins/priest-skin2.png';
import PriestSkin3 from '../assets/skins/priest-skin3.png';
import PriestSkin4 from '../assets/skins/priest-skin4.png';
import PriestSkin5 from '../assets/skins/priest-skin5.png';

import KnightSkin1 from '../assets/skins/knight-skin1.png';
import KnightSkin2 from '../assets/skins/knight-skin2.png';
import KnightSkin3 from '../assets/skins/knight-skin3.png';
import KnightSkin4 from '../assets/skins/knight-skin4.png';
import KnightSkin5 from '../assets/skins/knight-skin5.png';
import KnightSkin6 from '../assets/skins/knight-skin6.png';
import KnightSkin7 from '../assets/skins/knight-skin7.png';
import Cookies from "universal-cookie/lib";

const KnightSkins = [KnightSkin1, KnightSkin2, KnightSkin3, KnightSkin4, KnightSkin5, KnightSkin6, KnightSkin7];
const PriestSkins = [PriestSkin1, PriestSkin2, PriestSkin3, PriestSkin4, PriestSkin5];
const ThiefSkins = [ThiefSkin1, ThiefSkin2, ThiefSkin3, ThiefSkin4, ThiefSkin5];
const FighterSkins = [FighterSkin1, FighterSkin2, FighterSkin3, FighterSkin4, FighterSkin5];
const RangerSkins = [RangerSkin1, RangerSkin2, RangerSkin3, RangerSkin4, RangerSkin5];
const MageSkins = [MageSkin1, MageSkin2, MageSkin3, MageSkin4, MageSkin5];

const Skin = ({skin}) => {
    let history = useHistory();
    let cookies = new Cookies();

    const [characterId, setCharacterId] = useState(cookies.get('characterId'));
    const [classId, setClassId] = useState(cookies.get('classId'));

    const [database, setDatabase] = useState('maria');
    const [bought, setBought] = useState(false);
    const [boughtSkins, setBoughtSkins] = useState([]);

    useEffect(() => {
        (async () => {
            await fetch('/api/' + database + '/character-skin/' + characterId)
                .then((response) => response.json())
                .then((json) => setBoughtSkins(json));
        })();
    }, [characterId]);

    useEffect(() => {
        if(Array.isArray(boughtSkins)) {
            boughtSkins.map((boughtSkin) => {
                if (boughtSkin.skinId === skin.skinId) {
                    setBought(true);
                }
            });
        }
    }, [boughtSkins]);

    const getSkinsImage = (classId, skinId) => {
        switch (classId) {
            case 0:
                return MageSkins[skinId];
            case 1:
                return KnightSkins[skinId - 5];
            case 2:
                return PriestSkins[skinId - 10];
            case 3:
                return FighterSkins[skinId - 15];
            case 4:
                return RangerSkins[skinId - 20];
            case 5:
                return ThiefSkins[skinId - 25];
        }

        return undefined;
    };

    const buySkin = () => {
        (async () => {
            const response = await fetch('/api/' + database + '/skin/purchase/' + characterId + '/' + skin.skinId, {
                method: 'POST'
            });

            setBought(response.ok)
        })();
    }

    return (
        <Col md="auto" className="Character-container" styles={{paddingLeft: 8, paddingRight: 8}}>
            <Image src={getSkinsImage(skin.classId, skin.skinId)} width={300} height={380}/>
            <p className="Text-header2">{skin.skinName}</p>
            <Container>
                <Row>
                    <Col>
                        <div>
                            <Image src={Coins} width={10} height={10}/>
                            <p className="Text-subsubtitle">{skin.goldPrice}</p>
                        </div>
                    </Col>
                </Row>
            </Container>
            {bought
                ? <Button type="button" variant="secondary">Select</Button>
                : <Button type="button" variant="success" onClick={() => buySkin()}>Buy</Button>
            }
        </Col>
    );
};
export default Skin;
