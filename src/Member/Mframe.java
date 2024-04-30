package Member;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mframe {
	private JFrame f;
	private JTextField tfName, tfId, tfPwd, tfPwda, tfNickname, tfPhoneN, tfEmail;
	private JButton btIdCheck, btNickCheck, btn, btlogo;
	private MemberDAO dao;
	private JLabel lName, lId, lPwd, lPwda, lNickn, lPhone, lEmail;
	Font font = new Font("SansSerif", Font.PLAIN, 15);
	ImageIcon img = new ImageIcon("./image/logo.jpg");

	public Mframe() {
		dao = new MemberDAO();

		f = new JFrame("회원가입");
		f.setSize(800, 800);
		f.setLayout(null);

		btlogo = new JButton(img);
		// 로고 이미지 크기 및 위치
		btlogo.setSize(213, 114);
		btlogo.setLocation(10, 10);
		btlogo.addActionListener(new ActionListener() {
			// 로그인 창으로 이동하게 해야함
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});

		btIdCheck = new JButton("중복 확인");
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

		btNickCheck = new JButton("중복 확인");
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

		btn = new JButton("회원 가입");
		btn.setBounds(400, 580, 100, 30);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String id = tfId.getText();
				String password = tfPwd.getText();
				String passwordConfirm = tfPwda.getText();
				String nickname = tfNickname.getText();
				String phone = tfPhoneN.getText();
				String email = tfEmail.getText();

				// 입력 필드가 비어 있는지 확인
				if (name.isEmpty() || id.isEmpty() || password.isEmpty() || passwordConfirm.isEmpty()
						|| nickname.isEmpty() || phone.isEmpty() || email.isEmpty()) {
					// 하나 이상의 필드가 비어 있으면 회원 가입 차단 및 메시지 표시
					new MessageDialog(f, "알림", "빈칸 없이 채워주세요.");
				} else {
					int result = dao.insert(id, nickname);

					if (result > 0) {
						// 회원 가입 성공
						new MessageDialog(f, "알림", "회원 가입 성공");
					} else {
						// 회원 가입 실패
						new MessageDialog(f, "알림", "회원 가입 실패!");
					}
				}
			}

		});

		tfName = new JTextField(30);
		tfName.setBounds(310, 150, 180, 30);
		tfId = new JTextField(30);
		tfId.setBounds(310, 200, 180, 30);
		tfPwd = new JTextField(30);
		tfPwd.setBounds(310, 250, 180, 30);
		tfPwda = new JTextField(30);
		tfPwda.setBounds(310, 300, 180, 30);
		tfNickname = new JTextField(30);
		tfNickname.setBounds(310, 350, 180, 30);
		tfPhoneN = new JTextField(30);
		tfPhoneN.setBounds(310, 400, 180, 30);
		tfEmail = new JTextField(30);
		tfEmail.setBounds(310, 450, 180, 30);

		lName = new JLabel("이름");
		lName.setBounds(180, 150, 30, 30);
		lId = new JLabel("아이디");
		lId.setBounds(180, 200, 100, 30);
		lPwd = new JLabel("비밀번호");
		lPwd.setBounds(180, 250, 100, 30);
		lPwda = new JLabel("비밀번호 확인");
		lPwda.setBounds(180, 300, 100, 30);
		lNickn = new JLabel("닉네임");
		lNickn.setBounds(180, 350, 100, 30);
		lPhone = new JLabel("핸드폰 번호");
		lPhone.setBounds(180, 400, 100, 30);
		lEmail = new JLabel("Email");
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
		f.add(btlogo);

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
		we.getWindow().dispose();				//현재창만닫기
//		System.exit(0);
	}
}
