import React from 'react';
import Home from './components/Home';
import { Link, Route, Switch} from 'react-router-dom';
import NotFile from './router3/NotFile';
import About from './router3/About';
import Profile from './router3/Profile';





const App = () => {
  return (
    // <li>Home</li>
      <div>
        <nav>
                <ul>
                <li><Link to='/'>Home</Link></li>
                <li><Link to='/about'>About</Link></li>
                <li><Link to='/profile'>Profile</Link></li>

                </ul>
        </nav>
    {/* 화면에 보여지는 영역 */}
          <Switch>
            <Route path='/' exact><Home/></Route>
            <Route path='/about'><About/></Route>
            <Route path='/profile'><Profile/></Route>
  
            <Route path='*'><NotFile/></Route>
          </Switch>
      </div>
  );
};

export default App;
/* 
SPA (Single Page Application)

유저가 처음 접속했을때 구체적인 data를 제외한 정적파일을 불러와 
한개의 페이지에서 데이터만 바꿔서 보여줌

BrowserRouter : html5의 history API를 활용한 UI 업데이트
 */