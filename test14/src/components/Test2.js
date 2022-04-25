import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Test2 = () => {

    const [data,setData] = useState([])
    const [loading,setLoading] = useState(true)
    const [error,setError] = useState('')

    useEffect(()=> {
        axios.get('https://jsonplaceholder.typicode.com/todos')
        .then(res=> {//정상적으로 실행이 됬을 때
            setData(res.data)
            setLoading(false)
            setError('') 
        }).catch(error=> { //error가 발생했을 때
            setData([])
            setLoading(true)
            setError('데이터를 찾을 수 없습니다.')
        })
    },[])

    return (
        <div>
            {
                data && loading ? <h2>로딩중...</h2> :
                data.map(item=><p key={item.id}>
                    {item.id} / {item.title}
                </p>)
            }
            <p>
                {error ? error : null}
            </p>
        </div>
    );
};

export default Test2;