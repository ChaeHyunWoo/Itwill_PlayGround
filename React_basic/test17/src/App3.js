import React from 'react';
import { Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { Switch } from 'react-router-dom';
import Home from './router1/Home';
import NotFile from './router1/NotFile';
import About from './router2/About';
import Front from './router2/Front';
import Profile from './router2/Profile';

const data = [
  {title:'html',info:'html에 대한 설명입니다'},
  {title:'css',info:'css에 대한 설명입니다'},
  {title:'javascript',info:'javascript에 대한 설명입니다'},
  {title:'react',info:'react에 대한 설명입니다'},
]


const App = () => {
  return (
    
    <div>
    <nav>
      <ul className="gub">
        {/* <li><a href="">Home</a></li> */}
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/about'>About</Link></li>
        <li><Link to='/profile'>Profile</Link></li>
        <li><Link to='/front/html'>html</Link></li>
        <li><Link to='/front/css'>css</Link></li>
        <li><Link to='/front/javascript'>javascript</Link></li>
        <li><Link to='/front/react'>react</Link></li>
      </ul>
      </nav>

      {/* 화면에 보여질 영역 */}
      <Switch>
        <Route path="/" exact>
          <Home/>
        </Route>
        <Route path="/about">
          <About/>
        </Route>
        <Route path="/profile">
          <Profile/>
        </Route>
        <Route path="/front/:name"><Front data={data}/>
        </Route>
        <Route path="*">
          <NotFile/>
        </Route>
      </Switch>
      </div>
    
  );
};

export default App;

/*
SPA(Single Page Application)

유저가 처음 접속했을때 구체적인 data를 제외한 
정적파일을 불러와 한개의 페이지에서 데이터만 바꿔서 보여줌

BrowserRouter : html5의 history API를 활용한 UI 업데이트
*/