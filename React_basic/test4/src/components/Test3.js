import React, { useRef, useState } from 'react';

const Test3 = () => {

    //useRef : DOM에 이름을 붙이기
    //1. Ref 이름선언
    //2. 참조하는 부분을 지정
    //3. 참조하는 부분에 적용할 작업
    // [Ref이름].current.[작업]

    const idRef = useRef() //input박스를 참조할거다 / 아래로

    const [userId,setUserId] = useState('')
    const [userPwd,setUserPwd] = useState('')

    const changeInput1 = (e) => {
        //setUserId(e.target.value)//데이터를 e.target.value값으로 읽어온다.
        const {value} = e.target //e.target에있는 것을 value에 넣는다
        setUserId(value) //setUserId에 value에 있는 값을 넣음
    }

    const changeInput2 = (e) => {
        setUserPwd(e.target.value)
    }

    //초기화 하기
    // - 가져온 값을 초기화하는거지 input박스를 초기화 x
    const onReset = () => {
        setUserId('')
        setUserPwd('')
        idRef.current.focus()
    }

    return (
        <div>
            {/* 값이 바뀔때마다 changeInput1 실행 */}
            id: <input type='text' onChange={changeInput1} value={userId} ref={idRef}/>
            pwd: <input type='text' onChange={changeInput2} value={userPwd}/>
            <button onClick={onReset}>초기화</button>
            {/* 입력된값을 보기위해 id,pwd가져옴 */}
            <h2>id: {userId}</h2> 
            <h2>pwd: {userPwd}</h2>
        </div>
    );
};

export default Test3;