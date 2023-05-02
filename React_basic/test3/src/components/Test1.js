import React, { useState } from 'react';

const Test1 = () => {

    const [name,setName] = useState('이름없음')
    const [color,setColor] = useState('green')

    const onName1 = () => {
        setName('배수지')
    }

    const onName2 = () => {
        setName('유인나')
    }

    const onName3 = () => {
        setName('정인선')
    }

    return (
        <div>
            <h2 style={{color:color}}>이름: {name}</h2>
            <h2>컬러: {color} </h2>
            <p>
                <button onClick={onName1}>배수지</button>
                <button onClick={onName2}>유인나</button>
                <button onClick={onName3}>정인선</button>
            </p>
            <p>
                <button onClick={()=>setColor('pink')}>Pink</button>
                <button onClick={()=>setColor('yellow')}>Yellow</button>
                <button onClick={()=>setColor('skyblue')}>Skyblue</button>
            </p>
        </div>
    );
};

export default Test1;