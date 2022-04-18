import React, { useState } from 'react';
import MovieList from './MovieList';
import './style.css';
import movieData from '../assets/api/movieData';

const Movies = () => {

    const [data,setData] = useState(movieData)

    //삭제 - 매개변수를 넘겨서 자기가 원하는 데이터를 지운다
    const onDel=(no) =>{
        //alert(no)
        
        setData(data.filter(item=>item.no!==no))//같지 않는거는 빼고 넣어라

    }

    return (
        <div className='wrap'>
            <h2>최신 개봉작</h2>
            <MovieList data={data} onDel={onDel}/>
            
        </div>
    );
};

export default Movies;