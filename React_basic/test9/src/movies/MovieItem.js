import React from 'react';

import Numeral from 'numeral' //numeral.js 사용방법 - 천자리마다 ,를 찍어준다.
import {
    AiOutlineCaretUp,AiOutlineMinus,AiOutlineCaretDown
} from "react-icons/ai";

// MovieList.js에서 넘어온 item을 받아줌
const MovieItem = ({item,onOver}) => {

    const {rank,movieNm,salesAmt,audiCnt,rankInten} = item
// 이미지 : thumbUrl
// 영화명 :movieNm​
// 개봉일 : openDt​
// 제작상태 :moviePrdtStat​
// 영화구분:movieType​
// 관람등급: watchGradeNm​
// 상영시간 :showTs​
// 제작국가:repNationCd​
// 감독:director​
// 장르:genre​
// 배급사: dtNm​
// 영화명 :movieNm​
// 매출액:salesAmt​
// 관객수:audiCnt​
// 증감: rankInten

    return (
        <tr onMouseOver={()=>onOver(rank)}>
            <td>{rank}</td>
            <td>{movieNm}</td>
            <td>{Numeral(salesAmt).format('0,0')}</td>
            <td>{Numeral(audiCnt).format('0,0')}</td>
            <td>
                {rankInten}
                {rankInten===0 && <AiOutlineMinus/>}
                {rankInten>0 && <AiOutlineCaretUp color='red'/>}
                {rankInten<0 && <AiOutlineCaretDown style={{color:'blue'}}/>}
            </td>
        </tr>
    );
};

export default MovieItem;