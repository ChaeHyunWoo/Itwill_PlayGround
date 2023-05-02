import React from 'react';
import styled,{css} from 'styled-components';

const Container = styled.div`
border: 1px solid #000;
padding: 20px;
margin:20px;
background:${props => props.bg ? props.bg : 'yellow'};
width:${props => props.w ? props.w : '100px'};
`
const Box = styled.button`
width:${props=>props.width?props.width:'100px'};
background:${props=>props.bg ? props.bg:'skyblue'};
height:30px;

${props=>props.good && css`
background:'green';
width:300px;
color:#fff;
height:50px;
border:none;
transition:1s;
&:hover {
    background:hotpink;
    color:#000
}
`}
`

const Test7 = () => {
    return (
        <Container w='500px' bg='pink'>
            <Box width='200px' bg='green'>TEST</Box>
            <Box width='100px' bg='yellow'>TEST</Box>
            <Box>TEST</Box>
            <Box width='300px' bg='tomato'>TEST</Box>
            <Box width='400px'>TEST</Box>
            <Box good>TEST</Box>
        </Container>
    );
};

export default Test7;