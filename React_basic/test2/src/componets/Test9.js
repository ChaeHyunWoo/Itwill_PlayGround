import React, { useState } from 'react';

//Hook : 클래스 컴포넌트에서 사용하던 기능을 함수형 컴포넌트에 사용할 수 있게 함
//종류 : useState,useEffect,useRef,useMemo,useReducer,useCallback

//useState : getter/setter이다.
const Test9 = () => {

    const [name,setName] = useState('좋아하는 사람')

    const onName1 = () => {
        setName('배수지')
    }

    const onName2 = () => {
        setName('유인나')
    }

    return (
        <div>
            <h2>이름:{name}</h2>
            <button onClick={onName1}>배수지</button>
            <button onClick={onName2}>유인나</button>
            
        </div>
    );
};

export default Test9;