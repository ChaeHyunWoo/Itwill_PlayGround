import React, { useState } from 'react';
import SurveySetp2 from './SurveySetp2';
import SurveySetp3 from './SurveySetp3';
import SurveySetp4 from './SurveySetp4';
import SurveyStep1 from './SurveyStep1';

const Survey = () => {

    const[step,setStep] = useState(1)

    const [form,setForm] = useState({
        name:'',
        age:'',
        addr:'',
        tel:'',
        job:'',
        email:'',
        gender:'',
        hobby:''
    })

    const {name,age,addr,tel,job,email,gender,hobby} = form

    const onText = (evt) => {
        //evt.target으로 value,name을 받고
        const {value,name} = evt.target

        setForm({
            ...form,
            [name]:value
        })
    }

    const onNext = () => {
        setStep(step + 1)
    }

    const onPrev = () => {
        setStep(step - 1)
    }

    return (
        <div className='wrap'>
            {
                step === 1 && <SurveyStep1 onText={onText} 
                name={name} age={age}
                addr={addr} tel={tel} onNext={onNext}/>
            }
            {
                step === 2 && <SurveySetp2 onText={onText} 
                job={job} email={email} gender={gender} 
                hobby={hobby} onNext={onNext} onPrev={onPrev}/>
            }
            {step === 3 && <SurveySetp3 form={form} onNext={onNext}
            onPrev={onPrev}/>}
            {step === 4 && <SurveySetp4 name={name}/>}
        </div>
    );
};

export default Survey;