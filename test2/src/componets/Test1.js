import React, { Fragment } from 'react';
import './Test1.css';

const Test1 = () => {

    const title = '제목입니다'

    //background-color (예전에쓰던방법) => backgroundColor(리엑트에서 쓰는 방법)

    const style1 = {
        fontSize:40,
        backgroundColor:'pink',
        padding:10
    }

    //JSX 영역
    return (
        <Fragment>
            <h2 style={style1}>{title}</h2>

            <div className='con-box'>
                <article>text1</article>
                <article>text1</article>
                <article>text1</article>
                <article>text1</article>
            </div>

        </Fragment>
    );
};

export default Test1;