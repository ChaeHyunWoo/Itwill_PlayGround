import React, { useEffect, useState } from 'react';
import Test2Sub from './Test2Sub';

const Test2 = () => {

    const [isShow,setIsShow] = useState(false)
    const [msg,setMsg] = useState('')

    const onMsg1 = () => {
        const result = window.confirm('전부 삭제하시겠습니까???')

        if(result) {
            setIsShow(true)
            setMsg('예 전부 삭제합니드앙!!!!')
        }
    }

    const onMsg2 = () => {
        const result = window.confirm('전부 복구하시겠습니까???')

        if(result) {
            setIsShow(true)
            setMsg('예 전부 복구합니드앙!!!!')
        }
    }

    useEffect(() => {
        const timer = setTimeout(() => {
            setIsShow(false)
        },1500)

        return () => {
            clearInterval(timer)
        }
    })

    return (
        <div>
            <p>
                <button onClick={onMsg1}>전체삭제</button>
                <button onClick={onMsg2}>전체복구</button>
                
            </p> 
            {
                isShow && <Test2Sub msg={msg} setIsShow={setIsShow}/>
            }
        </div>
    );
};

export default Test2;