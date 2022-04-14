import React from 'react';
import Test6Sub from './Test6Sub';

const Test6 = () => {
    return (
        <div>
            <div>
                <Test6Sub
                title='전상원 신상'
                name='전상원'
                age = {20}
                addr = '서울'
                tel = '010-123-1234'
                color = 'pink'
                done = {true}
                />

                <Test6Sub
                title = '유인나'
                addr = '제주도'
                color = 'blue'
                done = {false}
                />

            </div>
            
        </div>
    );
};

export default Test6;