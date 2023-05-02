import React, { useRef, useState } from 'react';

//Enter를 사용해서 값을 입력
const Test4 = () => {

    const no = useRef(1)
    const textRef = useRef()

    const [data,setData] = useState([])
    const [text,setText] = useState('')

    const onText = (evt) => {
        const {value} = evt.target
        setText(value)
    }

    const onAdd = (evt) => {
        //새로고침도 이벤트인데 이걸 사용해서 새로고침 막음
        //엔터를 사용할 때 필수
        evt.preventDefault()

        setData([
            ...data,
            {
                id:no.current++,
                text:text //key와 value가 같으면 생략 가능
            }
        ])
        setText('')
        textRef.current.focus()
    }

    return (
        <div>
            <form onSubmit={onAdd}>
                <input type='text' onChange={onText} value={text}
                name='text'/>
            </form>
            <button>추가</button>
            <ul>
                {
                    data.map(item=><li key={item.id}>
                        {item.id} / {item.text}
                    </li>)
                }
            </ul>
        </div>
    );
};

export default Test4;