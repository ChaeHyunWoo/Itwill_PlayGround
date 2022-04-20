import React, { useRef, useState } from 'react';

const FriendInput = ({onAdd}) => {

    //커서 사용
    const nameRef = useRef()
    
    //input박스를 여러개 다루기위해 form 사용
    //아래에 input 박스가 여러개잖아요 그럴때 우리가 따로따로 setter를 안만들고
    //setForm 하나로 다 이용하는거 말한거에요
    const [form,setForm] =useState({
        name:'',age:'',image:''
    })
    //여기서의 form은 내가 추가하는 데이터 / onAdd함수를 통해 넘긴다(Friends.js로).
    const {name,age,image} = form

    const changeInput = (evt) => {
        const {value,name} = evt.target
        setForm({
            ...form,
            [name]:value
        })
    } //여기까지

    const onInsert = () => {

        if(!name||!age||!image) return //공백 무시하기 / 값을 입력하지 않으면 반응X

        onAdd(form) // 함수 2개 동시에 호출하는 방법 -함수안에 함수 호출

        setForm({
            name:'', age:'', image:'' //null로 만듬(삭제)
        })

        nameRef.current.focus() //커서를 갖다둠
    }


    return (
        <div className='formadd'>
                <p>
                    <label>이름</label>
                    <input type='text' value={name} name='name' onChange={changeInput}
                    ref={nameRef}/>
                    {/* 값이 바뀔 때 changeInput 함수 호출 */}
                </p>
                <p>
                    <label>나이</label>
                    <input type='text' value={age} name='age' onChange={changeInput}/>
                </p>
                <p>
                    <label>사진</label>
                    <input type='text' value={image} name='image' onChange={changeInput}/>
                </p>
                <p>
                    <button onClick={onInsert}>추가</button>
                </p>
            </div>
    );
};

export default FriendInput;