const mongoose =  require('mongoose');

//스키마 정의 - 스키마 : 데이터베이스 유형
const taxiSchema = mongoose.Schema({
    name:{type:String},
    job:{type:String}
})
console.log('스키마 정의!')

// Model(모델) 정의
mongoose.model('taxidbs',taxiSchema) //db 이름 정의 / taxidbs에 스키마 적용
console.log('모델 정의.')

const imageSchema = mongoose.Schema({
    originalFileName:{type:String},
    saveFileName:{type:String},
    path:{type:String}
})
console.log('이미지 스키마 정의')

mongoose.model('imagedbs',imageSchema)
console.log('이미지 모델 정의')
