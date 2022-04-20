import React from 'react';

const TodoItem = ({todos}) => {
    const {id,text,done} = todos
    return (
        <li>
            <span>&#x02713;</span>
            <em>{text}</em>
            <button>삭제</button>
        </li>
    );
};

export default TodoItem;