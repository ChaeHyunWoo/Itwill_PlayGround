import React from 'react';
import { Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
import Front from '../router2/Front';
import data from './data';

const Profile = () => {
    return (
        <div>
            <h1>Profile 페이지 입니다</h1>
            <ul>
                <li><Link to='/profile/html'>html</Link></li>
                <li><Link to='/profile/css'>css</Link></li>
                <li><Link to='/profile/javacript'>javascript</Link></li>
                <li><Link to='/profile/react'>react</Link></li>
            </ul>

            <Route path='/profile/:name'>
                <Front data={data}/>
            </Route>
        </div>
    );
};

export default Profile;