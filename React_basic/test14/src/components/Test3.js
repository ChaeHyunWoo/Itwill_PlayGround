import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Test3 = () => {

    const [data,setData] = useState({}) // ({}) :  하나의 데이터 읽어온다는 뜻
    const [loading, setLoading] = useState(true) //디폴트 값을 true
    const [error, setError] = useState('') //기본값을 null('')
    const [valueId, setValueId] = useState(1)
    const [num,setNum] = useState(1)

    useEffect(()=> {
        axios.get(`https://jsonplaceholder.typicode.com/todos/${valueId}`)
        .then(res => {  //정상적으로 실행이 됬을 때
            setData(res.data)
            setLoading(false)
            setError('')
        }).catch(error=> { //error가 발생했을 때
            setData({})
            setLoading(true)
            setError('주소를 찾지 못함!!')
        })
    },[num]) //num이 바뀔때마다 바꿀 것이다.

    const click1 = () => {
        setNum(valueId)
    }

    return (
        <div>
            <input type='text' value={valueId} onChange={evt => setValueId(evt.target.value)}/>
            <button onClick={click1}>검색</button>
            <h4>
                {
                    data && loading ? <h2>로딩중...</h2> :
                    <h3>출력: {data.title}</h3>
                }
                <p>
                    {error ? error : null}
                </p>
            </h4>
        </div>
    );
};

export default Test3;