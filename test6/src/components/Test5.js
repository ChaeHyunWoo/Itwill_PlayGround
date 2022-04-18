import React from 'react';
import img0 from '../s_images/cat0.jpg'
import img1 from '../s_images/cat1.jpg'



const Test5 = () => {
    return (
        <div>
            <img src={img0} alt=''/>
            <img src={img1} alt=''/>
            {/* p_images에있는 그림은 import가 안되서 이렇게 */}
            <hr/> 
            <img src='./p_images/cat3.jpg' alt=''/>
        </div>
        
    );
};

export default Test5;