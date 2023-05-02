package com.day8;
//Call By value
//동일 변수값을 가진다.
//stack 영역의 Heap영역으로 데이가 넘어감

//Call By Reference
//값을 넘길 때 객체의 시작점 주소가 넘아감. 객체의 값이 하나라 두명의 남자가 전화번호를 서로 나누어 가짐
//Heap영역에 있는 데이터를 복사할 때 데이터자체가 복사되는게 아니라 주소가 복사되는 것
//static과 같은 역할을 함
//동일 주소를 가진다. 주소를 서로 나누어 가짐
//이미 만들어진 것을 가져다 쓸 때 사용
class Test {
	public int x = 10; // 인스턴스 변수
	
	public void sub(int a) {
		x += a;
	}
}

public class Test1 {

	public static void main(String[] args) {
		
		Test ob = new Test();
		
		//Call by value
		int a = 20;
		
		System.out.println("Sub메서드 실행전 x : " + ob.x);
		
		ob.sub(a);
		System.out.println("Sub메서드 실행후 x: " + ob.x);
		
		
		//Call By Reference @ 중요 @  - ob의 주소값을 ob1에 넣어라.주소값을 복사해서 같은 곳을 가리키므로 동일값이 나옴
		Test ob1;
		ob1 = ob;
		
		System.out.println(ob.x);//30
		System.out.println(ob.x);//30
		
		//똑같은 위치인 걸 어떻게 아냐? 값을 변경해서 다시 조회해보면 된다.
		ob1.x = 100;
		System.out.println(ob.x);//100
		System.out.println(ob1.x);//100

	}
}