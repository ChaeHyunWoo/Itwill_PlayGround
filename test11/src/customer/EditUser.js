import React, { useEffect, useState } from 'react';

const EditUser = ({current,onUpdate,setIsEdit}) => {

    const [user,setUser] = useState(current)

    const {name,job} = user

    const changeInput = (evt) => {
        const {value,name} = evt.target
        setUser({
            ...user,
            [name]:value
        })
    }

    //수정버튼
    const onSubmit = (evt) => {
        evt.preventDefault()//새로고침 방지

        onUpdate(user)//수정해주는얘
        setUser({
            name:'',job:''
        })
    }

    useEffect(() =>{
        setUser(current)
    },[current])

    return (
        <form onSubmit={onSubmit}>
           <h2>모범택시 고객 수정</h2>
           <p>
               <label>이름</label>
               <input type='text' value={name} name='name'
               onChange={changeInput}/>
           </p>
           <p>
               <label>직업</label>
               <input type='text' value={job} name='job'
               onChange={changeInput}/>
           </p>
           <button>수정</button>
           <button onClick={()=>setIsEdit(false)}>취소</button>
       </form>
    );
};

export default EditUser;