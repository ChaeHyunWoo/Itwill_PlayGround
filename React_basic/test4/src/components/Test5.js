import React, { useState } from 'react';
// 체크박스 만들기
const Test5 = () => {

    const [check,setCheck] = useState(true)
    
    const changeCheck = (evt) => {
        const {checked} = evt.target
        setCheck(checked)
    }

    return (
        <div style={{color:check?'red':'#000'}}>
            <input type='checkbox' checked={check}
            onChange={changeCheck}/>
            체크박스를 클릭하세요
        </div>
    );
};

export default Test5;