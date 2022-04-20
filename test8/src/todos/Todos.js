import React, { useRef, useState } from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import './Todos.css';

const Todos = () => {

    const no = useRef(1)

    const [todos,setTodos] = useState([
        //{id:1,text:'점심먹기', done:false}
    ])

    const onAdd = () => {
        alert('추가')
    }

    return (
        <div className='Todos'>
            <h1>Todo List</h1>
            <TodoInput onAdd={onAdd}/>
            <TodoList todos={todos}/>
        </div>
    );
};

export default Todos;