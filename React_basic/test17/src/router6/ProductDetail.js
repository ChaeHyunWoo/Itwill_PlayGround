import React from 'react';
import { useHistory } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import data from './data';

const ProductDetail = () => {

    const {productID} = useParams()
    const history = useHistory()

    const thisPro = data.find(item=>item.id===productID)

    const onGo = () => {
        history.push('/products')
    }

    return (
        <div>
            <h1>{thisPro.name} 상세페이지</h1>
            <h2>{thisPro.name} -가격: {thisPro.price}원</h2>
            <p>
                <img src={thisPro.photo} alt='' width="450"/>
            </p> 
                <p>상품 설명: {thisPro.description}</p>
                <button onClick={onGo}>제품목록</button>
            
        </div>
    );
};

export default ProductDetail;