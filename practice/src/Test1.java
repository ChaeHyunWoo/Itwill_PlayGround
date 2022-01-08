package practice;

public class Test1 {
	
	//instance 변수와 초기화 메소드는 세트라고 생각. 없으면 초기값 설정할 수 없음.
	private int x;  //instance변수
	
	//생성자코딩. 변수선언한 끝에 있음. void, int 등 리턴값 없음. 	
 	public Test1(){ //기본생성자. 무조건 작성되어지고 표기가 생략되어 있음. 중복정의(오버로딩) 할거 아니라면 생략
		
 		this(100); // = Test1(int x);                 오버로딩된 생성자를 호출. 사용하려면 맨앞줄에 한번만 써줘야 오류안남 
 		
 		System.out.println("기본생성자(인수가 없는 생성자)");
		x=10; //생성자를 통한 변수초기화
		System.out.println("x: "+ x);
	}

	public Test1(int x){//필요에 의해 만드는 오버로딩된 생성자		
	
		//this(); // 오버로딩된 생성자에서 기본생성자 호출가능. 지금은 기본생성자 호출. 사용하려면 맨앞줄에 한번만 써줘야 오류안남 
		System.out.println("중복정의된 생성자");
		this.x = x;
		System.out.println("x: "+ x);
	}
	
	public void set(int x){ //초기화메소드	
		this.x = x;
	}
	
	//생성자를 통한 변수초기화 : public Test1() 가 
	//초기화메소드: set() 를 이용한 초기화보다 빠르다! 
	
	
	public static void main(String[] args) {
		
		Test1 ob1 = new Test1(); //객체 생성을 통해 메모리를 할당받고 public Test1()로 가서 실행해줌. 기본생성자 호출
		ob1.set(10);		
		
		System.out.println("main ob1.x: " + ob1.x);	
		Test1 ob2 = new Test1(20); //오버로딩된 생성자 호출. 객체 생성과 동시에 초기화 진행
		//오버로딩된 생성자를 사용하기 위해서는 반드시 기본생성자도 같이 정의해줘야 함
		//이 때, 기본생성자를 정의하지 않는다면 사용이 불가능.
		//중복정의해서 사용하는 게 자주 있진 않지만, 필요할 수 있으니 기억.
		
	}

}