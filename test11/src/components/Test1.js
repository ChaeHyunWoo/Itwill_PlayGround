import React, { useState } from 'react';
import Test1Sub from './Test1Sub';

const Test1 = () => {

    const [show,setShow] = useState(false)


    return (
        <div>
            <button onClick={()=>setShow(!show)}>
            시간과 날짜 출력
            </button>
            {
                show && <Test1Sub/>
            }
        </div>
    );
};

export default Test1;