import React from 'react';
import './Test3.css';
import myStyle from './Test3.module.css';
/*
1.파일명.css
2.파일명.module.css
- 기존의 프로젝트에 클래스를 수정하지 않고 같은 이름으로 작성하되 이름이
  중복되지 않게 해줌
  -- 일반 css : className='box'
  -- module.css : 파일명_클래스명_xxxx
  -- className={참조변수.box} => 파일명_box
*/

const Test3 = () => {
    return (
        <div className='wrap'>
            {/* css,module */}
            <div className='box'></div>
            <div className={myStyle.box}></div>
            
            {/* 다중 클래스 백틱 */}
            <div className='size bg'></div>
            <div className={`${myStyle.size} ${myStyle.bg}`}></div>
            <div className={`size ${myStyle.bg}`}></div>

            {/* 다중 클래스 */}
            <div className={[myStyle.size, myStyle.bg].join(' ')}></div>
            <div className={['size', myStyle.bg].join(' ')}></div>
            {/* join 안의 ' ' 공백은 엔터(줄바꿈) */}
        </div>
    );
};

export default Test3;