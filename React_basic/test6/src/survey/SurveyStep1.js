import React from 'react';
import './style.css'

const SurveyStep1 = ({onText,name,age,addr,tel,onNext}) => {
    return (
        <>
            <p>
                <label>이름</label>
                <input type='text' value={name} name='name' onChange={onText}/>
            </p>
            <p>
                <label>나이</label>
                <input type='text' value={age} name='age' 
                onChange={onText}/>
            </p>
            <p>
                <label>주소</label>
                <input type='text' value={addr} name='addr' 
                onChange={onText}/>
            </p>
            <p>
                <label>연락처</label>
                <input type='text' value={tel} name='tel' 
                onChange={onText}/>
            </p>
            <p>
                <button onClick={onNext}>다음</button>
            </p>
            
        </>
    );
};

export default SurveyStep1;