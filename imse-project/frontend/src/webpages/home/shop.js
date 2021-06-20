import React from 'react';
import {Carousel, ListGroup} from "react-bootstrap";
import ShopList from "../../components/shopList";

// TODO @kh
const Shop = () => {
    let list = [{
        name: "buy me"
    }, {
        name: "buy me"
    }, {
        name: "buy me"
    }, {
        name: "buy me"
    }, {
        name: "buy me"
    }]

    return (
        <div>
            <Carousel className="App-header">
                <Carousel.Item>
                    <Carousel.Caption>
                        <h3>First slide label</h3>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <Carousel.Caption>
                        <h3>Second slide label</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                    </Carousel.Caption>
                </Carousel.Item>
                <Carousel.Item>
                    <Carousel.Caption>
                        <h3>Third slide label</h3>
                        <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
                    </Carousel.Caption>
                </Carousel.Item>
            </Carousel>
            <ListGroup horizontal={true}>
                <ShopList shopList={list}/>
            </ListGroup>
        </div>
    );
}
export default Shop;
