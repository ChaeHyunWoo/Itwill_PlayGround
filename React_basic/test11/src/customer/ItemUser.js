import React from 'react';

const ItemUser = ({item,onDel,onEdit}) => {

    const {id,name,job} = item

    return (
        <tr>
            <td>{name}</td>
            <td>{job}</td>
            <td>
                <button onClick={()=>onEdit(item)}>수정</button>
                <button onClick={()=>onDel(id)}>삭제</button>
            </td>
        </tr>
    );
};

export default ItemUser;