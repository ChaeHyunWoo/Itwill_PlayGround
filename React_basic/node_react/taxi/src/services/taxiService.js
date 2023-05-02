import axios from 'axios';

//조회
const getUser = async () => {
    const res = await axios.get('/api/taxi')

    return res.data
}

//입력
const addUser = async (user,image) => {
    axios.post('/api/taxi', {
        name:user.name,
        job:user.job
    }).then(res => {
        console.log(res)
    }).catch(error => {
        console.log(error)
    })

    const formData = new FormData();
    formData.append('upload',image)

    axios.post('/api/fileUpload',formData)
    .then(res => {
        console.log(res)
    }).catch(error => {
        console.log(error)
    })
}

//수정
const updateUser = async (user) => {
    axios.put('/api/taxi', {
        id:user._id,
        name:user.name,
        job:user.job
    }).then(res => {
        console.log(res)
    }).catch(error => {
        console.log(error)
    })
}

//삭제
const deleteUser = async (id) => {
    axios.delete('/api/taxi',{
        data : {id:id} //삭제할 id만 넘겨줌
    }).then(res => {
        console.log(res)
    }).catch(error => {
        console.log(error)
    })
}


export default {
    getUser:getUser,
    addUser:addUser,
    updateUser:updateUser,
    deleteUser:deleteUser
}