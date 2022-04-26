import React, { useEffect, useState } from 'react';
import axios from 'axios';
import GlobalStyle from '../styled/Global';
import GalleryList from './GalleryList';
import GallerySearch from './GallerySearch';
import {Container} from '../styled/pixabaycss';

const Gallery = () => {

    const [data,setData] = useState([]) //객체로 받아온다.
    const [isLoading, setIsLoading] = useState(true)
    const [error,setError] = useState('')
    const [text,setText] = useState('')

    useEffect(()=> {

        const API_KEY = '26990410-937c495c6f8609d0b2591ca77'
        const url = `https://pixabay.com/api/?key=${API_KEY}&q=${text}&image_type=photo`

        //get으로 연결함
        axios.get(url)
        .then(res=> {
            setData(res.data.hits) // hits : map을 사용할 수 있게 해주는 애
            setIsLoading(false)
            setError('')
        }).catch(error=> {
            setData([])
            setIsLoading(true)
            setError("주소를 찾을 수 없습니다.")
        })
    },[text]) //검색어(text)가 바뀌었을 때 움직인다.

    //검색
    const searchText = (text) => {
        setText(text)
    }

    return (
        <>
        <GlobalStyle/>
        <Container>
            <GallerySearch searchText={searchText}/>
            {
                isLoading && data.length===0 && (<h1>NO Imges Fount</h1>)
            }
            {
                data && !isLoading && <GalleryList data={data}/>
            }
            <p>
                {error ? error : null}
            </p>
            </Container>
        </>
    );
};

export default Gallery;