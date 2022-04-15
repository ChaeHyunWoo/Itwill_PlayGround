import React, { useRef, useState } from 'react';

const Test7 = () => {

    const nameRef = useRef()

    const [name,setName] = useState()
    const [age,setAge] = useState()
    const [addr,setAddr] = useState()

    const onName = (evt) => {
        setName(evt.target.value)
    }

    const onAge = (evt) => {
        setAge(evt.target.value)
    }

    const onAddr = (evt) => {
        setAddr(evt.target.value)
    }

    const onReset = () => {
        setName('')
        setAge('')
        setAddr('')
        nameRef.current.focus()
    }

    return (
        <div>
            <h2>input 여러개 관리</h2>
            <input type='text' onChange={onName} value={name} 
            ref={nameRef}/>
            <input type='text' onChange={onAge} value={age}/>
            <input type='text' onChange={onAddr} value={addr}/>
            <button onClick={onReset}>초기화</button>
            <br/>
            <h4>{name} / {age} / {addr}</h4>
        </div>
    );
};

export default Test7;