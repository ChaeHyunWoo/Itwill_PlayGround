import React from 'react';
import {
  Switch,
  Route,
  Link
} from "react-router-dom";
import About from './router4/About';
import Home from './router4/Home';
import NotFile from './router4/NotFile';
import Profile from './router4/Profile';

const App = () => {
  return (
      <div>
        <nav>
          <ul>
            <li><Link to='/'>Home</Link></li>
            <li><Link to='/about'>About</Link></li>
            <li><Link to='/profile'>Profile</Link></li>
          </ul>
        </nav>

      {/* 화면에 보여질 영역 */}
      <Switch>
        <Route path='/' exact><Home/></Route>{/* 주소가 /부터 시작하니 Home이 가장 먼저 나오는것. exact:해당주소가 정확히나와야 실행되게 */}
        <Route path='/about'><About/></Route>
        <Route path='/profile'><Profile/></Route>
        <Route path='*'><NotFile/></Route>
      </Switch>
    </div>
  );
};

export default App;

/*
SPA(Single Page Application)

유저가 처음 접속했을 때 구체적인 data를 제외한 정적파일을 불러와 한개의 페이지에서 데이터만 바꿔서 보여줌

BrowserRouter : html5의 history API를 활용한 UI 업데이트

*/