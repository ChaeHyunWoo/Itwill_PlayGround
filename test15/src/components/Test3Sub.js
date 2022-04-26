import React from 'react';

const Test3Sub = ({title,cnt}) => {

    console.log({title},{cnt})

    return (
        <div>
            <h1>Test3Sub: {title} : {cnt}</h1>
        </div>
    );
};

export default React.memo(Test3Sub);