import React from 'react';
import Test1 from './components/Test1';
import Test2 from './components/Test2';
import Test3 from './components/Test3';

const App = () => {
  return (
    <div>
      {/* <Test1/> */}
      {/* <Test2/> */}
      <Test3/>
    </div>
  );
};

export default App;

/*
useMemo : return 값을 기억함
useCallback : 함수 자체를 기억함

useMemo(함수,의존성)
useMemo(()=>{},deps)
useMemo(()=>{},[의존변수])

useCallback(함수,의존성)
useMemo(()=>{},[의존변수])
*/