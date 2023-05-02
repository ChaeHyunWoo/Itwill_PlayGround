import React from 'react';
import {AiOutlineCloseCircle} from "react-icons/ai";

const Modal = ({onClose,movieInfo}) => {

    const {thumbUrl,movieNm,openDt,director} = movieInfo

    return (
        <div className='modal'>
            <div className='bg'></div>
            <div className='popup'>
                <h3>{movieNm}</h3>
                <div>
                    <img src={thumbUrl} alt={movieNm}/>
                </div>
                <br/>
                <strong>감독:{director}</strong><br/>
                <strong>개봉일:{openDt}</strong>
                <p className='close' onClick={onClose}>
                    <AiOutlineCloseCircle/>
                </p>
            </div>
        </div>
    );
};

export default Modal;