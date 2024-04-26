package Member;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mframe {
	private Frame f;
	private TextField tfName, tfId, tfPwd, tfPwda, tfNickname, tfPhoneN, tfEmail;
	private Button btIdCheck, btNickCheck, btn, btback;
	private MemberDAO dao;
	private Label lName, lId, lPwd, lPwda, lNickn, lPhone, lEmail;
	Font font = new Font("SansSerif", Font.PLAIN, 15);

	public Mframe() {
		dao = new MemberDAO();

		f = new Frame("회원가입");
		f.setSize(800, 800);
		f.setLayout(null);

		btIdCheck = new Button("중복 확인");
		btIdCheck.setBounds(500, 200, 100, 30);
		btIdCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userIdToCheck = tfId.getText();
				boolean isDuplicate = dao.isIdDuplicate(userIdToCheck);
				if (isDuplicate) {
					new MessageDialog(f, "알림", "아이디가 이미 존재합니다.");
				} else {
					new MessageDialog(f, "알림", "사용 가능한 아이디입니다.");
				}
			}
		});

		btNickCheck = new Button("중복 확인");
		btNickCheck.setBounds(500, 350, 100, 30);
		btNickCheck.addActionListener(new ActionListener() {
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

		btn = new Button("회원 가입");
		btn.setBounds(400, 580, 100, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfId.getText();
				String nickname = tfNickname.getText();
				int result = dao.insert(id, nickname);
				if (result > 0) {
					// 회원 가입 성공
					new MessageDialog(f, "알림", "회원 가입 성공");
				} else {
					// 회원 가입 실패
					new MessageDialog(f, "알림", "회원 가입 실패!");
				}
			}

		});

		tfName = new TextField(30);
		tfName.setBounds(310, 150, 180, 30);
		tfId = new TextField(30);
		tfId.setBounds(310, 200, 180, 30);
		tfPwd = new TextField(30);
		tfPwd.setBounds(310, 250, 180, 30);
		tfPwda = new TextField(30);
		tfPwda.setBounds(310, 300, 180, 30);
		tfNickname = new TextField(30);
		tfNickname.setBounds(310, 350, 180, 30);
		tfPhoneN = new TextField(30);
		tfPhoneN.setBounds(310, 400, 180, 30);
		tfEmail = new TextField(30);
		tfEmail.setBounds(310, 450, 180, 30);

		lName = new Label("이름");
		lName.setBounds(180, 150, 30, 30);
		lId = new Label("아이디");
		lId.setBounds(180, 200, 100, 30);
		lPwd = new Label("비밀번호");
		lPwd.setBounds(180, 250, 100, 30);
		lPwda = new Label("비밀번호 확인");
		lPwda.setBounds(180, 300, 100, 30);
		lNickn = new Label("닉네임");
		lNickn.setBounds(180, 350, 100, 30);
		lPhone = new Label("핸드폰 번호");
		lPhone.setBounds(180, 400, 100, 30);
		lEmail = new Label("Email");
		lEmail.setBounds(180, 450, 100, 30);

		f.add(lName);
		f.add(lId);
		f.add(lPwd);
		f.add(lPwda);
		f.add(lNickn);
		f.add(lPhone);
		f.add(lEmail);
		f.add(tfName);
		f.add(tfId);
		f.add(tfNickname);
		f.add(tfPwd);
		f.add(tfPwda);
		f.add(tfPhoneN);
		f.add(tfEmail);

		f.add(btIdCheck);
		f.add(btNickCheck);
		f.add(btn);

		f.setFont(font);
		f.addWindowListener(new EventHandler());
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Mframe();
	}
}

class EventHandler extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent we) {
		we.getWindow().setVisible(false);
		we.getWindow().dispose();
		System.exit(0);
	}
}
