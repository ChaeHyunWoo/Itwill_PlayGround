package practice;
// 인터페이스 기본 예제
interface PhoneInterface {
    public static final int TIMEOUT = 10000;    // 상수
    public abstract void sendCall();            // 추상 메소드
    public abstract void receiveCall();         // 추상 메소드
    public default void printLogo(){            // default 메소드
        System.out.println("** Phone **");
    }
}

class SamsungPhone implements PhoneInterface{
    // 인터페이스의 모든 추상메소드 구현
    @Override
    public void sendCall(){
        System.out.println("전화를 겁니다.");
    }

    @Override
    public void receiveCall(){
        System.out.println("전화를 받습니다.");
    }

    // 메소드 추가 작성
    public void flash(){
        System.out.println("손전등을 켭니다.");
    }
}