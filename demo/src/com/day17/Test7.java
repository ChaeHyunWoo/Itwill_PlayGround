package com.day17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

//위에 메뉴를 만든다 
//스윙이라는건데 앞에 J만 붙히면 된다

public class Test7 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test7() {
		
		lbl = new JLabel("메세지",JLabel.CENTER);
		add(lbl);
		
		//메뉴추가
		JMenuBar mbar = new JMenuBar();
		JMenu menu;
		JMenuItem mi;
		
		menu = new JMenu("메세지대화상자");
		
		mi = new JMenuItem("메세지");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("입력");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("종료");
		menu.add(mi);
		mi.addActionListener(this);
		
		mbar.add(menu);
		
		setJMenuBar(mbar);
		
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}


		});

		
		
		
		setTitle("대화상자");
		setSize(300, 300);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		
		new Test7();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		//제목을 클릭했을때 그 제목을 그대로 가져온다
		
		if(str.equals("메세지")) {
			JOptionPane.showMessageDialog(this, "내일은 금요일입니다",
					"요일 알림",JOptionPane.INFORMATION_MESSAGE);
			//this -> 내 앞에다가 띄워라
			
		}else if(str.equals("입력")) {
			
			String age = JOptionPane.showInputDialog(this,
					"나이가 몇살입니까?","입력",
							JOptionPane.QUESTION_MESSAGE);
			
			lbl.setText("당신의 나이는 " + age + "살 이군요");
			
		}else if(str.equals("종료")) {
			
			int result;
			
			result = JOptionPane.showConfirmDialog(this, 
					"프로그램을 종료하시겠습니까?","종료확인",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.ERROR_MESSAGE
					);
			
			//lbl.setText(Integer.toString(result));
			
			if(result==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			
			
		}
	
	
	
	
	
	
	
	
	}

}
