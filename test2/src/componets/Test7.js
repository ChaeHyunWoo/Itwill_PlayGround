import React from 'react';

const Test7 = () => {

    const click1 = () => {
        alert('클릭1..')
    }

    const click2 = () => {
        alert('클릭2..')
    }

    return (
        <div>
            <h2>이벤트 사용</h2>
            <p>
                <button onClick={click1}>클릭1</button>
                <button onClick={click2}>클릭2</button>
            </p>
            <p>
                <button onClick={()=> alert('클릭3')}>클릭3</button>
                <button onClick={()=> alert('클릭4')}>클릭4</button>
            </p>
        </div>
    );
};

export default Test7;