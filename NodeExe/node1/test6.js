/**
콜백함수
- 함수를 호출했을 때 결과를 다른 함수로 전달하는 비동기 방식 코딩
 */

function add(a,b,callback) {
	var result = a + b;
	callback(result);
}

add(10,20,function(result) {
	console.log(result); //30
});
