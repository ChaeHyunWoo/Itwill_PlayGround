import React from 'react';

const Test2 = () => {

    //event

    const click = (e) => {  //이벤트 출력
        console.log(e.target) //e.target : 내가 클릭한 대상
        console.log(e.currentTarget) // 이벤트가 붙어있는 대상
    }

    const onChange = (evt) => {
        console.log(evt.target)
        console.log(evt.target.value)// 이걸로 현재값을 읽어온다.
    }

    return (
        <div>
            <h2 onClick={click}>
                <span>확인</span>
                <em>클릭</em>
                <b>누르기</b>
            </h2>
            <hr/>
            <input type='text' onChange={onChange}/>
        </div>
    );
};

export default Test2;