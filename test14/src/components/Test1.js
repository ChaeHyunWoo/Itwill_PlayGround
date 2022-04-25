import React, { useEffect, useState } from 'react';
import axios from 'axios';

//외부에 있는 json형태 데이터를 읽어오는 방법에 관한 예제(4가지 방법)
const Test1 = () => {
    //data 담을 그릇
    const [data,setData] = useState()


    //useEffect로 데이터 읽어옴
    /*
    Ajax 요청 방법(4가지)

    1. fetch 사용(javascript에서 지원)
    useEffect(()=> {
        fetch('https://jsonplaceholder.typicode.com/todos')
        .then(res=>res.json()) //json형태의 데이터 읽어옴
        .then(res=>setData(res))
    },[])
    */
    //2. axios사용
    /*
    useEffect(()=> {
        axios.get('https://jsonplaceholder.typicode.com/todos')
        .then(res=>setData(res.data))
    },[])
    */
   //3. async/await 사용(Promise의 단점을 보완)
   // - 비동기를 동기처럼 사용 가능
   /*
   useEffect(()=> {
       const getData = async() => {
           const res = await fetch ('https://jsonplaceholder.typicode.com/todos')
           const data = await res.json()
           setData(data)
       }
       
       //이 함수를 호출해줘야 함
       getData()
   },[])
   */
   //4. async/await + axios 를 복합해서 사용
   useEffect(()=> {
    const getData = async() => {
        const res = await axios.get ('https://jsonplaceholder.typicode.com/todos')
        setData(res.data)
        }
    
        //이 함수를 호출해줘야 함
        getData()
    },[])

    return (
        <div>
            {
                data && data.map(item=><p key={item.id}>
                    {item.id} / {item.title}
                </p>)
            }
        </div>
    );
};

export default Test1;