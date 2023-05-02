

import './App.css';
// import Test1 from './components/Test1';
// import Test2 from './components/Test2';
//import Test3 from './components/Test3';
import Test4 from './components/Test4';

//App.js는 가상 dom이다. @가상 돔을 코딩해줘야한다. / index.js와 index.html를 수정 x
function App() {
  return (//return ( )이 JSX영역이다.
  <div>
    <h2>App.js : 화면에 보이는 App 컴포넌트</h2>
    {/* <Test1/>
    <Test2/> */}
    {/* <Test3/> */}
    <Test4/>
  </div>
  );
}

export default App;
