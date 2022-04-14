// rsc쓰고 컨트롤 스페이스
import React, { Fragment } from 'react';
// 컴포넌트는 함수영역과 JSX영역으로 나누어진다.

// JSX영역이 실제 화면에 그러지는 코드

// JSX영역 -  처음 시작은 주로 <div></div>로 감싸준다.
// 혹은 <Fragment> </Fragment> 사용할수있다. 

// 한줄은 상관이 없지만 그 이상은 반드시 그룹형 또는 div로 묶어야한다.
// Fragment = 그룹
// Fragment의 경우, Fragment 지우고 <> </> 이렇게 표현 가능
const Test2 = () => {
    return (
        // <div>
        //     <p>함수로 만든 컴포넌트</p>
        // </div>

        //<div>를 생략해주는 애가 <Fragment>이다. 그래서 이걸 쓰면 html만 편하게 써주면 된다.
        // <Fragment>
        //     <h2>JSX영역</h2>
        //     <p>return() 한줄이상은 div로 묶어준다.</p>
        //     <p>div로 계속 묶어줄때는 ul안에 div는 사용 불가</p>
        // </Fragment>

        // 이거도 Fragment태그랑 같다. 괄호 안에 문자 생략가능
        <>
        <p>외태그에는 반드시 /를 해줌</p>
        <input type="text"/>
        </>

    );
};

export default Test2;