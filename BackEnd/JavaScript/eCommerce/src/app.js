const compression = require('compression')
const express = require('express')
const { default: helmet } = require('helmet')
const morgan = require('morgan')
const app = express()

//init middlewars
app.use(morgan("dev"))  //ghi lại các request, nhật kí
app.use(helmet())       //Bảo mật thông tin sử dụng
app.use(compression())  //Tiết kiệm lưu lượng vận chuyển
// init db

// init router
app.get('/hello', (req, res, next) =>{
    const temp = 'Hello JavaScript'
    return res.status(200).json({
        message: 'Một gậy bay màu!',
        metadata: temp.repeat(1000)
    })
})

// handling error




module.exports = app