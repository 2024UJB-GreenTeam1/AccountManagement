package login;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.ArrayList;

public class LoginFrame extends WindowAdapter {
	private JFrame f;
	private JTextField tfId, tfMsg;
	private JPasswordField tfPwd;
	private JButton btnL,btnI,btnP,btnS;
	private InfoDAO dao;
	ArrayList<InfoVo> list;
	private JPanel tab1Panel;

	
	public LoginFrame() {
		

		dao = new InfoDAO();
		
		f = new JFrame("Login");
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);
		
		tab1Panel = new JPanel();
		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));//bin폴더 넘어가면 안되는듯?
		tab1Panel.add(jLabel);
		tab1Panel.setLocation(140, 10);
		tab1Panel.setSize(400, 400);
		
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);
		
		

		
		
		JLabel lId = new JLabel("ID");
		lId.setLocation(170, 440);
		lId.setSize(50, 50);
		JLabel lPwd = new JLabel("PWD");
		lPwd.setLocation(170, 480);
		lPwd.setSize(50, 50);

		tfId = new JTextField(10);
		tfId.setLocation(220, 450);
		tfId.setSize(200, 30);

		tfPwd = new JPasswordField(10);
		tfPwd.setEchoChar('*');
		tfPwd.setLocation(220, 490);
		tfPwd.setSize(200, 30);

		tfMsg = new JTextField(10);
		tfMsg.setLocation(170, 530);
		tfMsg.setSize(250, 30);

		btnL = new JButton("Login");
		btnL.setLocation(420, 448);
		btnL.setSize(80, 110);
		
		btnI = new JButton("ID찾기");
		btnI.setLocation(170, 570);
		btnI.setSize(100, 40);
		
		btnP = new JButton("PWD찾기");
		btnP.setLocation(285, 570);
		btnP.setSize(100, 40);
		
		btnS = new JButton("SIGN IN");
		btnS.setLocation(400, 570);
		btnS.setSize(100, 40);
		
		
		
		btnL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(tfId.getText() + " : " + tfPwd.getText());
				String id = tfId.getText();
				
				list = dao.list(id);
				
				if(list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						InfoVo data = (InfoVo) list.get(i);
						String gid = data.getId();
						String gpwd = data.getPwd();

						System.out.println(gid + " :: " + gpwd);
						
						if(tfId.getText().equals(gid) && tfPwd.getText().equals(gpwd)) {
							tfMsg.setText("로그인이 성공했습니다.");		
						}else {
							tfMsg.setText("로그인이 실패했습니다.");
						}
					}
				}else {
					tfMsg.setText("로그인이 실패했습니다.");
				}
				
				for (int i = 0; i < list.size(); i++) {
					InfoVo data = (InfoVo) list.get(i);
					String gid = data.getId();
					String gpwd = data.getPwd();

					System.out.println(gid + " :: " + gpwd);
				}
			}
		});
		f.getContentPane().add(tab1Panel);

		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.addWindowListener(this);
		f.add(lId);
		f.add(tfId);
		f.add(lPwd);
		f.add(tfPwd);
		f.add(tfMsg);
		f.add(btnL);
		f.add(btnI);
		f.add(btnP);
		f.add(btnS);
//		f.add(lb1);

		f.setVisible(true);
	}
	
//	public void paint(Graphics g) {//그리는 함수
//		g.drawImage(background, 0, 0, null);//background를 그려줌
//	}
	
	public static void main(String[] args) {
		new LoginFrame();
		
	}
}