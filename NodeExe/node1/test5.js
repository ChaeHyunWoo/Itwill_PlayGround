/*
배열 만들고 요소 추가하기

push() : 마지막에 데이터 추가
pop() : 마지막 데이터 삭제
unshift() : 맨앞에 데이터 추가
shift() : 맨앞에 데이터 삭제
splice() : 여러 데이터 추가/삭제
slice() : 잘라내서 새로운 배열 만들기
 */

var users = [{name:"배수지",age:27},{name:"유인나",age:40}];

users.push({name:"박신혜",age:33});

console.log("데이터 갯수:" + users.length); //데이터 갯수:3
console.log(users[0].name); //배수지
console.log(users[1].name); //유인나
console.log(users[2].name); //박신혜

console.log("-------------------");

//데이터를 한꺼번에 출력할려면
console.dir(users); //json형태로 출력

for(var i=0; i<users.length; i++) {
	console.log(users[i].name);
}
console.log("-------------------");

users.forEach(function(item,index) {
	console.log(index + ":" + item.name + ":" + item.age);
});

console.log("-------------------");

users.splice(0,1); //index 0에서 1개의 데이터
for(var i=0; i<users.length; i++) {
	console.log(users[i].name); //배수지가 삭제되고, 유인나, 박신혜 만 출력
}
console.log("-------------------");

//배열에 함수 추가
var add = function(a,b) {
	return a + b;
}

users.push(add);
console.log(users[2](10,20)); //30 추가

console.log("-------------------");

for(var i=0; i<users.length; i++) {
	console.log(users[i].name); 
}

console.log("-------------------");

//데이터 추가
users.push({name:"이효리", age:40});
users.push({name:"정인성", age:30});
for(var i=0; i<users.length; i++) {
	console.log(users[i].name); 
}

console.log("-------------------");

//마지막 데이터 삭제
users.pop();
for(var i=0; i<users.length; i++) {
	console.log(users[i].name);  //마지막 데이터인 정인성 삭제
}

console.log("-------------------");

//첫번째 데이터 삭제
users.shift();
for(var i=0; i<users.length; i++) {
	console.log(users[i].name);  //첫번째 데이터 삭제 = 유인나
}

console.log("-------------------");

//첫번째에 데이터 추가하기
users.unshift({name:"김지현", age:30});

for(var i=0; i<users.length; i++) {
	console.log(users[i].name);  //첫번째에 김지현 추가
}

console.log("-------------------");

//중간 데이터 삭제
delete users[1];

console.log(users); //데이터는 지워지는데 공간은 남아있다.

console.log("-------------------");

//index1에 추가 - splice로 추가
users.splice(1,0,{name:"빅마마", age:40});
console.log(users);

console.log("-------------------");

//splice로 삭제 - delete로 삭제하면 공간이 남아있고 그 공간에 데이터 추가를 못한다.
users.splice(2,1); // 그래서 splice로 삭제해주는 게 좋다.
console.log(users);

console.log("-------------------");

//slice : 잘라내서 새로운 배열 만들기
console.log(users.length); //현재 배열의 길이는 4

var users2 = users.slice(1,3); // 3-1 /1에서부터 2개 / 1을 제외하고 2,3을 출력
console.log(users);
console.log("-------------------");
console.log(users2);
