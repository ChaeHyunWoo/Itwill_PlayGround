import React, { useState } from 'react';
import {ImageForm} from '../styled/pixabaycss';

const GallerySearch = ({searchText}) => {

    const [text,setText] = useState('')

    //엔터 치면 실행되는 함수
    const onSubmit = (evt) => {
        evt.preventDefault() //새로고침 방지
        searchText(text)
    }

    return (
        <ImageForm onSubmit={onSubmit}>
            <input text='text' placeholder='검색어를 입력하세요' value={text} 
            onChange={evt=>setText(evt.target.value)}/>
            <button type='submit'>검색</button>
        </ImageForm>
    );
};

export default GallerySearch;