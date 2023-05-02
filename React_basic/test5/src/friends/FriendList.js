import React from 'react';
import FriendItem from './FriendItem';

const FriendList = ({data}) => {
    return (
        <ul>
            {
                data.map(item=><FriendItem key={item.id} item={item}/>)
            
            }
            </ul>
    );
};

export default FriendList;