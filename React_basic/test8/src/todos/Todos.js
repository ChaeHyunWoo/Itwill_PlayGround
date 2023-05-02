import React, { useRef, useState } from 'react';
import TodoInput from './TodoInput';
import TodoList from './TodoList';
import './Todos.css';

const Todos = () => {

    const no = useRef(1)

    const [todos,setTodos] = useState([])

    const onAdd = (text) => {
        setTodos([
            ...todos,
            {
                id:no.current++,
                text:text,
                done:false
            }
        ])
    }

    const onDel = (id) => {
        setTodos(todos.filter(todo=>todo.id !== id))
    }

    const onToggle = (id) => {
        setTodos(todos.map(todo=>todo.id===id ?
            {
                ...todo,
                done:!todo.done
            }
            : todo
            ))
    }

    return (
        <div className='Todos'>
            <h1>Todo List</h1>
            <TodoInput onAdd={onAdd}/>
            <TodoList todos={todos} onDel={onDel} onToggle={onToggle}/>
        </div>
    );
};

export default Todos;