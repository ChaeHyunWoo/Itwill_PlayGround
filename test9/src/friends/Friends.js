import React, { useRef, useState } from 'react';
import FriendInput from './FriendInput';
import FriendList from './FriendList';
import './style.css';
import friend from '../assets/api/FriendData';

const Friends = () => {


    const no = useRef(friend.length + 1)

     //data안에는 최종적인 인원의 수 데이터가 들어있다.
    const [data,setData] = useState(friend)//setter
    //추가/비활성화하기위해
    const [done,setDone] = useState(true) //기본값 true -> true하면 체크박스에 체크됨. / false하면 체크가 사라짐 -> 클릭하면 true 다시 클릭하면 false로 하기 위해 토글키로 만들예정

    //모두 삭제
    const click1 = () => {
        setData([]) //setData를 null로 만듬 -> 모두 삭제
    }

    //초기 복구
    const click2 = () => {
        setData(friend) //setData에 friend 데이터를 넣어줌 /데이터 5개있음
    }

    const changeChk = (evt) => {
        const {checked} = evt.target
        setDone(checked)
    }

    //form은 내가 추가하는 데이터 / onAdd함수를 통해 넘긴다.(FriendInput.js에서 보냄)
    const onAdd = (form) => {
        
        form.id = no.current++ //기존 id에 1씩 추가
        setData([
            ...data,form  //추가된 form을 기존 데이터 data안에 넣어라
        ])
    }

    //삭제
    const onDel = (id) => {
        setData(data.filter(item=>item.id!==id))
    }

    return (
        <div className='wrap'>
            <h1>친구들 총 인원 : {data.length} 명</h1>
            <p className='chk'>
                <input type='checkbox' checked={done} onChange={changeChk}/>
                {
                    done ? '추가 비활성' : '추가 활성' //기본값이 true 참이면 추가비활성 / 거짓이면 추가활성을 띄운다.
                }
            </p>
            {/* FriendList한테 데이터 넘김 */}
            <FriendList data={data} onDel={onDel}/>

            <p className='btn'>
                <button onClick={click1}>모두삭제</button>
                <button onClick={click2}>초기복구</button>
            </p>

            {
                done && <FriendInput onAdd={onAdd}/>
            }

        </div>
    );
};

export default Friends;