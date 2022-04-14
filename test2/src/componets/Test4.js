import React from 'react';

const Sub = ({name,place,date,time,content}) => {

    //비구조 할당
    //const{name,place,date,time,content} = props
    return(
        <div>
            <h2>{name}의 이달의 할일</h2>
            <ul>
                <li>장소: {place}</li>
                <li>날짜: {date}</li>
                <li>시간: {time}</li>
                <li>내용: {content}</li>
            </ul>
        </div>
    )
}

const Test4 = () => {
    return (
        <div>
            {/* props : 부모 컨트롤러에서 자식 컨트롤러로 값을 넘길때 사용 */}
            <Sub name='정인선' place='서울' date='21.06.30' time='AM10:00' content='회사미팅'/>
            <hr/>
            <Sub name='배수지' place='부산' date='21.04.30' time='AM11:00' content='팬미팅'/>
            <hr/>
            <Sub name='유인나' place='대구' date='21.11.30' time='AM7:00' content='시사화'/>
        </div>
    );
};

export default Test4;