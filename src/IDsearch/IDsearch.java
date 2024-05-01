package IDsearch;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Member.MessageDialog;

public class IDsearch extends JFrame{	//TestTestTestTestTestTestTestTestTestTestTest

	private JFrame f;
	private JTextField tfName, tfEmail, tfpwd;
	private JButton btn;
	dao = new IdDAO();
	public void IDFrame() {
		
		f = new JFrame("ID");
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);
		
		JLabel lId = new JLabel("이름");
		lId.setLocation(50, 70);
		lId.setSize(50, 50);
		JLabel lEmail = new JLabel("이메일");
		lEmail.setLocation(50, 130);
		lEmail.setSize(50, 50);
		JLabel lPwd = new JLabel("비밀번호");
		lPwd.setLocation(50, 185);
		lPwd.setSize(50, 60);
		
		tfName = new JTextField(10);
		tfName.setLocation(110, 80);
		tfName.setSize(200, 30);

		tfEmail = new JTextField(10);
		tfEmail.setLocation(110, 140);
		tfEmail.setSize(250, 30);
		
		tfpwd = new JPasswordField(20);
//		tfPwd.setEchoChar('*');
		tfpwd.setLocation(110, 200);
		tfpwd.setSize(250, 30);



		
		btn = new JButton("찾기");
		// 로고 이미지 크기 및 위치
		btn.setSize(70, 30);
		btn.setLocation(170, 250);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userNickCheck = tfNickname.getText();
				boolean isDuplicate = dao.isNickname(userNickCheck);
				if (isDuplicate) {
					new MessageDialog(f, "알림", "닉네임이 이미 존재합니다.");
				} else {
					new MessageDialog(f, "알림", "사용 가능한 닉네임입니다.");
				}
			}
		});
		
		
		
		
		
		
		
		f.add(lId);
		f.add(lEmail);
		f.add(lPwd);
		f.add(tfName);
		f.add(tfEmail);
		f.add(tfpwd);
		f.add(btn);
		f.setVisible(true);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IDsearch ID = new IDsearch();					//
		ID.IDFrame();
	}

}
