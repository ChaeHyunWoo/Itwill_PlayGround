import React from 'react';
import TodoItem from './TodoItem';
import './TodoList.css';

const TodoList = ({todos}) => {
    return (
        <ul className='TodoList'>
            {
                todos.map(todos=><TodoItem key={todos.id}
                todos={todos}/>)
            }
        </ul>
    );
};

export default TodoList;