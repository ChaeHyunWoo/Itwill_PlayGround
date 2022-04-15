import React, { useRef, useState } from 'react';
// 옵션으로 색상 바꿔보기
const Test4 = () => {
    
    //const colorRef = useRef(null); //null을 안써도 null이다.

    const [color,setColor] = useState('')
    const [text,setText] = useState('')

    const onColor = (evt) => { //evt = 이벤트

        // console.log(colorRef.current.value)

        // const data = {
        //     color:colorRef.current.value
        // }
        // console.log(data)

        // //json형태로 출력 가능- null에는 함수가 들어감. 안쓰니 null
        // const json = JSON.stringify(data,null,5) //5는 들여쓰기
        // console.log(json)

        const {value} = evt.target
        setColor(value)
        setText(value) //setText,setColor에 value값 넣음
    }

    const onSelect = () => {
        setColor(text)
    }

    return (
        <div>
            <h2 style={{color:color}}>컬러선택</h2>
            {/* <select ref={colorRef}> */}
            <select onChange={onColor}>
                <option value='red'>red</option>
                <option value='green'>green</option>
                <option value='pink'>pink</option>
                <option value='skyblue'>skyblue</option>
                <option value='tomato'>tomato</option>
            </select>
            <button onClick={onSelect}>선택</button>
        </div>
    );
};

export default Test4;