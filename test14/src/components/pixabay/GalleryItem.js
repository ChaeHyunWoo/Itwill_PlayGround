import React from 'react';
import styled from 'styled-components';

//그림 크기 수정하는 곳
const ImageItem = styled.article`
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

const GalleryItem = ({item}) => {

    const {views,downloads,likes,user,webformatURL,tags} = item

    const taglist = tags.split(',')

    return (
        <ImageItem>
            <img src={webformatURL} alt={user}/>
            <h3>{user}</h3>
        <ul>
            <li><em>조회수: {views}</em></li>
            <li><em>다운로드: {downloads}</em></li>
            <li><em>좋아요: {likes}</em></li>
        </ul>
        <p>
            태그: {taglist.map((tag,index)=><span key={index}>#{tag}</span>)}
        </p>
        </ImageItem>
    );
};

export default GalleryItem;