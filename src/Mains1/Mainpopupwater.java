package Mains1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mainpopupwater {

	public void excute() {
		JFrame f = new JFrame("메인페이지 팝업");
		f.setSize(600, 350);
		f.setLayout(null);

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 600 / 2, screenSize.height / 2 - 350 / 2);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 25);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 15);
		// 로고 객체 생성
		JLabel logo;
		// 로고 이미지 생성
		logo = new JLabel(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\logoMap.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(70, 70);
		logo.setLocation(25, 35);
		// 라벨
		JLabel waterMainJLabel = new JLabel("오늘의 수분섭취 계산");
		JLabel mywaterJLabel = new JLabel("저는 오늘");
		JLabel mywaterJLabel2 = new JLabel("L를 섭취했습니다.");
		JLabel mywaterJLabel3 = new JLabel("※참고: 종이컵 1컵이 180ml=0.18L 입니다.");
		
		waterMainJLabel.setSize(280, 70);
		waterMainJLabel.setLocation(180, 100);
		waterMainJLabel.setFont(font1);
		
		mywaterJLabel.setSize(100, 70);
		mywaterJLabel.setLocation(130, 160);
		mywaterJLabel.setFont(font2);
		
		mywaterJLabel2.setSize(190, 70);
		mywaterJLabel2.setLocation(315, 160);
		mywaterJLabel2.setFont(font2);
		
		mywaterJLabel3.setSize(300, 60);
		mywaterJLabel3.setLocation(155, 220);
		mywaterJLabel3.setFont(font3);
		
		// 텍스트 필드
		JTextField mywatertext = new JTextField(7);
		
		mywatertext.setSize(80, 25);
		mywatertext.setLocation(230, 180);
		mywatertext.setFont(font2);
		
		// 입력 버튼
		JButton todaywatersscJButton = new JButton("완료");
		
		todaywatersscJButton.setSize(70, 30);
		todaywatersscJButton.setLocation(270, 280);
		todaywatersscJButton.setFont(font3);
		todaywatersscJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 f.dispose();
			}
		});

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				f.dispose();
			}
		});

		f.add(logo);
		f.add(waterMainJLabel);
		f.add(mywaterJLabel);
		f.add(mywaterJLabel2);
		f.add(mywaterJLabel3);
		f.add(mywatertext);
		f.add(todaywatersscJButton);

		f.setVisible(true);
	}
}