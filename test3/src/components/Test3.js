import React, { useState } from 'react';

const Test3 = () => {

    const [visible,setVisible] = useState(false)

    const onShow = () => {
        setVisible(true)
    }

    const onHide = () => {
        setVisible(false)
    }

    const onToggle = () => {
        //애는 true면 =>false, false-> true로 바꾼다.
        setVisible(!visible)
    }

    return (
        <div>
            <p>
                <button onClick={onShow}>보이기</button>
                <button onClick={onHide}>숨기기</button>
                <button onClick={onToggle}>보이기/숨기기</button>
            </p>
            { //&&는 왼쪽 값이 true이면 뒤에껄 실행
                visible &&
            <div style={{width:300,height:100,background:'tomato'}}>
            전성덕
            </div>
            }
        </div>

       
    );
};

export default Test3;