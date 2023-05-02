import React from 'react';
import { Route } from 'react-router-dom';
import { Link } from 'react-router-dom';

import data from './data';
import User from './User';

const Profile = () => {
    return (
        <div>
            <h1>Profile 페이지 입니다</h1>
            <ul>
                <li><Link to='/profile/user1'>정인선</Link></li>
                <li><Link to='/profile/user2'>배수지</Link></li>
                <li><Link to='/profile/user3'>박신혜</Link></li>
                <li><Link to='/profile/user4'>유인나</Link></li>
            </ul>

            <Route path='/profile/:userName'>
                <User/>
            </Route>
        </div>
    );
};

export default Profile;