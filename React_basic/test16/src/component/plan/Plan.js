import React, { useEffect, useRef, useState } from 'react';
import GlobalStyle from '../styled/Global';
import PlanAdd from './PlanAdd';
import PlanList from './PlanList';
//import dataList from './data';

const Plan = () => {

    //const no = useRef(dataList.length + 1)

    //const [plans,setPlans] = useState(dataList)
    const [plans,setPlans] = useState([])

    useEffect(()=>{
        fetch('http://localhost:4000/plans')
        .then(res=>res.json())
        .then(res=>setPlans(res))
    },[])

    //삭제
    const onDel = (id) => {

        //실제 서버에 있는 데이터를 지우는것이다
        fetch(`http://localhost:4000/plans/${id}`,{
            method:'delete'
        })
        //서버에 있는 데이터를 지운다
        setPlans(plans.filter(plan=>plan.id!==id))
    }

    //수정
    const fetchPlan = async(id) => {
        const res = await fetch(`http://localhost:4000/plans/${id}`)
        const data = await res.json()
        return data
    }

    //토글키
    const onToggle = async(id) => {

        //json 데이터를 꺼내와서 수정
        //위 fetchPlan을 호출한것
        const togglePlan = await fetchPlan(id)
        //하나의 데이터 togglePlan의 done값을 반대로 바꿔라
        const updatePlan = {...togglePlan,done:!togglePlan.done}
        
        //수정한 데이터를 다시 넣기
        const res = await fetch(`http://localhost:4000/plans/${id}`,{
            method:'put',
            headers:{
                'Content-type':'application/json'
            },
            body:JSON.stringify(updatePlan)
        })

        //화면에 다시 출력
        getToggle()
        
    }

    const getToggle = () => {
        const config = {method:'get'}
        fetch('http://localhost:4000/plans/',config) //config변수처리로 넣어줌
        .then(res => res.json())
        .then(res => setPlans(res))
    }

    

    //추가
    const onAdd = (form) => {
        //form.id = no.current++
        //실제 저장이 된다
        fetch('http://localhost:4000/plans',{
            method:'post',
            headers:{
                'Content-type':'application/json'
            },
            body:JSON.stringify(form)
        })
        .then(res=>res.json())
        .then(res=>setPlans([
            ...plans,
            res
        ]))
       
    }

    return (
        <div>
            <GlobalStyle/>
            <PlanAdd onAdd={onAdd}/>
            <PlanList plans={plans} onDel={onDel}onToggle={onToggle}/>
        </div>
    );
};

export default Plan;

/*
get : 조회
post : 추가
delete : 삭제
put : 수정

application/json 을 꼭 써야한다 안쓰면 html로 인식한다.
*/