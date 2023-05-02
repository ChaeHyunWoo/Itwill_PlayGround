import React, { useState } from 'react';
// 고유번호 처리방법
const Test1 = () => {

    const [data,setData] = useState([])
    //{id:1, name:배수지00}

    const onAdd = () => {
        setData(data.concat({id:data.length,
        name:'배수지' + Math.floor(Math.random()*10)}))
    }

    return (
        <div>
            <button onClick={onAdd}>데이터 추가</button>
            {
                data.map(item => <p key={item.id}>
                    {item.id} / {item.name}
                </p>)
            }
        </div>
    );
};

export default Test1;