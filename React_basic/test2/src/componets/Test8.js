import React from 'react';

const Test8 = () => {

    const title = '연예인'
    const arr = ['배수지','유인나','정인선','강아랑','이영애']
    const data = [
        {id:1,name:'배수지',age:27},
        {id:2,name:'유인나',age:25},
        {id:3,name:'정인선',age:21},
        {id:4,name:'강아랑',age:24},
        {id:5,name:'이영애',age:20},
    ]

    return (
        <div>
            <h2>{title}</h2>
            <p>{arr[0]}</p>
            <p>{arr[3]}</p>

            {
                arr.map((item,index)=> {
                    return (<p key={index}>{index}/{item}</p>)
                })
            }
            <hr/>
            {
                arr.map((item,index)=><p key={index}>{index}/{item}</p>)
            }
            <hr/>
            {
                data.map((item,index)=>{
                    return(<p key={index}>{item.id}/{item.name}/{item.age}</p>)
                })
            }
            <hr/>
            {
                data.map((item,index)=><p key={index}>{item.id}/{item.name}/{item.age}</p>)
            }

        </div>
    );
};

export default Test8;