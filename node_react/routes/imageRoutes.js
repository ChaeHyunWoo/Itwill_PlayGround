const multer = require('multer')
const fs = require('fs')
const path = require('path')
const mongoose = require('mongoose')
const Images = mongoose.model('imagedbs')

try {
    fs.readdirSync('uploads')
} catch(error) {
    fs.mkdirSync('uploads')
}

const fileUploadRoutes = (app,router) => {

    var storage = multer.diskStorage({
        destination:(req,fileUpload,callback) => {
            callback(null,'uploads')
        },
        filename:(req,fileUpload,callback) => {
            callback(null,Date.now().toString + path.extname(fileUpload.originalname))
        }
    })

    var uploads = multer({
        storage:storage,
        limits:{
            files:10,
            filesize:1024*1024*1024
        }
    })

    //라우터 추가
    router.route('/api/fileUpload').post(uploads.array('upload',1),(req,res)=> {

        const files = req.files
        let originalName = ''
        let saveName = ''

        if(Array.isArray(files)) {
            for(let i=0; i<files.length; i++) {
                originalName = files[i].originalName
                saveName = files[i].filename

                Images.create({
                    originalFileName:originalName,
                    saveFileName:saveName,
                    path:'http://localhost:8080/' + saveName
                })

            }
        }
        return res.status(200).send()
    })

    //라우터 최종 등록
    app.use('/',router)
}

module.exports = fileUploadRoutes