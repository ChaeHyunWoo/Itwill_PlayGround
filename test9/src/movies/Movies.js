import React, { useState } from 'react';
import './style.css';
import movie from '../assets/api/movie.json' //json형식 데이터를 불러올때는 풀네임 적어줘야 함
import MovieView from './MovieView';
import MovieList from './MovieList';
import Modal from './Modal';

const Movies = () => {

    const [data,setData] = useState(movie)
    const [movieInfo,setMovieInfo] = useState(data[0])

    const [isShow,setIsShow] = useState(false)

    const onOver = (id) => {
        const num = data.findIndex(item=>item.rank===id)
        setMovieInfo(data[num])
        //setMovieInfo(data.find(item=>item.rank===id))   
    }

    //open은 view한테 보낸다
    const onOpen = () => {
        setIsShow(true)
    }

    //close는 modal한테 보낸다.
    const onClose = () => {
        setIsShow(false)
    }

    return (
        <>
        <div className='gallery'>
            <MovieView movieInfo={movieInfo} onOpen={onOpen}/>
            <MovieList data={data} onOver={onOver}/>
        </div>
        {/* isShow가 true일 때만 보여라 */}
        {
            isShow && <Modal onClose={onClose} movieInfo={movieInfo}/>
        }
        </>
    );
};

export default Movies;