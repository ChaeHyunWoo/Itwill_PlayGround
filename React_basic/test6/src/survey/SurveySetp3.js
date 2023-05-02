import React from 'react';

const SurveySetp3 = ({form,onNext,onPrev}) => {

    const {name,age,addr,tel,job,email,gender,hobby} = form

    return (
        <>
        <ul>
            <li><span>이름</span> : <em>{name}</em></li>
            <li><span>나이</span> : <em>{age}</em></li>
            <li><span>주소</span> : <em>{addr}</em></li>
            <li><span>연락처</span> : <em>{tel}</em></li>
            <li><span>작업</span> : <em>{job}</em></li>
            <li><span>이메일</span> : <em>{email}</em></li>
            <li><span>성별</span> : <em>{gender}</em></li>
            <li><span>취미</span> : <em>{hobby}</em></li>
        </ul>
        <p>
            <button onClick={onPrev}>이전</button>
            <button onClick={onNext}>다음</button>
        </p>
        </>
    );
};

export default SurveySetp3;