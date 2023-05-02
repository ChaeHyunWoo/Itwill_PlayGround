import React from 'react';
import FriendItem from './FriendItem';

// props로 Friends.js에서 넘어온 데이터받음
const FriendList = ({data,onDel}) => {
    return (
        <ul>
            {                       
                data.map(item=><FriendItem key={item.id} item={item} onDel={onDel}/>)
                // key값이 있어야하고 item을 넘겨준다,
            }
        </ul>
    );
};

export default FriendList;