import React, { useEffect } from 'react';

const Test2Sub = ({msg,setIsShow}) => {

    /*
    useEffect(() => {
        const timer = setTimeout(() => {
            setIsShow(false)
        },1500)

        return () => {
            clearInterval(timer)
        }
    })
    */

    return (
        <div style={{background:'yellow',padding:15,
        margin:30,fontSize:25}}>
            메세지: {msg}
            
        </div>
    );
};

export default Test2Sub;