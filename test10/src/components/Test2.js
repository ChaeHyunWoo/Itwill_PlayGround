import React, { useEffect, useRef, useState } from 'react';

const Test2 = () => {

    const [text,setText] = useState('') //초기값은 null로

    const ref1 = useRef();

    useEffect(()=> {
        console.log('useEffect')
        ref1.current.focus()
    },[])// [대괄호]를 넣으면 실행문은 1번만 실행된다.

    return (
        <div>
            <input type='text' ref={ref1} 
            onChange={evt=>setText(evt.target.value)}/>
        </div>
    );
};

export default Test2;