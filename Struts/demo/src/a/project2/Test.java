package a.project2;

public class Test extends Thread{

	public void mainImage() throws Exception {

		 try {
             
             Thread.sleep(0);
        }catch(InterruptedException e) {
             e.printStackTrace();
        }
        
        //��ũ�ε�
	    String MAIN[] = { // Ÿ���� ������ - �͸� Ŭ����
	    		"�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�",	
	    		"��..............................................................................................��",
	    		"��..........................................,8DDDDDDDDDO........................................��",
	    		"��....................................,8DDDDDDZZ8DDDDDDDDDDDDD..................................��",
	    		"��.................8:...............DDDDDDDDDDD8D$$ODDDDDDDDDDDDD8..............................��",
	    		"��..................DDD..............DDDD...........DDD.....ND8DDDDDD...........................��",
	    		"��...................~DDDD............DDDD.........DDDD.........7DDDDDD.........................��",
	    		"��.....................DDDD8..........O8DD8........DDDD............D8DDDD=......................��",
	    		"��......................8DDDDI.........NDDD7.......DDDZ....,DDD......,8DDDD.....................��",
	    		"��......................DDDDDDD:........DDDD,......DDDZ.....DDD......ZDDDDD.....................��",
	    		"��....................,DDDD,DDDDDD.......DDDD......DDDD............DDDDDD.......................��",
	    		"��...................NDDD:....DDDDDDD.....DDDD.....DDDD........,8DDDDDD.........................��",
	    		"��..................DDN.........D8DDDDDDD=.DDDD.....DDD...,$DDDDDDDD7...........................��",
	    		"��.................8...............O88888888888O,...8888888888DOD8..............................��",
	    		"��.....................................$NDDDDDD8D....DDDDDDDD:..................................��",
	    		"��............................................:$DD....,.........................................��",
	    		"��..............................................................................................��",
	    		"��..............................................................................................��",
	    		"��..............................................................................................��",
	    		"��...........................................~:.................................................��",
	    		"��...........�����...�����...�����...��....��...�����...��.....��...�����........��",
	    		"��...........��......,.....��......��..,......��....��......��......���...��...��..............��",
	    		"��...........�����.,....��~,,...�����...�����......��......��..��.��...��..���........��",
	    		"��...........��...=..,.....��..,........I��...��....��......��......��...���...��....��........��",
	    		"��...........��......,..�����,.,�����.,.��,...��...�����...��.....��...�����........��",
	    		"��..............................................................................................��",
	    		"��..............................................................................................��",
	    		"��.................................��....��...�����...��...��...��...........................��",
	    		"��.................................���..��...��....��...��...��...��...........................��",
	    		"��.................................��.��.��...��~:..��... ��..��..��............................��",
	    		"��.................................��..���...��....��....���..���............................��",
	    		"��.................................��....��...�����.....��....��.............................��",
	    		"��..............................................................................................��",
	    		"��..............................................~:..............................................��",	
	    		"�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�GAME START�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�",	
	    			
	    		"������������������� GAME  EXPLANATION �����������������������",
	    		"��...............................................................................................��",
	    		"��	FISHING NOW��  ����Ƽ����������ũ ������ ������ �������� �������� ���γ���....................��",
	    		"��                                                                                               ��",
	    		"�� ....����ϴ� ���ð������� �����մϴ�..........................................................��",
	    		"��                                                                                               ��",
	    		"��	����Ʈ������  �ٴٿ� �����ϴ� �پ��� ���������...............................................��",
	    		"��                                                                                               ��",
	    		"��		FISHING NOW�� ���� ���� ������ ���� �� �ֽ��ϴ�...........................................��",
	    		"��                                                                                               ��",
	    		"��	                 ������ ������� ���������� Ű�� ���� �ְ� �丮�� ��� ���� �ֽ��ϴ�..........��",
	    		"��                                                                                               ��",
	    		"��			�ڡڡڡڡڡڡڡڡڡ�10���� ȣ�� �丮�簡 ���� �丮�� ���ش�ϴ�~......................��",
	    		"��                                                                                               ��",
	    		"��					���� ������ ��ⷯ �����ô�!!.................................................��",
	    		"��...............................................................................................��",
	    		"������������������� GAME  EXPLANATION �����������������������"
		     
	    };
	  

        
	    for (int i = 0; i < MAIN.length; i++) {
		      // �� �� �����Ѵ�
		      //Thread.sleep(10);
		      // �޼����� ����Ѵ�
		      System.out.println(MAIN[i]);
		}                            
	}
	
	
	public void fish1() throws Exception {
		
		try {
             
             Thread.sleep(0);
        }catch(InterruptedException e) {
             e.printStackTrace();
        }
		
		String[] fishT = {
		
				" o 								" , 
				"o      ______/~/~/~/__           /(( " , 
				"  o  // __            ====__    /_(( " , 
				" o  //  @))       ))))      ===/__(( " , 
				"    ))           )))))))        __(( " , 
				"    \\\\     \\)     ))))    __===\\ _(( " , 
				"     \\\\_______________====      \\_(( " , 
				"                                 \\((",
		 ""};
		
		for (int i = 0; i < fishT.length; i++) {
		    Thread.sleep(450);
			System.out.println(fishT[i]);
		}	
	}   

public void fishBobber1() throws Exception {

	System.out.println("................................��............................");
	System.out.println("...............................���............................");
	System.out.println("...............................���............................");
	System.out.println("...............................���............................");
    System.out.println("...............................���............................");
	System.out.println("...............................���............................");
	System.out.println("..............................����............................");
	System.out.println("............................������..........................");
	System.out.println("..........................��������........................");
	System.out.println(".........................���������.......................");
	System.out.println(".............................................................");
	System.out.println("..........................��������........................");
	System.out.println("...........................�������.........................");
	System.out.println("............................������..........................");
	System.out.println(".............................�����..~~~~~~~~~...............");
	System.out.println(".....~~~~~~~~~~~~~~~~~~~~.....����.....~~~~~~~~~~~~~~~~.......");
	System.out.println("...........~~~~~~~~~~~~~~.......��....~~~~~~~~~~~~~~~~~........");
	System.out.println("..............~~~~~~~~~~~~~~~~~~~~...........................");
	System.out.println("..............................~~~~~~~~~~~~...................");
	System.out.println("................................��.............................");
	System.out.println("...........~~~~~~~~~~~..........��.............................");
	System.out.println("................................��.......~~~~~~~~~~............");

	
}

public void fishBobber2() throws Exception {
	
	System.out.println("................................��............................");
	System.out.println("...............................���............................");
	System.out.println("...............................���............................");
	System.out.println("...............................���............................");
    System.out.println("...............................���............................");
	System.out.println("...............................���............................");
	System.out.println("..............................����............................");
	System.out.println("............................������..........................");
	System.out.println("..........................��������........................");
	System.out.println(".........................���������.......................");
	System.out.println(".............................................................");
	System.out.println("..........................��������........................");
	System.out.println("...........................�������.........................");
	System.out.println("............................������..........................");
	System.out.println(".............................�����...~~~...~~~...............");
	System.out.println("..............~~.....~~~~.....����.....~~......~~~~~~~~.......");
	System.out.println("...........~~~~~~~~~~~~~~.......��....~~~~~~~~~~~~~~~~~........");
	System.out.println("..............~~~~.......~~~~~~~~~...........................");
	System.out.println("..............................~~~~~~~~~~~~...................");
	System.out.println("................................��.............................");
	System.out.println("..............~~...~~~..........��.............................");
	System.out.println("................................��.........~~...~~~............");
}

public void fishRelease() throws Exception {

try {

Thread.sleep(0);
}catch(InterruptedException e) {
e.printStackTrace();
}

String[] fishR = {""
, 
"~^~^~^~^~^~^~^~^~^~^~^~^~~^~^~^~^~^~^~^~^~^~^",
"~^~^^~^~^~^~^~^~^~^~^~~^~~^~^~^~^~^~^~^~^~^~^", 
"~^~^~^o      ______/~/~/~/__          /((~^~^", 
"~^~^~ o  // __            ====__    / ((~^~^", 
"~^~^~o  //  @))       ))))      ===/ _((~^~^", 
"~^~^~   ))           )))))))         _((~^~^", 
"~^~^~   \\\\     \\)     )))) _===\\ ((~~^~^", 
"~^~^~    \\\\_______________====   \\_((~^~^", 
"~^~^~                               \\((~^~^",
"~^~^~^~^~^~^~^~^~^~^~^~^~~^~^~^~^~^~^~^~^~^~^",
"~^~^~^~^~^~^~^~^~^~^~^~^~~^~^~^~^~^~^~^~^~^~^"};

for (int i = 0; i < fishR.length; i++) {
Thread.sleep(450);
System.out.println(fishR[i]);
}	
}

}