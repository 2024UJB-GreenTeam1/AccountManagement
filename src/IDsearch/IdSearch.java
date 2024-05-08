package IDsearch;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class IdSearch extends JFrame {

	private JFrame f;
	private JTextField tfName;
	private JTextField tfEmail;
	private JTextField tfNotice;
	private JPasswordField tfpwd;
	private JButton btn;

//	private JPanel tab1Panel;

	ArrayList<IdVo> list;
	private IdDAO dao;

	public IdSearch() {

		f = new JFrame("ID");
		f.setSize(400, 400);
		f.getContentPane().setLayout(null);

		dao = new IdDAO();

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
		tfpwd.setLocation(110, 200);
		tfpwd.setSize(250, 30);

		tfNotice = new JTextField(20); // 알림메시지
		tfNotice.setLocation(70, 300);
		tfNotice.setSize(280, 30);

		btn = new JButton("찾기");
		// 로고 이미지 크기 및 위치
		btn.setSize(70, 30);
		btn.setLocation(170, 250);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String pwd = new String(tfpwd.getPassword());// SWING에서 .getPassword()는 char[]이기때문에 String변환

				System.out.println(tfName.getText() + " : " + tfEmail.getText() + " : " + pwd);
				String name = tfName.getText(); // TextField에서 getText
				String email = tfEmail.getText();

				list = dao.list(name); //  DAO list에 NAME넣어주기? ->NAME이 겹치는 유저가 있다면??


				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						IdVo data = (IdVo) list.get(i);

						String gid = data.getId();
						String gpwd = data.getPwd();
						String gname = data.getName();
						String gemail = data.getEmail();

						System.out.println(gid + " :: " + gpwd); // 콘솔프린트

						if (name.equals(gname) && pwd.equals(gpwd) && email.equals(gemail)) {
							tfNotice.setText(" 당신의 ID는  :  " + gid + "  입니다."); // 아이디 텍스트필드에 표시

						} else {

							tfNotice.setText("이름, 이메일, 비밀번호를 다시확인하여 주세요.");
						}
					}
				} else {
					tfNotice.setText("이름, 이메일, 비밀번호를 다시확인하여 주세요.");
				}

//				for (int i = 0; i < list.size(); i++) {					//이거 필요함?
//					IdVo data = (IdVo) list.get(i);
//					String gid = data.getId();
//					String gpwd = data.getPwd();
//
//					System.out.println(gid + " :: " + gpwd);
//				}
			}
		});

		f.add(lId);
		f.add(lEmail);
		f.add(lPwd);
		f.add(tfName);
		f.add(tfEmail);
		f.add(tfpwd);
		f.add(tfNotice);
		f.add(btn);
		f.setVisible(true);

	}

	public void excuteID() {
		new IdSearch();
	}

	public static void main(String[] args) {
		new IdSearch();

	}
}
