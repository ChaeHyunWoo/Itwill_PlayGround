import React from 'react';
import { AiOutlineClose } from 'react-icons/ai';
import './Modal.css';

const Modal = ({musicNum,onClose}) => {

    const {title,singer,key} = musicNum
    
    return (
        <div className='Modal'>
            <div className='bg'>
                <div className='popup'>
                    <h2>제목: {title}</h2>
                    <div>
                        <iframe src={`https://www.youtube.com/embed/${key}`} frameBorder='0'></iframe>
                    </div>
                    <p>가수: {singer}</p>
                    <span onClick={()=>onClose()}>
                        <i><AiOutlineClose/></i>
                    </span>
                </div>
            </div>
        </div>
    );
};

export default Modal;

