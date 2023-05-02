import React from 'react';
import './Test4.scss';

const Test4 = () => {
    return (
        <div className='header'>
            <div className='inner'>
                <h1>로고(logo)</h1>
                <ul className='topMenu'>
                    <li><a href='#'>홈(Home)</a></li>
                    <li><a href='#'>이메일(E-mail)</a></li>
                    <li><a href='#'>로그인(Login)</a></li>
                </ul>
                <nav className='gnb'>
                    <ul>
                        <li><a href='#'>Menu1</a></li>
                        <li><a href='#'>Menu2</a></li>
                        <li><a href='#'>Menu3</a></li>
                        <li><a href='#'>Menu4</a></li>
                        <li><a href='#'>Menu5</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    );
};

export default Test4;