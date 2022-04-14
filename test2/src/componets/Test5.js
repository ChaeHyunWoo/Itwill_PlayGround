import React from 'react';

const Sub = ({name,age,done}) => {
    return(
        <div>
            <h3>이름:{name}({typeof name})</h3>
            <h3>나이:{age}({typeof age})</h3>
            <h3>로그인여부:{done ? '로그인' : '로그아웃'}
            ({typeof done})</h3>
        </div>
    )
}

const Test5 = () => {

    const data1 = {name:'정인선', age:28, done:true}
    const data2 = {name:'유인나', age:40, done:false}

    return (
        <div>
            <Sub name='배수지' age={27} done={true}/>
            <br/>
            <Sub name='안젤리나' age={25} done={false}/>
            <br/>
            <Sub name='{data1.name}' age={data1.age} done={data1.done}/>
            <br/>
            <Sub {...data1}/>
            <br/>
            <Sub {...data2}/>
        </div>
    );
};

export default Test5;