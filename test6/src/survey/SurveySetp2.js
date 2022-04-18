import React from 'react';

const SurveySetp2 = ({job,email,gender,hobby,onText,onNext,onPrev}) => {
    return (
        <>
            <p>
                <label>직업</label>
                <input type='text' value={job} name='job'
                onChange={onText}/>
            </p>
            <p>
                <label>이메일</label>
                <input type='text' value={email}
                name='email' onChange={onText}/>
            </p>
            <p>
                <label>성별</label>
                <input type='text' value={gender}
                name='gender' onChange={onText}/>
            </p>
            <p>
                <label>취미</label>
                <input type='text' value={hobby}
                name='hobby' onChange={onText}/>
            </p>
            <p>
                <button onClick={onPrev}>이전</button>
                <button onClick={onNext}>다음</button>
            </p>
            
        </>
    );
};

export default SurveySetp2;