import {createGlobalStyle} from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`

${reset}
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400&display=swap');

body {
    font-size:15px;
    line-height:1.6;
    font-family: 'Noto Sans KR', sans-serif;
    color:#333
}
a {text-decoration:none; color:#333}

.box p{}
`

export default GlobalStyle;