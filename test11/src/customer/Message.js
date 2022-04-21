import React, { useEffect } from 'react';

const Message = ({msg,isShow,setIsShow}) => {

    useEffect(()=>{

        const timer = setTimeout(()=>{
            setIsShow(false)
        },2000)//2초만 보겠다

        //메모리 누수 방지
        return()=>{
            clearTimeout(timer)
        }
    },[isShow])//isShow가 바뀔때만 실행하라

    return (
        <div className={`message ${isShow ? 'on' : ''}`}>
            메세지 : {msg}
        </div>
    );
};

export default Message;