import React, { useEffect, useState } from 'react';

const dataList = [
    {id:1,name:'chk1',text:'이용약관(필수)',isChecked:false},
    {id:2,name:'chk2',text:'개인정보 보호 동의(필수)',isChecked:false},
    {id:3,name:'chk3',text:'쿠폰,이벤트,프로모션 수신동의(선택)',isChecked:false},
]

const Test1 = () => {

    //const [data,setData] = useState(dataList)
    
    const [data,setData] = useState([])

    useEffect(()=>{
        setData(dataList)
    },[dataList])

    const changeCheck = (evt) => {

        const {name,checked} = evt.target

        if(name==='all'){

            const tempChk = data.map(item=>{
                return{
                    ...item,
                    isChecked:checked
                }
            })
            setData(tempChk)

        }else{//chk1,chk2,chk3
            const tempChk = data.map(item =>
                item.name===name ? {
                    ...item,
                    isChecked:checked
                }:item)

            setData(tempChk)

        }
    }

    return (
        <div style={{margin:30}}>
            <h2>동의설정</h2>
            <p>
                <input type='checkbox' name='all' onChange={changeCheck}
                checked={data.filter(item=>item.isChecked!==true).length<1}/>
                전체동의
            </p>
            <hr/>
            {
                data.map(item=><p key={item.id}>
                    <input type='checkbox' checked={item.isChecked}
                    name= {item.name} onChange={changeCheck}/>
                    {item.text}
                </p>)
            }
            
        </div>
    );
};

export default Test1;