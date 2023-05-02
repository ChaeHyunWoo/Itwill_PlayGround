import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
//root를 실제로 가지고 있는 애가 index.js이다. - 실제 돔안에 가상 돔을 넣는다.
// - index.js를 돔을 합쳐주는 애
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);
//이건 예전 방법 - (가상돔, 실제돔) = ReactDOM.render(el,dom)
/*
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,document.getElementById('root')
)  */

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
