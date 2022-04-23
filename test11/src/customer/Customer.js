import React, { useRef, useState } from 'react';
import AddUser from './AddUser';
import EditUser from './EditUser';
import ListUser from './ListUser';
import Message from './Message';
import './style.css';

const Customer = () => {
    
    const no = useRef(5)

    const userData = [
        {id:1,name:'배수지',job:'무지개 택시 기사'},
        {id:2,name:'유인나',job:'무지개 택시 대표'},
        {id:3,name:'정인선',job:'무지개 택시 이사'},
        {id:4,name:'박신혜',job:'무지개 택시 경리'},

    ]
    
    //users라는 상태를 만들건데, 초기값을 userData로 지정
    //setUsers : useState(userData)에서 초기값을 userData로 바꿔주는 함수
    const [users,setUsers] = useState(userData)

    //공간을 만들고 수정 데이터를 넣어놨다가 input창으로 전달
    const [current,setCurrent] = useState({})
    
    const [isEdit,setIsEdit] = useState(false)

    const [msg,setMsg] = useState('')
    const [isShow,setIsShow] = useState(false)

    //추가
    const onAdd = (user) => {

        user.id = no.current++

        setUsers([
            ...users, //...user를 불러온다
            user
        ])
        setMsg('명단을 추가합니다')
        setIsShow(true)

    }

    //삭제
    const onDel = (id) => {
        setUsers(users.filter(user=>user.id!==id))
        setIsShow(true)
        setMsg('명단을 삭제한드앙!!!')
        setIsShow(true)
    }

    //수정
    const onEdit = (user) =>{
        setCurrent(user)
        setIsEdit(true)
        setMsg('명단을 수정합니다')
        setIsShow(true)
    }

    const onUpdate = (data) =>{
        setIsEdit(false)
        setUsers(users.map(user=>user.id===data.id? data:user))
        setMsg('명단을 수정완료했드앙!!!!')
        setIsShow(true)
    }

    return (
        <div className='Customer'>
            {
                isEdit ? <EditUser current={current} onUpdate={onUpdate} setIsEdit={setIsEdit}/> : <AddUser onAdd={onAdd}/>
            
            }
            <ListUser users={users} onDel={onDel} onEdit={onEdit}/>
            
            <Message msg={msg} isShow={isShow} setIsShow={setIsShow}/>
        </div>
    );
};

export default Customer;