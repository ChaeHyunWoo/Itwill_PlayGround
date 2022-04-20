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
[useEffect]
컴포넌트가 렌더링 될때마다 특정 작업을 시간을 정해 실행할수있도록 하는 Hook
화면에 렌더링(화면에 그려진)후에 실행
component가 mount,unmount,update 됐을 때 실행이 된다.

클래스형에서는 componentDidMount와 componentDidUpdate,componentDidUnMount를 합쳐놓은 것

애는 2개의 인수를 받는데 첫번째는 function으로써의 effect이고,
두번째에 넣은 인수 상태가 바뀌면 첫번째 인수를 재실행한다.
[문법]
useEffect(콜백함수,[의존함수])

mount란 리엑트(React)에서 특정 컴포넌트를 끼워넣는 것을 말한다.
ex) #root dom에 App에 넣기(실제dom에 가상의dom넣기)

[useEffect가 실행되는 시점]
- 처음 화면을 렌더링할 때-mount
- 업데이트할때 -update
- 화면이 사라질때 -unmount

1. 기본( 잘 사용 안함)
useEffect(()=> {
    실행문
})

2. 
useEffect(()=> {
    실행문
},[]) // 여기서의 []의 뜻은 실행문을 1번만 실행하라는 뜻

3.
useEffect(()=> {
    실행문
},[의존변수]) // 변수가 바뀔때마다 실행(update)

4.
useEffect(()=> {
    실행문
    //이 방법을 effect의 뒷정리
    return()=> {
        실행문
    }
},[의존변수,의존변수]) //실행문이 2개라 의존변수 또한 2개

뒷정리는 메모리 누수를 방지하기위해서 UI 컴포넌트를 제거하기 전에 실행한다.


*/