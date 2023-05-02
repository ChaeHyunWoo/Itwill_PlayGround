import React, { useState } from 'react';
//토글키
const Test2 = () => {

    const [bgColor,setBgColor] = useState('pink')

    const onColor = () => {
        //setBgColor('tomato')
        setBgColor(bgColor==='pink' ? 'tomato':'pink') //bgColor의 값이 pink이면 tomato로 표시 그게 아니면 pink로 바꾼다.
    }

    return (
        <div>
            <p>h2 클릭하면 배경색이 pink에서 tomato로 변경</p>
            <h2 style={{with:400,padding:50,border:'1px solid #000',
            background:bgColor,cursor:'pointer'}}
            onClick={onColor}>
            배경색: {bgColor}</h2>
        </div>
    );
};

export default Test2;