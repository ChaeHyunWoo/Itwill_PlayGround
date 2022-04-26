import React, { useCallback, useState } from 'react';
import Test3Sub from './Test3Sub';

const Test3 = () => {

    const [cnt1,setCnt1] = useState(1)
    const [cnt2,setCnt2] = useState(10)

    const increment1 = useCallback(()=> {
        setCnt1(cnt1 + 1)
    },[cnt1])

    const increment2 = useCallback(()=> {
        setCnt2(cnt2 + 1)
    },[cnt2])
    
    return (
        <div>
            <h1>숫자: {cnt1}</h1>
            <Test3Sub title='cnt1' cnt={cnt1}/>
            <button onClick={increment1}>증가</button>
            <hr/>
            <h1>숫자: {cnt2}</h1>
            <Test3Sub title='cnt2' cnt={cnt2}/>
            <button onClick={increment2}>증가</button>
        </div>
    );
};

export default Test3;