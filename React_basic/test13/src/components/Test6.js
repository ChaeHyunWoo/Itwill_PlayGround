import React from 'react';
import styled from 'styled-components';

/*
styled-components
컴포넌트로 인식
HTML 요소이름을 추가한 다음 백틱(``)기호로 감싼 영역에
css 코드를 작성하면 css 스타일이 반영된 React 컴포넌트를 만들 수 있다.

const 스타일컴포넌트 = styled.태그``
const 스타일컴포넌트 = styled('태그')``
*/

const Container = styled.div`
width:300px; padding:20px; border:1px solid #000;
`
const Box1 = styled.section`
padding:20px; background:pink; tramsition:0.5s;
margin-bottom:15px;
&:hover {
    background:skyblue;
}
`
const Box2 = styled('article')`
padding:15px; background:tomato; width:100%;
box-sizing:border-box; transition:1s;
margin-bottom:15px;
&:hover {
    width:150%;
}
`
const Box3 = styled('div')`
width:100%; height:100px; background:yellow;
margin-bottom:10px; transition:1s;
&:hover {
    border-radius:0 50px 0 50px;
    background:green;
}
`
const Button = styled.button`
width:150px; background:#000; color:#fff;
height:80px; border:none;
`

const Test6 = () => {
    return (
        <Container>
            <Box1>안녕하세요</Box1>
            <Box2>안녕하세요</Box2>
            <Box3>안녕하세요</Box3>
            <Button>확인</Button>
        </Container>
    );
};

export default Test6;