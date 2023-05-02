const {createProxyMiddleware} = require('http-proxy-middleware');

//app는 express 서버
// - '/api/*' 주소가 오면 target: 뒤의 주소를 연결하라는 뜻
module.exports = (app) => {
    app.use(createProxyMiddleware('/api/*',{target:'http://localhost:8080'}))
}

//2개의 서버(node, react) 연결하는 방법
