import React, { useState } from 'react';
import Test3Sub from './Test3Sub';

const Test3 = () => {

    const [done,setDone] = useState(false)

    const onToggle = () => {
        setDone(!done)
    }

    return (
        <div>
            <button onClick={onToggle}>
                {done ? '숨기기' : '보이기'}
            </button>
            <hr/>
            {done && <Test3Sub/>}
        </div>
    );
};

export default Test3;