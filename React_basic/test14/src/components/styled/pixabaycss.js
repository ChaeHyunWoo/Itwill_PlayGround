import styled from 'styled-components';

export const Container = styled.div`
width:1400px; margin:auto
`

export const ImageContainer = styled.div`
.my-masonry-grid {
    display: -webkit-box; 
    display: -ms-flexbox; 
    display: flex;
    margin-left: -30px; 
    width: auto;
  }
  .my-masonry-grid_column {
    padding-left: 30px;
    background-clip: padding-box;
  }
  
  /* Style your items */
  .my-masonry-grid_column > div { 
    background: grey;
    margin-bottom: 30px;
  }
`
 //그림 크기 수정하는 곳
export const ImageItem = styled.article`
    width:430px; margin-bottom:60px;
    border: 1px solid #999;
    padding: 20px 15px 35px;
    img {width:400px; margin-bottom:15px}
    h3{font-size:25px; color:tomato; font-weight:600;
        margin-bottom:20px;}
    ul {
        li{margin-bottom:5px;
            em{display:inline-block; width:80px;}
        }
    }
    p {margin-top:20px;
        span{margin-right:10px;}
    }
`

//검색창 디자인
export const ImageForm = styled.form`

text-align:center;
padding:40px 0;
    input{
        width:400px; height:45px; padding:0 15px
        box-sizing:border-box; border:1px solid #999;
        vertical-align:top;
    }
    button{
        width:100px; height:45px; background:#000;
        color:#fff; border:none; margin-left:5px;
    }
`
