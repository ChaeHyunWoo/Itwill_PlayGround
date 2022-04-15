import React, { useRef, useState } from 'react';

const Test8 = () => {
//Test7을 이렇게 바꿀 수 있음
    const nameRef = useRef()

    // const [name,setName] = useState()
    // const [age,setAge] = useState()
    // const [addr,setAddr] = useState()

    //위의 3줄을 한개로 만듬
    const [form,setForm] = useState({
        name:'', age:'', addr:''
    })

    //비구조 할당 - form을 안쓰기 위해
    const {name,age,addr} = form

    const onName = (evt) => {
        //setName(evt.target.value)
        const {value,name} = evt.target
        setForm({
            ...form,
            [name]:value
        })
    }

    const onAge = (evt) => {
        //setAge(evt.target.value)
        const {value,name} = evt.target
        setForm({
            ...form,
           [name]:value
        })
    }

    const onAddr = (evt) => {
        //setAddr(evt.target.value)
        const {value,name} = evt.target
        setForm({
            ...form, //스프레드 연산자
            [name]:value
        })
    }

    const onReset = () => {
        nameRef.current.focus()
    }

    return (
        <div>
            <h2>input 여러개 관리</h2>
            <input type='text' onChange={onName} value={name}name='name' ref={nameRef}/>
            <input type='text' onChange={onAge} value={age} name='age'/>
            <input type='text' onChange={onAddr} value={addr} name='addr'/>
            <button onClick={onReset}>초기화</button>
            <br/>
            <h4>{name} / {age} / {addr}</h4>
        </div>
    );
};

export default Test8;