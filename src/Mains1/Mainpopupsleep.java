package Mains1;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Mainpopupsleep {

	public void excute() {
		JFrame f = new JFrame("수면시간");
		f.setSize(650, 700);
		f.setLayout(null);

		// 화면중앙배치
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);

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
		JLabel sleepMainLabel = new JLabel("오늘의 수면시간 계산");
		JLabel sleepMainLabel2 = new JLabel("시간을 24시간제로 입력하면");
		JLabel sleepMainLabel3 = new JLabel("오늘의 수면시간을 계산합니다.");
		JLabel sleepMainLabel4 = new JLabel("※예시: 오후 10시 -> 22시");
		
		JLabel sleeptimeLabel1 = new JLabel("취침시간");
		JLabel sleeptimeLabel2 = new JLabel("시");
		JLabel sleeptimeLabel3 = new JLabel("분");
		
		JLabel getuptimeLabel1 = new JLabel("기상시간");
		JLabel getuptimeLabel2 = new JLabel("시");
		JLabel getuptimeLabel3 = new JLabel("분");
		
		JLabel sleeplastLabel1 = new JLabel("오늘 당신의 수면시간은");
		JLabel sleeplastLabel2 = new JLabel("입니다.");
		
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
		JTextField todaysleepText = new JTextField(2);
		JTextField todaysleepText2 = new JTextField(2);
		
		JTextField todaygetupText = new JTextField(2);
		JTextField todaygetupText2 = new JTextField(2);
		
		JTextField todaysleeplastText = new JTextField(20);
		
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

		todayexercisebutton.setSize(90, 40);
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