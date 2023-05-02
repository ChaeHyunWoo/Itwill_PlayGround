import React from 'react';
import { useParams } from 'react-router-dom';
import data from './data';

const User = () => {

    const {userName} = useParams();

    const uProfile = data[userName]

    return (
        <div>
            <h1>User Page 입니다</h1>
            <h2>
                {uProfile.name} / {uProfile.job}
            </h2>
        </div>
    );
};

export default User;