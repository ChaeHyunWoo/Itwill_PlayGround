import React from 'react';

const MenuItem = ({item,onMenu}) => {
    const {name} = item

    // 문장의 첫글자를 대문자로 바꿔주는 작업
    const ch = name.charAt(0).toUpperCase()
    const str = name.slice(1)
    const txt = ch + str
    return (
        <button onClick={()=>onMenu(name)}>
            {txt}
        </button>
    );
};

export default MenuItem;