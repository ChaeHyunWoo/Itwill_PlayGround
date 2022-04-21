import React, { useEffect, useState } from 'react';

const Test1Sub = () => {

    const [date,setDate] = useState(new Date())

    useEffect(() => {
        const timer = setInterval(()=>{
            setDate(new Date())//새로운 시간을 새롭게 계속 넣어라
        },1000)//1000은 1초에 한번씩 움직여라

        return()=>{
            clearInterval(timer)
        }
    },[])

    return (
        <div>
            <h1>날짜 : {date.toLocaleDateString()}</h1>
            <h1>시간 : {date.toLocaleTimeString()}</h1>
        </div>
    );
};

export default Test1Sub;