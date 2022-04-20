import React, { useEffect, useLayoutEffect, useRef, useState } from 'react';

const Test1 = () => {

    const [count,setCount] = useState(1)

    const ref1 = useRef()
    const ref2 = useRef()

    const onColor = () => {
        ref1.current.style.color = 'pink'
        ref2.current.style.color = 'green'
        setCount(count+1)
    }

    //useEffect는 브라우저에 그려진 후 실행한다. (화면이 표시된 후에 실행)
    useEffect(() => {
        ref1.current.style.color='tomato'
    })

    //useLayoutEffect는 브라우저에 그려지기 전에 실행 (미리 실행) - 이거 거의 안씀
    useLayoutEffect(() => {
        ref2.current.style.color='skyblue'
    })

    return (
        <div style={{margin:30}}>
            <h1>출력:{count}</h1>
            <h1 ref={ref1}>useEffect</h1>
            <h1 ref={ref2}>useLayoutEffect</h1>
            <button onClick={onColor}>확인</button>
        </div>
    );
};

export default Test1;