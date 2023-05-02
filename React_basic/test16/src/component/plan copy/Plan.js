import React, { useRef, useState } from 'react';
import GlobalStyle from '../styled/Global';
import PlanAdd from './PlanAdd';
import PlanList from './PlanList';
import dataList from './data';

const Plan = () => {

    const no = useRef(dataList.length + 1)

    const [plans,setPlans] = useState(dataList)

    //삭제
    const onDel = (id) => {
        setPlans(plans.filter(plan=>plan.id!==id))
    }

    //토글키
    const onToggle = (id) => {
        setPlans(plans.map(plan=>plan.id===id ? {
            ...plan,done:!plan.done
        }:plan))
    }

    //추가
    const onAdd = (form) => {
        form.id = no.current++
        setPlans([
            ...plans,
            form
        ])
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