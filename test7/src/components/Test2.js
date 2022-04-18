import React, { useRef, useState } from 'react';
import Test2Sub from './Test2Sub';

const Test2 = () => {

    const no = useRef(7)

    const [data,setData] = useState([
        {id:1,name:'배수지'},
        {id:2,name:'김수지'},
        {id:3,name:'이효리'},
        {id:4,name:'이정재'},
        {id:5,name:'정인선'},
        {id:6,name:'차태현'},
    ])

    const onDel = (id) =>{

        setData(data.filter(item=>item.id!==id))
    }
    const onAdd = (text) =>{
       // alert("추가")
       setData([
           ...data,
           {
               id:no.current++,
               name:text
           }
       ])
    }

    return (
        <div>
            {
                data.map(item=><p key={item.id}>
                    {item.id} / {item.name}
                </p>)
            }
            <hr/>
            <Test2Sub onAdd={onAdd} onDel={onDel}/>
        </div>
    );
};

export default Test2;