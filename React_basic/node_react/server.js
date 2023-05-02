//애는 node 서버이다.
const express = require('express')
const http = require('http')
const mongoose = require('mongoose')
const path = require('path')

//스키마 호출
require('./models/taxiSchema')

//익스프레스(express) 객체 생성
const app = express();

//라우팅 함수
const router = express.Router()

//기본 port를 app객체의 속성으로 설정 - (app는 express서버)
app.set('port',process.env.PORT || 8080)

//파일 업로드 폴더 설정
app.use(express.static('uploads'))

//DB(몽고DB) 연결 - 몽고DB 기본포트 : 27017
mongoose.connect('mongodb://localhost:27017/shopping')
console.log('데이터베이스 연결 성공')

//JSON 형태 데이터를 인식하게끔 App(express서버)에 등록
app.use(express.json())

//라우터 등록
require('./routes/taxiRouters')(app)
require('./routes/imageRoutes')(app,router)

//Express 서버 시작
http.createServer(app).listen(app.get('port'),function() {
    console.log('서버를 시작했습니다. : ' + app.get('port'))
})

//프로젝트 build
app.use(express.static(path.join(__dirname,'/taxi/build')))

app.get('/',function(req,resp) {
    resp.sendFile(path.join(__dirname,'/taxi/build/index.html'))
})