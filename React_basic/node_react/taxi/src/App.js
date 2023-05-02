import React from 'react';
import './assets/css/reset.css';
import Customer from './customer/Customer';

//taxi는 node의 영역
//node_react는 react의 영역
const App = () => {
  return (
    <div>
      <Customer/>
    </div>
  );
};

export default App;