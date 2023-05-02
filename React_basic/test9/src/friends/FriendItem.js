import React from 'react';
//FriendList.js에서 넘어온 item을 사용하기쉽게 비구조방식으로
const FriendItem = ({item,onDel}) => {

    const {id,name,age,image} = item

    return (
        <li>
            <p>
                <img src={image} alt={name}/>
            </p>
            <div>
                <strong>이름 : {name}</strong>
                <span>나이 : {age}</span>
                <button onClick={()=>onDel(id)}>삭제</button>
            </div>            
        </li>
    );
};


export default FriendItem;