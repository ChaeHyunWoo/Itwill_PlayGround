import React, { useRef, useState } from 'react';

const From = ({onAdd}) => {

    const [text,setText] = useState('')

    const nameRef = useRef()

    const changeInput = (e) => {
        const {value} = e.target
        setText(value)
    }

    const onOther = () => {
        onAdd(text)
        //alert('다른일!')
        setText('')
        nameRef.current.focus()
    }

    
    return(
        <div>
            {/* input 창에 onChange값을 주어 내가 입력한 값이 들어가서 value에 text값으로 반환됌 */}
            <input type='text' value={text} onChange={changeInput} ref={nameRef}/>
            <button onClick={onOther}>추가</button>
        </div>
    )
    
}
const List = ({data,onDel}) => {

    
    return(
        <div>
            {
            data.map(item=><Item key={item.id} item={item} onDel={onDel}/>)
            }
        </div>
    )
    
}
const Item = ({item,onDel}) => {

    const {id,text} = item
    return(
        <div>
            {id}.{text}
            <button onClick={()=>onDel(id)}>삭제</button>
        </div>
    )
    
}

const Test1 = () => {

    
    
    const no = useRef(4)

    

    const [data,setData] = useState([
        {id:1,text:'저녁먹기'},
        {id:2,text:'친구만나기'},
        {id:3,text:'회사미팅'},
    ])

    const onAdd = (text) => {
        
        setData([
            ...data,
            {
                id:no.current++,
                text//text:text 변수명이 똑같으므로 하나만 써도 댐 생략가능
            }
            
        ])
        

    }

    const onDel = (id) => {
        //alert("aaa")
        setData(data.filter(item=>item.id!==id))
    }
    return (
        <>
            <h1>일정관리표? 만들기</h1>
            <h2>Lost Ember - YongYong ~ ♪</h2> 
            <div>
                <h2>할일 만들기</h2>
                <From onAdd={onAdd}/>
                <br/>
                <List data={data} onDel={onDel}/>
            </div>
        </>
    );
};

export default Test1;