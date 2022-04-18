import React from 'react';

const Test1 = () => {

    const onAddr1 = () => {

    }
    //매개변수를 넘길때는 함수형으로 만들어준다
    const onAddr2 = (text) => {
      alert(text)
    }

    return (
        <div>
            <button onClick={onAddr1}>확인1</button>
            <button onClick={() =>onAddr2('안녕!')}>확인2</button>
        </div>
    );
};

export default Test1;