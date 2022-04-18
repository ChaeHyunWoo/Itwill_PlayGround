import React, { useRef, useState } from 'react';

const Test3 = () => {

    const no = useRef(1)
    const nameRef = useRef()

    const [data,setData] = useState([])

    const [form,setForm] = useState({
        name:'',age:''
    })

    const {name,age} = form

    const onText = (evt) => {
        const {value,name} = evt.target
        setForm({
            ...form,
            [name]:value
        })
    }

    const onAdd = () => {
        setData([
            ...data,
            {
                id:no.current++,
                name:name,
                age:age
            }
        ])

        setForm({
            name:'',
            age:''
        })

        nameRef.current.focus()
    }

    

    return (
        <div>
            <input type='text' value={name} name='name' onChange={onText} ref={nameRef}/>
            <input type='text' value={age} name='age' onChange={onText}/>
            <button onClick={onAdd}>추가</button>
            <hr/>
            {
                data.map(item=><li key={item.id}>
                    {item.id} / {item.name} / {item.age}
                </li>)
            }
        </div>
    );
};

export default Test3;