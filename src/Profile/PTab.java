package Profile;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Member.MessageDialog;

public class PTab extends JPanel {
	private DTO user;
	public PTab(String tabName, DTO user) {
		this.user = user;
		setLayout(new BorderLayout());

		if (tabName.equals("내 프로필")) {
			add(createProfilePanel(), BorderLayout.CENTER);
		} else if (tabName.equals("E-MAIL 변경")) {
			add(emailChangePanel(), BorderLayout.CENTER);
		} else if (tabName.equals("비밀번호 변경")) {
			add(createPasswordChangePanel(), BorderLayout.CENTER);
		}

	}

	ProfileDAO dao = new ProfileDAO();

	private JPanel createProfilePanel() {

		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout());
		// 프로필 정보 패널 구성
		JLabel name = new JLabel("이름");
		name.setBounds(100, 80, 100, 30);
		profilePanel.add(name);
		JLabel dname = new JLabel(user.getName());
		dname.setBounds(200, 80, 100, 30);
		profilePanel.add(dname);
		// 정보 가져오기

		JLabel id = new JLabel("ID");
		id.setBounds(100, 130, 100, 30);
		profilePanel.add(id);
		JLabel did = new JLabel(user.getID());
		did.setBounds(200, 130, 100, 30);
		profilePanel.add(did);

		JLabel mail = new JLabel("E-mail");
		mail.setBounds(100, 180, 100, 30);
		profilePanel.add(mail);
		JLabel dmail = new JLabel(user.getEmail());
		dmail.setBounds(200, 180, 130, 30);
		profilePanel.add(dmail);

		JLabel phone = new JLabel("핸드폰번호");
		phone.setBounds(100, 230, 100, 30);
		profilePanel.add(phone);
		JLabel dphone = new JLabel(user.getPhone());
		dphone.setBounds(200, 230, 100, 30);
		profilePanel.add(dphone);

		JLabel year = new JLabel("생년월일");
		year.setBounds(100, 280, 100, 30);
		profilePanel.add(year);
		JLabel dyear = new JLabel(user.getYear());
		dyear.setBounds(200, 280, 100, 30);
		profilePanel.add(dyear);

		JLabel height = new JLabel("키");
		height.setBounds(100, 330, 100, 30);
		profilePanel.add(height);
		JLabel dheight = new JLabel(String.valueOf(user.getHeight()));
		dheight.setBounds(200, 330, 100, 30);
		profilePanel.add(dheight);

		JLabel weight = new JLabel("몸무게");
		weight.setBounds(100, 380, 100, 30);
		profilePanel.add(weight);
		JLabel dweight = new JLabel("String.valueOf(user.getWeight())");
		dweight.setBounds(200, 380, 100, 30);
		profilePanel.add(dweight);

		JButton wh = new JButton("키 몸무게 수정");
		wh.setBounds(400, 380, 120, 30);
		profilePanel.add(wh);
		wh.addActionListener(new ActionListener() {
			// 키 몸무게 수정창 띄우기
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Ptab1hw frame = new Ptab1hw();
				frame.setVisible(true);
			}
		});

		// 줄간격이 안맞아서 넣음
		JLabel e = new JLabel(" ");
		e.setBounds(100, 300, 100, 30);
		profilePanel.add(e);
		JLabel de = new JLabel(" ");
		de.setBounds(200, 300, 100, 30);
		profilePanel.add(de);

		return profilePanel;
	}

	private JPanel emailChangePanel() {
		JPanel emailChangePanel = new JPanel();
		emailChangePanel.setLayout(null);
		// 아이디 변경 패널 구성
		JLabel newIdLabel = new JLabel("NEW E-MAIL:");
		newIdLabel.setBounds(50, 50, 100, 30);
		emailChangePanel.add(newIdLabel);
		JTextField newIdField = new JTextField();
		newIdField.setBounds(160, 50, 200, 30);
		emailChangePanel.add(newIdField);
		JButton ICP = new JButton("확인");
		ICP.setBounds(400, 50, 70, 30);
		emailChangePanel.add(ICP);
		ICP.addActionListener(new ActionListener() {
			// 새로운 이메일 저장
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userId = user.getID();
				String email = newIdField.getText();
				dao.updatemail(email, userId);
			}
		});

		return emailChangePanel;
	}

	
	
	
	
	
	private JPanel createPasswordChangePanel() {
		JPanel passwordChangePanel = new JPanel();
		passwordChangePanel.setLayout(null);
		// 비밀번호 변경 패널 구성
		JLabel newPasswordLabel = new JLabel("새 비밀번호:");
		newPasswordLabel.setBounds(50, 50, 120, 30);
		passwordChangePanel.add(newPasswordLabel);
		JTextField newPasswordField = new JTextField();
		newPasswordField.setBounds(180, 50, 200, 30);
		passwordChangePanel.add(newPasswordField);

		JLabel newPwd2 = new JLabel("비밀번호 확인:");
		newPwd2.setBounds(50, 100, 120, 30);
		passwordChangePanel.add(newPwd2);
		JTextField tfnewPwd = new JTextField();
		tfnewPwd.setBounds(180, 100, 200, 30);
		passwordChangePanel.add(tfnewPwd);

		JButton pwd = new JButton("확인");
		pwd.setBounds(400, 100, 70, 30);
		passwordChangePanel.add(pwd);
		pwd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String password = newPasswordField.getText();
				String confirmPassword = tfnewPwd.getText();
				if (password.isEmpty() || confirmPassword.isEmpty()) {
					new MessageDialog(null, "알림", "빈칸 없이 채워주세요.");
				} else if (!password.equals(confirmPassword)) {
					new MessageDialog(null, "알림", "비밀번호가 일치하지 않습니다.");
				} else {
					// 비밀번호 업데이트
//					int res = dao.updatepwd(password, confirmPassword);
					new MessageDialog(null, "알림", "비밀번호 변경 완료");
				}
			}
		});

		return passwordChangePanel;
	}
}
