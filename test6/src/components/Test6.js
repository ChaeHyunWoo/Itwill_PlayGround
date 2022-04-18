import React, { useState } from 'react';
import images from '../assets/api/images';

const Test6 = () => {

    const [data,setData] = useState(images);

    return (
        <div>
            {
                data.map(item=><article key={item.id}>
                    <h3>이름: {item.title}</h3>
                    <img src={item.image} alt='' width=''/>
                </article>)
            }
        </div>
    );
};

export default Test6;