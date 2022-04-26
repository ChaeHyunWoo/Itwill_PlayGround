import React, { useEffect, useMemo, useState } from 'react';

const user = [
    {id:1, name:'배수지'},
    {id:2, name:'유인나'},
    {id:3, name:'naver'},
    {id:4, name:'daum'},
    {id:5, name:'NaVER'},
    {id:6, name:'DOG'},
    {id:7, name:'dog'},
    {id:8, name:'nate'},
    {id:9, name:'Cat'},
    {id:10, name:'gooGLE'}
]

const Test1 = () => {
    
    const [text,setText] = useState('')
    const [search,setSearch] = useState('')
    //const [data,setData] = useState(user);

    const onSearch = () => {
        setSearch(text)
    }

    /*
    useEffect(()=> {
        setData(user.filter(item=>
            item.name.toLocaleLowerCase().includes(search.
            toLocaleLowerCase())))
    },[search])
    */

    //useMemo
    const data = useMemo(()=> {
        return user.filter(item=>
            item.name.toLocaleLowerCase().includes(search.
                toLocaleLowerCase()))
    },[search])

    return (
        <div>
            <input type='text' value={text} 
            onChange={evt=>setText(evt.target.value)}/>
            <button onClick={onSearch}>검색</button>
            <hr/>
            {
                data.map(item=><p key={item.id}>
                    {item.id} / {item.name}
                </p>)
            }
        </div>
    );
};

export default Test1;