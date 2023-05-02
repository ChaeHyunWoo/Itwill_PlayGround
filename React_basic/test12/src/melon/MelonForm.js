import React, { useEffect, useState } from 'react';
import './MelonForm.css'

const MelonForm = ({onSearch}) => {

    const [text,setText] = useState('')

    const changeInput = (evt) => {
        const {value} = evt.target
        setText(value)
        //onSearch(value) //검색할때마다 실시간으로 반응해야하니 여기서 함수호출해야 함(실시간 검색)
    }

    // useEffect를 사용해서 실시간 검색도 가능
    useEffect(()=> {
        onSearch(text)
    },[text])


    //검색할때 엔터를 치면 onSubmit함수 실행
    const onSubmit = (evt) => {
        evt.preventDefault() //새로고침 방지
        //onSearch(text) //사용자가 검색한 text를 매개변수로 받는다.
        setText('')
    }

    return (
        <form className='MelonForm' onSubmit={onSubmit}>
            <input type='text' placeholder='곡명을 입력하세요' value={text}
            onChange={changeInput}/>
        </form>
    );
};

export default MelonForm;