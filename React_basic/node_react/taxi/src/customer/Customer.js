import React, { useEffect, useState } from 'react';
import taxiService from '../services/taxiService';
import AddUser from './AddUser';
import EditUser from './EditUser';
import ListUser from './ListUser';
import Message from './Message';
import './style.css';

const Customer = () => {
    
    //users라는 상태를 만들건데, 초기값을 userData로 지정
    //setUsers : useState(userData)에서 초기값을 userData로 바꿔주는 함수
    const [users,setUsers] = useState([])

    useEffect(()=> {
        onData()
    },[])

    //공간을 만들고 수정 데이터를 넣어놨다가 input창으로 전달
    const [current,setCurrent] = useState({})
    
    const [isEdit,setIsEdit] = useState(false)

    const [msg,setMsg] = useState('')
    const [isShow,setIsShow] = useState(false)

    const onData = async () => {
        const res = await taxiService.getUser()
        setUsers(res)
    }

    //추가 - addUser에서 넘어온 user
    const onAdd = (user,image) => {

        taxiService.addUser(user,image)
        onData() // 이걸 써야 새로 추가된 데이터까지 읽어온다.
        setMsg('명단을 추가합니다')
        setIsShow(true)
    }

    //삭제
    const onDel = (item) => {
        taxiService.deleteUser(item._id)
        onData()
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
        taxiService.updateUser(data)
        onData()
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