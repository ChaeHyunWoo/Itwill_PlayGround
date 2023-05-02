import React from 'react';
import Gallery from './components/pixabay/Gallery';
import Test1 from './components/Test1';
import Test2 from './components/Test2';
import Test3 from './components/Test3';
import Test4 from './components/Test4';

const App = () => {
  return (
    <div>
      {/* <Test1/> */}
      {/* <Test2/> */}
      {/* <Test3/> */}
      {/* <Test4/> */}
      <Gallery/>
    </div>
  );
};

export default App;

/*
Ajax 요청 방법(4가지)
1. fetch 사용(javascript에서 지원)
fetch(url,[option])

fetch(url)
.then(응답=>응답.json())

2. axios(모듈)사용
axios.get(url)
.then(응답=>응답.data)
.then 동기처리

3. async/await 사용(Promise의 단점을 보완)
  - 비동기를 동기처럼 사용 가능

4. async/await + axios 를 복합해서 사용

[js의 데이터와 json데이터 비교]

js파일 -> import aaa from './경로/파일명'

export default [
  {id:1,
  name:'배수지',
  age:20,
  addr:'서울'
  }
]
------------------------------------------
json파일 -> import aaa from './경로/파일명.json'

[
  {
  'id':1,
  'name':'배수지',
  'age':20,
  'addr':'서울'
  }
]
*/