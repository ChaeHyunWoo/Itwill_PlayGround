import styled from 'styled-components';

export const Article = styled.article`

    width:450px; border:1px solid #dcdcdc;
    padding:20px;
    margin-bottom:15px;
    position: relative;
    h3 { font-size:35px; color:tomato; margin-bottom:15px; }
    p { font-size:20px }
    .icon { position:absolute; right:20px; top:50%; transform:translateY(-50%); font-size:40px }
    &.on{
        background:rgba(100,200,100,0.1);
        border-color:tomato;
    }

`
export const PlanForm = styled.form`

    margin-bottom:40px;
    margin-top:20px;
    border:1px solid #999;
    width:450px;
    padding:20px;
    div {
        margin-bottom:15px;
        label { display:inline-block; width:100px;}
        input[type=text] {
            width:250px; height:35px;
            border:1px solid #999;
            padding:0 15px;
        }
    }
    button { width:120px; height:35px; background:#000; color:#fff; border:none }

`