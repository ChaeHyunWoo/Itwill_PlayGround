import {createGlobalStyle} from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`

${reset}
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
  
  body{
    font-family: 'Noto Sans KR', sans-serif;
    font-size:15px;
    line-height:1.6;
    margin:50px;
  }
  a { text-decoration:none ; color:#000 }
  li { list-style:none }

`

export default GlobalStyle;