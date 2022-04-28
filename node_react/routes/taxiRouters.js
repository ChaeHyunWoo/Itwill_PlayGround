//DB 연동 -라우터
// - 여기는 node에서 DB를 연결해주는 곳
// - 화면(veiw)에서도 DB를 연결해줘야함 -> 리엑트 taxi폴더 안의 src에 services만듬
const mongoose = require('mongoose')

const Taxi = mongoose.model('taxidbs')

//미들웨어 생성
module.exports = (app) => {
    
    //데이터 조회
    app.get('/api/taxi',async(req,res)=> {
        const user = await Taxi.find()

        return res.status(200).send(user) //200 : 정상적으로 실행된 것
    })

    //데이터 입력(insert)
    app.post('/api/taxi',async(req,res)=> {
        const user = await Taxi.create(req.body)

        return res.status(200).send({
            error:false,
            user
        })
    })

    //데이터 수정
    app.put('/api/taxi',async(req,res)=> {
        const id = req.body.id //req(request)로 넘어온 id 받고
        const user = await Taxi.findByIdAndUpdate(id,req.body)

        return res.status(200).send({
            error:false,
            user
        })
    })

    //데이터 삭제
    app.delete('/api/taxi',async(req,res)=>{
        const id = req.body.id
        const user = await Taxi.findByIdAndDelete(id)

        return res.status(200).send({
            error:false,
            user
        })
    })

}