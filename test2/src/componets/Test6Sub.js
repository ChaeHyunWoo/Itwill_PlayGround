import React from 'react';

import PropTypes from 'prop-types';

const Test6Sub = ({title,name,age,addr,tel,color,done}) => {
    return (
        //<div style={{border:'1px solid red',padding:30}}>
        <div style={{border:`1px solid ${color}`,padding:30}}>
            <h2>{title}</h2>
            <ul>
                <li>이름: {name}</li>
                <li>나이: {age}</li>
                <li>주소: {addr}</li>
                <li>전화: {tel}</li>
                <li>컬러: {color}</li>
                <li>로그인 여부: {done ? '로그인' : '로그아웃'}</li>
                
            </ul>

        </div>
    );
};



//props의 데이터유형 정의
Test6Sub.propTypes = {
    name: PropTypes.string.isRequired,
    age:PropTypes.number.isRequired,
    addr:PropTypes.string,
    tel:PropTypes.string,
    color:PropTypes.string,
    done:PropTypes.bool
}

//props의 기본값
Test6Sub.defaultProps = {
    name:'무명',
    age:30,
    addr:'대한민국',
    tel:'010-1111-1234',
    done:true
}


export default Test6Sub;