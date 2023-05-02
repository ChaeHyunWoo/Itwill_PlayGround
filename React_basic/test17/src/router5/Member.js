import React from 'react';
import { useHistory } from 'react-router-dom';
import { Link } from 'react-router-dom';

const Member = ({item}) => {

    const {id,name,email} = item

    //history.push(url)
    const history = useHistory()

    const style = {
        border:'2px solid tomato',
        padding: 20,
        matgin:10,
        borderRadius:15
    }

    const onDetail = () => {
        const url = `/member/${id}`
        history.push(url)
    }

    return (
        <div style={style}>
            <p>ID: {id}</p>
            <h3>이름: {name}</h3>
            <p>이메일: {email}</p>
            <p>
                <Link to={`/member/${id}`}>자세히 보기: {name}</Link>
            </p>
            <p><button onClick={onDetail}>상세페이지 이동</button></p>
            
        </div>
    );
};

export default Member;