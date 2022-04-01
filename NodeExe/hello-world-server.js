var http = require('http');

http.createServer(function handler(req, res) {
	
    res.writeHead(200, {'Content-Type': 'text/plain; charset=utf-8'});
    res.end('안녕 World!!\n');
    
}).listen(1337, 'localhost');
console.log('Server running at http://localhost:1337/');
