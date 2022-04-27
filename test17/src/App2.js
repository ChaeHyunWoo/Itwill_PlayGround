import React from 'react';
import { Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { Switch } from 'react-router-dom';
import { BrowserRouter as Router } from 'react-router-dom';
import Ceo from './router1/Ceo';
import Home from './router1/Home';
import NotFile from './router1/NotFile';
import Sub1 from './router1/Sub1';
import Sub2 from './router1/Sub2';


const App = () => {
  return (
    
    
    <div>
    <nav>
      <ul className="gub">
        {/* <li><a href="">Home</a></li> */}
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/ceo'>Ceo</Link></li>
        <li><Link to='/sub1'>Sub1</Link></li>
        <li><Link to='/sub2'>Sub2</Link></li>
      </ul>
      </nav>

      {/* 화면에 보여질 영역 */}
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/ceo">
          <Ceo />
        </Route>
        <Route path="/sub1">
          <Sub1 />
        </Route>
        <Route path="/sub2">
          <Sub2 />
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