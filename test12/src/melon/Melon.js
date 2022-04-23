import React, { useState } from 'react';
import './Melon.css';
import MelonForm from './MelonForm';
import MelonList from './MelonList';
import music from '../assets/api/music';
import Modal from './Modal';

const Melon = () => {

    // useState로 데이터 읽어오고 MelonList로 넘길 것이다
    const [musics,setMusics] = useState(music)
    const [isShow,setIsShow] = useState(false) //모달창 열고 닫기
    const [musicNum,setMusicNum] = useState({})

    const getData = () => {
        const now = new Date()
        const year = now.getFullYear()
        const month = now.getMonth() + 1
        const date = now.getDate()

        const msg = `${year}. ${month}. ${date}`

        return msg
    }

    //좋아요 클릭/취소 - Toggle키
    const onLike = (id) => {
        setMusics(musics.map(music=>music.id===id?
            {
                ...music,
                done:!music.done,  
                like:!music.done ? music.like + 1 : //done이 true이면 +1 false이면 -1(좋아요취소)
                music.like -1
            }
            : music))
    }

    //음악(곡) 검색 - MelonForm.js로 넘김
    // - 사용자가 검색창에 입력한 text를 매개변수 받아줌
    const onSearch = (text) => {
        
        //대소문자 상관없이 검색할 것이다.
        // - music(오리지날 데이터) / musics(map돌린 데이터)
        // music에서 검색을 해줘야 검색상태에서 다시 한번 검색이 가능하다.
        //setMusics(music.filter(music=>music.title
            //.toLocaleLowerCase().indexOf(text.toLocaleLowerCase())!==-1))

        //이건 실시간 검색 - 엔터 안해도 검색가능
        setMusics(music.filter(item=> {
            const result = new RegExp(text,'ig')
            return item.title.match(result)
        }))
    }

    const onOpen = (id) => {
        setIsShow(true)
        setMusicNum(musics.find(music=>music.id===id))
    }

    const onClose = (id) => {
        setIsShow(false)
    }

    return (
        <div className='Melon'>
            <h2>멜론 순위 {getData()} 인기 챠트</h2>
            <MelonForm onSearch={onSearch}/>
            <MelonList musics={musics} onLike={onLike}
            onOpen={onOpen}/>
            {
                isShow && <Modal musicNum={musicNum} onClose={onClose}/>
            }           
        </div>
    );
};

export default Melon;