package Mains1;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mainpopupsleep {

	public void excute() {
		JFrame f = new JFrame("수면시간");
		f.setSize(650, 700);
		f.setLayout(null);

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 650 / 2, screenSize.height / 2 - 700 / 2);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 18);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 25);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 16);
		// 로고 객체 생성
		JLabel logo;
		// 로고 이미지 생성
		logo = new JLabel(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\logoMap.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(80, 80);
		logo.setLocation(50, 60);
		
		//라벨 생성
		Label sleepMainLabel = new Label("오늘의 수면시간 계산");
		Label sleepMainLabel2 = new Label("시간을 24시간제로 입력하면");
		Label sleepMainLabel3 = new Label("오늘의 수면시간을 계산합니다.");
		Label sleepMainLabel4 = new Label("※예시: 오후 10시 -> 22시");
		
		Label sleeptimeLabel1 = new Label("취침시간");
		Label sleeptimeLabel2 = new Label("시");
		Label sleeptimeLabel3 = new Label("분");
		
		Label getuptimeLabel1 = new Label("기상시간");
		Label getuptimeLabel2 = new Label("시");
		Label getuptimeLabel3 = new Label("분");
		
		Label sleeplastLabel1 = new Label("오늘 당신의 수면시간은");
		Label sleeplastLabel2 = new Label("입니다.");
		
		sleepMainLabel.setSize(280, 60);
		sleepMainLabel.setLocation(190, 130);
		sleepMainLabel.setFont(font2);
		
		sleepMainLabel2.setSize(500, 60);
		sleepMainLabel2.setLocation(195, 190);
		sleepMainLabel2.setFont(font1);
		
		sleepMainLabel3.setSize(500, 60);
		sleepMainLabel3.setLocation(190, 230);
		sleepMainLabel3.setFont(font1);
		
		sleepMainLabel4.setSize(300, 60);
		sleepMainLabel4.setLocation(215, 270);
		sleepMainLabel4.setFont(font3);
		
		//취침라벨
		
		sleeptimeLabel1.setSize(100, 60);
		sleeptimeLabel1.setLocation(170, 335);
		sleeptimeLabel1.setFont(font1);
		
		sleeptimeLabel2.setSize(50, 60);
		sleeptimeLabel2.setLocation(330, 335);
		sleeptimeLabel2.setFont(font1);
		
		sleeptimeLabel3.setSize(50, 60);
		sleeptimeLabel3.setLocation(440, 335);
		sleeptimeLabel3.setFont(font1);
		
		//기상라벨
		
		getuptimeLabel1.setSize(100, 60);
		getuptimeLabel1.setLocation(170, 380);
		getuptimeLabel1.setFont(font1);
		
		getuptimeLabel2.setSize(50, 60);
		getuptimeLabel2.setLocation(330, 380);
		getuptimeLabel2.setFont(font1);
		
		getuptimeLabel3.setSize(50, 60);
		getuptimeLabel3.setLocation(440, 380);
		getuptimeLabel3.setFont(font1);
		
		//계산라벨
		
		sleeplastLabel1.setSize(210, 60);
		sleeplastLabel1.setLocation(140, 450);
		sleeplastLabel1.setFont(font1);
		
		sleeplastLabel2.setSize(200, 60);
		sleeplastLabel2.setLocation(450, 450);
		sleeplastLabel2.setFont(font1);
		
		//텍스트 필드
		TextField todaysleepText = new TextField(2);
		TextField todaysleepText2 = new TextField(2);
		
		TextField todaygetupText = new TextField(2);
		TextField todaygetupText2 = new TextField(2);
		
		TextField todaysleeplastText = new TextField(20);
		
		//취침
		todaysleepText.setSize(50, 25);
		todaysleepText.setLocation(270, 355);
		todaysleepText.setFont(font1);
		
		todaysleepText2.setSize(50, 25);
		todaysleepText2.setLocation(380, 355);
		todaysleepText2.setFont(font1);
		//기상
		todaygetupText.setSize(50, 25);
		todaygetupText.setLocation(270, 400);
		todaygetupText.setFont(font1);
		
		todaygetupText2.setSize(50, 25);
		todaygetupText2.setLocation(380, 400);
		todaygetupText2.setFont(font1);
		//계산 필드
		todaysleeplastText.setSize(85, 25);
		todaysleeplastText.setLocation(350, 465);
		todaysleeplastText.setFont(font1);
		
		//단추
		JButton todayexercisebutton = new JButton("완료");

		todayexercisebutton.setSize(80, 40);
		todayexercisebutton.setLocation(285, 540);
		todayexercisebutton.setFont(font2);
		todayexercisebutton.addActionListener(new ActionListener() {
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
		f.add(sleepMainLabel);
		f.add(sleepMainLabel2);
		f.add(sleepMainLabel3);
		f.add(sleepMainLabel4);
		f.add(sleeplastLabel1);
		f.add(sleeplastLabel2);
		
		f.add(sleeptimeLabel1);
		f.add(sleeptimeLabel2);
		f.add(sleeptimeLabel3);
		f.add(getuptimeLabel1);
		f.add(getuptimeLabel2);
		f.add(getuptimeLabel3);
		
		f.add(todaysleepText);
		f.add(todaysleepText2);
		f.add(todaygetupText);
		f.add(todaygetupText2);
		f.add(todaysleeplastText);
		
		f.add(todayexercisebutton);
		
		f.setVisible(true);
	}
}