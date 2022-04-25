import React from 'react';
import Masonry from 'react-masonry-css';
import styled from 'styled-components';
import GalleryItem from './GalleryItem';

const ImageContainer = styled.div`
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

const GalleryList = ({data}) => {
    return (
        <ImageContainer>
            <Masonry
            breakpointCols={3}
            className="my-masonry-grid"
            columnClassName="my-masonry-grid_column">       
            {
                data.map(item=><GalleryItem key={item.id}
                item={item}/>)
            }
            </Masonry>
        </ImageContainer>
    );
};

export default GalleryList;