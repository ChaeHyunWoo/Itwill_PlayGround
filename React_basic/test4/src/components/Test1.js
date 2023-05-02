import React, { useState } from 'react';

const Test1 = () => {

    const [data,setData] = useState([
        {id:1,name:'배수지',age:27,done:true}, //이 줄 자체가 item
        {id:2,name:'유인나',age:40,done:false},
        {id:3,name:'정인선',age:30,done:true},
        {id:4,name:'강아랑',age:25,done:false},
        {id:5,name:'이영애',age:45,done:true}
    ])
    //그냥 데이터를 넣는방법
    const onAdd1 = () => {
        setData(data.concat({id:6,name:'조이',age:35,
        done:false}))
    }

    const onAdd2 = () => {
        const newData = data.concat({id:7,name:'박보영',age:35,
        done:false})

        setData(newData)
    }
    //데이터를 읽어서 넣는방법
    const onAdd3 = () => {
        setData([
            ...data,
            {id:8,name:'아이린',age:30,done:false}
        ])
    }
    //데이터를
    const onAdd4 = () => {
        const newData = data.concat({id:9,name:'안젤리나',age:35,
        done:true})

        setData([...data,newData])
    }

    return (
        <div>
            <p>
                <button onClick={onAdd1}>추가</button>
                <button onClick={onAdd2}>추가</button>
                <button onClick={onAdd3}>추가</button>
                <button onClick={onAdd4}>추가</button>
            </p>
            {
            data.map((item,index)=><p key={item.id}>
                {item.id} / {item.name} / {item.age} /
                {item.done ? '참' : '거짓'}
                </p>)
            }

            <hr/>
            {
                data.map(item=><p key={item.id}>
                    {item.id} / {item.name}
                </p>)
            }

        </div>
        /*  key가 없을 때
            1.홍길동1       1.홍길동1
            2.홍길동2 =>    2.홍길동2
            3.홍길동3       3.배수지 (추가)
            4.홍길동4       4.홍길동3
                            5.홍길동4

            key값이 있을 때
            - key값이 있으면 데이터가 추가되도 기존 데이터 고유값이
            - 바뀌지 않아서 데이터를 찾을 때 편함
            1.홍길동1       1.홍길동1
            2.홍길동2 =>    2.홍길동2
            3.홍길동3       5.배수지 (추가)
            4.홍길동4       3.홍길동3
                            4.홍길동4
        */
    );
};

export default Test1;