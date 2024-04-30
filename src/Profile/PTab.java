package Profile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PTab extends JPanel {
	public PTab(String tabName) {
		setLayout(new BorderLayout());

		if (tabName.equals("내 프로필")) {
			add(createProfilePanel(), BorderLayout.CENTER);
		} else if (tabName.equals("아이디 변경")) {
			add(createIdChangePanel(), BorderLayout.CENTER);
		} else if (tabName.equals("비밀번호 변경")) {
			add(createPasswordChangePanel(), BorderLayout.CENTER);
		}
	}

	private JPanel createProfilePanel() {
		JPanel profilePanel = new JPanel();
		profilePanel.setLayout(new BorderLayout());
		// 프로필 정보 패널 구성
		JLabel name = new JLabel("이름");
		name.setBounds(100, 10, 100, 30);
		profilePanel.add(name);
		JLabel dname = new JLabel("이민욱");
		dname.setBounds(200, 10, 100, 30);
		profilePanel.add(dname);
		// 정보 가져오기

		JLabel id = new JLabel("ID");
		id.setBounds(100, 60, 100, 30);
		profilePanel.add(id);
		JLabel did = new JLabel("green");
		did.setBounds(200, 60, 100, 30);
		profilePanel.add(did);

		JLabel mail = new JLabel("E-mail");
		mail.setBounds(100, 110, 100, 30);
		profilePanel.add(mail);
		JLabel dmail = new JLabel("green@naver.com");
		dmail.setBounds(200, 110, 130, 30);
		profilePanel.add(dmail);

		JLabel phone = new JLabel("핸드폰번호");
		phone.setBounds(100, 160, 100, 30);
		profilePanel.add(phone);
		JLabel dphone = new JLabel("010-0000-0000");
		dphone.setBounds(200, 160, 100, 30);
		profilePanel.add(dphone);

		JLabel year = new JLabel("생년월일");
		year.setBounds(100, 210, 100, 30);
		profilePanel.add(year);
		JLabel dyear = new JLabel("199.04.24");
		dyear.setBounds(200, 210, 100, 30);
		profilePanel.add(dyear);

		JLabel height = new JLabel("키");
		height.setBounds(100, 260, 100, 30);
		profilePanel.add(height);
		JLabel dheight = new JLabel("200");
		dheight.setBounds(200, 260, 100, 30);
		profilePanel.add(dheight);

		JLabel weight = new JLabel("몸무게");
		weight.setBounds(100, 310, 100, 30);
		profilePanel.add(weight);
		JLabel dweight = new JLabel("80");
		dweight.setBounds(200, 310, 100, 30);
		profilePanel.add(dweight);

		JButton wh = new JButton("키 몸무게 수정");
		wh.setBounds(400, 300, 120, 30);
		profilePanel.add(wh);
		wh.addActionListener(new ActionListener() {
			// 키 몸무게 수정창 띄우기
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

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

	private JPanel createIdChangePanel() {
		JPanel idChangePanel = new JPanel();
		idChangePanel.setLayout(null);
		// 아이디 변경 패널 구성
		JLabel newIdLabel = new JLabel("NEW E-MAIL:");
		newIdLabel.setBounds(50, 50, 100, 30);
		idChangePanel.add(newIdLabel);
		JTextField newIdField = new JTextField();
		newIdField.setBounds(160, 50, 200, 30);
		idChangePanel.add(newIdField);
		return idChangePanel;
	}

	private JPanel createPasswordChangePanel() {
		JPanel passwordChangePanel = new JPanel();
		passwordChangePanel.setLayout(null);
		// 비밀번호 변경 패널 구성
		JLabel newPasswordLabel = new JLabel("New Password:");
		newPasswordLabel.setBounds(50, 50, 120, 30);
		passwordChangePanel.add(newPasswordLabel);
		JTextField newPasswordField = new JTextField();
		newPasswordField.setBounds(180, 50, 200, 30);
		passwordChangePanel.add(newPasswordField);
		return passwordChangePanel;
	}
}
