import React, { useState } from 'react';

const Test4 = () => {

    const [count,setCount] = useState(0)

    const increment1 = () => {
        setCount(count + 1)
    }

    const decrement1 = () => {
        setCount(count - 1)
    }

    const increment2 = () => {
        setCount(count + 2)
        //setCount(count + 1)

        //i=i+2
        setCount(i=>i+1)
        setCount(preCount=>preCount+1)
    }

    const decrement2 = () => {
        setCount(count - 2)
    }

    return (
        <div>
            <h2>카운트: {count}</h2>
            <p>
                <button onClick={increment1}>증가</button>
                <button onClick={decrement1}>감소</button>
            </p>
            <p>
                <button onClick={()=>setCount(count+1)}>증가</button>
                <button onClick={()=>setCount(count-1)}>감소</button>
            </p>
            <p>
                <button onClick={increment2}>증가</button>
                <button onClick={decrement2}>감소</button>
            </p>
        </div>
    );
};

export default Test4;