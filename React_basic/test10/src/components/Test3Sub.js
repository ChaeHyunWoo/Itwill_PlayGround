import React, { useEffect, useState } from 'react';

const Test3Sub = () => {

    const [x,setX] = useState(0)
    const [y,setY] = useState(0)

    const move = (evt) => {
        setX(evt.clientX)
        setY(evt.clientY)
    }

    useEffect(() => {
        console.log('useEffect')
        window.addEventListener('mousemove',move) //마우스가 움직일 때 move()함수 실행

        //뒷정리 - (메모리 누수 방지)
        return()=> {
            window.addEventListener('mousemove',move)
        }
        
    },[]) // [] :이걸 쓰면 콘솔에 1번만 보이지만 실제로는 계속 쌓이기 때문에 (뒷정리) 필수필수~

    return (
        <div>
            <h2>마우스 좌표</h2>
            <div style={{width:500,height:150,fontSize:50,
            margin:20,textAlign:'center',border:'1px solid #000',lineHeight:'150px'}}>
                X : {x} / Y : {y}
            </div>
        </div>
    );
};

export default Test3Sub;