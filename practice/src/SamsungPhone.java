package practice;
// �������̽� �⺻ ����
interface PhoneInterface {
    public static final int TIMEOUT = 10000;    // ���
    public abstract void sendCall();            // �߻� �޼ҵ�
    public abstract void receiveCall();         // �߻� �޼ҵ�
    public default void printLogo(){            // default �޼ҵ�
        System.out.println("** Phone **");
    }
}

class SamsungPhone implements PhoneInterface{
    // �������̽��� ��� �߻�޼ҵ� ����
    @Override
    public void sendCall(){
        System.out.println("��ȭ�� �̴ϴ�.");
    }

    @Override
    public void receiveCall(){
        System.out.println("��ȭ�� �޽��ϴ�.");
    }

    // �޼ҵ� �߰� �ۼ�
    public void flash(){
        System.out.println("�������� �մϴ�.");
    }
}