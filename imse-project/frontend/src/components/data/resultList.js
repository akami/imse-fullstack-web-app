import {Table} from "react-bootstrap";
import React, {useEffect, useState} from "react";

const ResultList = ({url, headers, fieldNames}) => {
    const [results, setResults] = useState([]);

    useEffect(() => {
        (async () => {
            await fetch(url)
                .then((response) => response.json())
                .then((json) => setResults(json))
        })();
    }, []);


    return (
        <Table striped bordered hover>
            <thead>
            <tr>
                {
                    headers.map((header) => {
                        return (
                            <th>{header}</th>
                        );
                    })
                }
            </tr>
            </thead>
            <tbody>
            {
                Array.isArray(results) &&
                results.length >= 1 &&
                results.map((result) => {
                    return (
                        <tr>
                            {
                                fieldNames.map((fieldName) => {
                                    return (
                                        <td>{result[fieldName]}</td>
                                    );
                                })
                            }
                        </tr>
                    );
                })
            }
            </tbody>
        </Table>
    );
};
export default ResultList;
