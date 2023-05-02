import React, { useRef, useState } from 'react';

const AddUser = ({onAdd}) => {

    const [user,setUser] = useState({
        name:'',job:''    
    })

    const nameRef = useRef() //useRef 생성

    const {name,job} = user

    const [image,setImage] = useState()

    const changeImage = (evt) => {
        setImage(evt.target.files[0]) //evt의 target에서 읽어온 files의 [0]번째
    }

    const changeInput = (evt) => {
        const {value,name} = evt.target
        setUser({
            ...user,
            [name]:value
        })
    
    }

    const onSubmit = (evt) => {
        evt.preventDefault()//새로고침 안되게 하는 코딩

        //공백일때 추가못하도록
        if(!name||!job) return

        onAdd(user,image)

        setUser({
            name:'',job:''
        })
        nameRef.current.focus()
    }

    return (
        <form onSubmit={onSubmit}>
        <h2>모범택시 고객 추가</h2>
        <p>
            <label>이름</label>
            <input type='text' value={name} name='name' onChange={changeInput} ref={nameRef}/>
        </p>
        <p>
            <label>직업</label>
            <input type='text' value={job} name='job' onChange={changeInput}/>
        </p>
        <p>
            <label>사진</label>
            <input type='file' onChange={changeImage}/>
        </p>
        <p>
            <button>추가</button>
        </p>
    </form>
    );
};

export default AddUser;