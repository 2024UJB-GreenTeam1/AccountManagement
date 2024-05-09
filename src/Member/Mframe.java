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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import login.LoginFrame;

public class Mframe {
	private JFrame f;
	private JTextField tfheight, tfName, tfId, tfPhoneN, tfEmail,tfYear;
	private JPasswordField tfPwd, tfPwda;
	private JButton btIdCheck, btn, btlogo;
	private MemberDAO dao;

	private JLabel lheight, lYear, lName, lId, lPwd, lPwda, lPhone, lEmail;
	Font font = new Font("SansSerif", Font.PLAIN, 15);
	

	public Mframe() {
		dao = new MemberDAO();

		f = new JFrame("회원가입");
		f.setSize(800, 800);
		f.setLayout(null);

		btlogo = new JButton();
		btlogo.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));
		// 로고 이미지 크기 및 위치
		btlogo.setSize(181, 163);
		btlogo.setLocation(10, 10);
		btlogo.addActionListener(new ActionListener() {
			// 로그인 창으로 이동하게 해야함
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
              new LoginFrame();
              f.dispose();
			}

		});

		btIdCheck = new JButton("중복 확인");
		btIdCheck.setBounds(500, 250, 100, 30);
		btIdCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userIdToCheck = tfId.getText();
				if (!isValidId(userIdToCheck)) {
		            new MessageDialog(f, "알림", "영어 소문자와 숫자로만 입력.");
		        } else {
		            boolean isDuplicate = dao.isIdDuplicate(userIdToCheck);
		            if (isDuplicate) {
		                new MessageDialog(f, "알림", "아이디가 이미 존재합니다.");
		            } else {
		                new MessageDialog(f, "알림", "사용 가능한 아이디입니다.");
		            }
		        }
		    }
		});

		btn = new JButton("회원 가입");
		btn.setBounds(380, 620, 100, 30);
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tfName.getText();
				String id = tfId.getText();
				String password = tfPwd.getText();
				String confirmPassword = tfPwda.getText();
				String heightStr = tfheight.getText();
				String phone = tfPhoneN.getText();
				String email = tfEmail.getText();
				String year = tfYear.getText();

				if (name.isEmpty() || id.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
						|| heightStr.isEmpty() || phone.isEmpty() || email.isEmpty() || year.isEmpty()) {
					new MessageDialog(f, "알림", "빈칸 없이 채워주세요.");
				} else if (!password.equals(confirmPassword)) {
					new MessageDialog(f, "알림", "비밀번호가 일치하지 않습니다.");
				} else if (!isValidName(name)) {
					new MessageDialog(f, "알림", "이름은 한글만 입력해주세요.");
				}  else if (!isValidPassword(password)) {
					new MessageDialog(f, "알림", "비밀번호는 특수문자를 포함하지 않습니다.");
				} else {
					try {
						int height = Integer.parseInt(heightStr); // height 문자열을 정수로 변환
						int result = dao.insert(name, id, password, phone, email, height, year);
						if (result > 0) {
							new MessageDialog(f, "알림", "회원 가입 성공");
							new LoginFrame();
							f.dispose();
						} else {
							new MessageDialog(f, "알림", "회원 가입 실패!");
						}
					} catch (NumberFormatException ex) {
						new MessageDialog(f, "알림", "키는 숫자로 입력해주세요."); // 키가 숫자가 아닌 경우 처리
					}
				}
			}
		});

		tfName = new JTextField(30);
		tfName.setBounds(310, 200, 180, 30);
		tfId = new JTextField(30);
		tfId.setBounds(310, 250, 180, 30);
		tfPwd = new JPasswordField(30);
		tfPwd.setBounds(310, 300, 180, 30);
		tfPwd.setEchoChar('*');
		tfPwda = new JPasswordField(30);
		tfPwda.setBounds(310, 350, 180, 30);
		tfPwda.setEchoChar('*');
		tfYear = new JTextField(30);
		tfYear.setBounds(310, 400, 180, 30);
		tfPhoneN = new JTextField(30);
		tfPhoneN.setBounds(310, 450, 180, 30);
		tfEmail = new JTextField(30);
		tfEmail.setBounds(310, 500, 180, 30);
		tfheight = new JTextField(30);
		tfheight.setBounds(310, 550, 180, 30);

		lName = new JLabel("이름");
		lName.setBounds(180, 200, 30, 30);
		lId = new JLabel("아이디");
		lId.setBounds(180, 250, 100, 30);
		lPwd = new JLabel("비밀번호");
		lPwd.setBounds(180, 300, 100, 30);
		lPwda = new JLabel("비밀번호 확인");
		lPwda.setBounds(180, 350, 100, 30);
		lYear = new JLabel("생년월일");
		lYear.setBounds(180, 400, 100, 30);
		lPhone = new JLabel("핸드폰 번호");
		lPhone.setBounds(180, 450, 100, 30);
		lEmail = new JLabel("Email");
		lEmail.setBounds(180, 500, 100, 30);
		lheight = new JLabel("키");
		lheight.setBounds(180, 550, 100, 30);

		f.add(lName);
		f.add(lId);
		f.add(lPwd);
		f.add(lPwda);
		f.add(lPhone);
		f.add(lEmail);
		f.add(lheight);
		f.add(lYear);

		f.add(tfName);
		f.add(tfId);
		f.add(tfPwd);
		f.add(tfPwda);
		f.add(tfPhoneN);
		f.add(tfEmail);
		f.add(tfheight);
		f.add(tfYear);

		f.add(btIdCheck);

		f.add(btn);
		f.add(btlogo);

		f.setFont(font);
		f.addWindowListener(new EventHandler());
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new Mframe();
	}

	// 이름이 한글인지 검증
	public boolean isValidName(String name) {
		return name.matches("[가-힣]+");
	}

	// 아이디가 영어 소문자와 숫자로만 이루어져 있는지 검증
	public boolean isValidId(String id) {
		return id.matches("[a-z0-9]+");
	}

	// 비밀번호에 특수문자가 포함되어 있는지 검증
	public boolean isValidPassword(String password) {
		return !password.matches(".*[!@#$%^&*()-_=+\\|[{]};:'\",<.>/?].*");
	}
}

class EventHandler extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent we) {
		we.getWindow().setVisible(false);
		we.getWindow().dispose(); // 현재창만닫기
//		System.exit(0);
	}
}