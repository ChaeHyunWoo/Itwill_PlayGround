import React from 'react';
import { Route } from 'react-router-dom';
import { Link } from 'react-router-dom';
import { Switch } from 'react-router-dom';
import { BrowserRouter } from 'react-router-dom';
import About from './component/About';
import Home from './component/Home';
import Sub from './component/Sub';

const App = () => {
  return (
    <div>
      
      <ul className="gub">
        {/* <li><a href="">Home</a></li> */}
        <li><Link to='/'>Home</Link></li>
        <li><Link to='/about'>About</Link></li>
        <li><Link to='/sub'>Sub</Link></li>
      </ul>

      {/* 화면에 보여질 영역 */}
      <Switch>
        <Route path="/" component={Home} exact/>
        <Route path="/about" component={About}/>
        <Route path="/Sub" component={Sub}/>
        {/* <Route path="/" component={Home}/> */}
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