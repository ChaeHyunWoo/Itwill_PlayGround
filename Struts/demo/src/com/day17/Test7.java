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

//���� �޴��� ����� 
//�����̶�°ǵ� �տ� J�� ������ �ȴ�

public class Test7 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbl;
	
	public Test7() {
		
		lbl = new JLabel("�޼���",JLabel.CENTER);
		add(lbl);
		
		//�޴��߰�
		JMenuBar mbar = new JMenuBar();
		JMenu menu;
		JMenuItem mi;
		
		menu = new JMenu("�޼�����ȭ����");
		
		mi = new JMenuItem("�޼���");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("�Է�");
		menu.add(mi);
		mi.addActionListener(this);
		
		mi = new JMenuItem("����");
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

		
		
		
		setTitle("��ȭ����");
		setSize(300, 300);
		setVisible(true);
	}

	
	
	public static void main(String[] args) {
		
		new Test7();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String str = e.getActionCommand();
		//������ Ŭ�������� �� ������ �״�� �����´�
		
		if(str.equals("�޼���")) {
			JOptionPane.showMessageDialog(this, "������ �ݿ����Դϴ�",
					"���� �˸�",JOptionPane.INFORMATION_MESSAGE);
			//this -> �� �տ��ٰ� �����
			
		}else if(str.equals("�Է�")) {
			
			String age = JOptionPane.showInputDialog(this,
					"���̰� ����Դϱ�?","�Է�",
							JOptionPane.QUESTION_MESSAGE);
			
			lbl.setText("����� ���̴� " + age + "�� �̱���");
			
		}else if(str.equals("����")) {
			
			int result;
			
			result = JOptionPane.showConfirmDialog(this, 
					"���α׷��� �����Ͻðڽ��ϱ�?","����Ȯ��",
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
