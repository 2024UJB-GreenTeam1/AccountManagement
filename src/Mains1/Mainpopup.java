package Mains1;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mainpopup {
	// todayweightText 필드 생성
	 static TextField todayweightText = new TextField(7);
	// 프레임 생성
	public static void main(String[] args) {
		Frame f = new Frame("메인페이지 팝업");
		f.setSize(800, 800);
		f.setLayout(null);

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 40);
		// 로고 객체 생성
		JLabel logo;
		// 로고 이미지 생성
		logo = new JLabel(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\logoMap.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(80, 80);
		logo.setLocation(60, 60);

		// 라벨 생성
		Label todayLabel = new Label("Today");
		todayLabel.setFont(font2);
		
		Label referenceLabel = new Label("※입력된 값은 나의건강일지로 이동합니다.");
		referenceLabel.setFont(font1);

		Label todaydateLabel = new Label("오늘 날짜는");
		Label todaydateLabel2 = new Label("입니다.");
		todaydateLabel.setFont(font1);
		todaydateLabel2.setFont(font1);

		Label todayHealthLabel = new Label("오늘 나의");
		Label todayHealthLabel2 = new Label("칼로리는");
		Label todayHealthLabel3 = new Label("입니다.");
		todayHealthLabel.setFont(font1);
		todayHealthLabel2.setFont(font1);
		todayHealthLabel3.setFont(font1);

		Label todayfoodLabel = new Label("오늘 나의");
		Label todayfoodLabel2 = new Label("칼로리는");
		Label todayfoodLabel3 = new Label("입니다.");
		todayfoodLabel.setFont(font1);
		todayfoodLabel2.setFont(font1);
		todayfoodLabel3.setFont(font1);

		Label todaysleepLabel = new Label("오늘 나의");
		Label todaysleepLabel2 = new Label("입니다.");
		todaysleepLabel.setFont(font1);
		todaysleepLabel2.setFont(font1);

		Label todayweightLabel = new Label("오늘 나의");
		Label todayweightLabel2 = new Label("입니다.");
		todayweightLabel.setFont(font1);
		todayweightLabel2.setFont(font1);

		Label todaywaterLabel = new Label("오늘 나의");
		Label todaywaterLabel2 = new Label("입니다.");
		todaywaterLabel.setFont(font1);
		todaywaterLabel2.setFont(font1);

		todayLabel.setSize(250, 70);
		todayLabel.setLocation(350, 130);
		//참고라벨
		referenceLabel.setSize(500, 50);
		referenceLabel.setLocation(190, 530);

		todaydateLabel.setSize(130, 60);
		todaydateLabel.setLocation(160, 230);
		todaydateLabel2.setSize(100, 50);
		todaydateLabel2.setLocation(560, 230);

		todayHealthLabel.setSize(100, 50);
		todayHealthLabel.setLocation(160, 300);
		todayHealthLabel2.setSize(100, 50);
		todayHealthLabel2.setLocation(360, 300);
		todayHealthLabel3.setSize(100, 50);
		todayHealthLabel3.setLocation(560, 300);

		todayfoodLabel.setSize(100, 50);
		todayfoodLabel.setLocation(160, 340);
		todayfoodLabel2.setSize(100, 50);
		todayfoodLabel2.setLocation(360, 340);
		todayfoodLabel3.setSize(100, 50);
		todayfoodLabel3.setLocation(560, 340);

		todaysleepLabel.setSize(100, 50);
		todaysleepLabel.setLocation(160, 380);
		todaysleepLabel2.setSize(100, 50);
		todaysleepLabel2.setLocation(560, 380);

		todayweightLabel.setSize(100, 50);
		todayweightLabel.setLocation(160, 420);
		todayweightLabel2.setSize(100, 50);
		todayweightLabel2.setLocation(560, 420);

		todaywaterLabel.setSize(100, 50);
		todaywaterLabel.setLocation(160, 460);
		todaywaterLabel2.setSize(100, 50);
		todaywaterLabel2.setLocation(560, 460);

		// 버튼 생성
		Button todayexercisebutton = new Button("운동");
		Button todayfoodbutton = new Button("음식");
		Button todaysleepbutton = new Button("수면시간은");
		Button todayweightbutton = new Button("체중은");
		Button todaywaterbutton = new Button("수분섭취는");
		Button scc = new Button("완료");
		scc.setFont(font1);
		todayexercisebutton.setFont(font1);
		todayfoodbutton.setFont(font1);
		todaysleepbutton.setFont(font1);
		todayweightbutton.setFont(font1);
		todaywaterbutton.setFont(font1);

		scc.setSize(100, 60);
		scc.setLocation(360, 600);
		todayexercisebutton.setSize(70, 30);
		todayexercisebutton.setLocation(265, 310);
		todayfoodbutton.setSize(70, 30);
		todayfoodbutton.setLocation(265, 350);
		todaysleepbutton.setSize(170, 30);
		todaysleepbutton.setLocation(265, 390);
		todayweightbutton.setSize(170, 30);
		todayweightbutton.setLocation(265, 430);
		todaywaterbutton.setSize(170, 30);
		todaywaterbutton.setLocation(265, 470);

		// 텍스트 필드 생성
		TextField todaydateText = new TextField(15);
		todaydateText.setFont(font1);
		TextField todayHealthText = new TextField(10);
		todayHealthText.setFont(font1);
		TextField todayfoodText = new TextField(10);
		todayfoodText.setFont(font1);
		TextField todaysleepText = new TextField(10);
		todaysleepText.setFont(font1);
		TextField todayweightText = new TextField(10);
		todayweightText.setFont(font1);
		TextField todaywaterText = new TextField(10);
		todaywaterText.setFont(font1);

		todaydateText.setSize(250, 30);
		todaydateText.setLocation(290, 245);
		
		todayHealthText.setSize(80, 30);
		todayHealthText.setLocation(460, 310);
		todayfoodText.setSize(80, 30);
		todayfoodText.setLocation(460, 350);
		todaysleepText.setSize(80, 30);
		todaysleepText.setLocation(460, 390);
		todayweightText.setSize(80, 30);
		todayweightText.setLocation(460, 430);
		todaywaterText.setSize(80, 30);
		todaywaterText.setLocation(460, 470);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		f.add(logo);
		f.add(todayLabel);
		f.add(referenceLabel);
		f.add(todaydateLabel);
		f.add(todaydateLabel2);
		f.add(todayHealthLabel);
		f.add(todayHealthLabel2);
		f.add(todayHealthLabel3);
		f.add(todayfoodLabel);
		f.add(todayfoodLabel2);
		f.add(todayfoodLabel3);
		f.add(todaysleepLabel);
		f.add(todaysleepLabel2);
		f.add(todayweightLabel);
		f.add(todayweightLabel2);
		f.add(todaywaterLabel);
		f.add(todaywaterLabel2);
		f.add(todayexercisebutton);
		f.add(todayfoodbutton);
		f.add(todaysleepbutton);
		f.add(todayweightbutton);
		f.add(todaywaterbutton);
		f.add(scc);
		f.add(todaydateText);
		f.add(todayHealthText);
		f.add(todayfoodText);
		f.add(todaysleepText);
		f.add(todayweightText);
		f.add(todaywaterText);

		f.setVisible(true);
	}

	public static void updateWeightText(String weight) {
		todayweightText.setText(weight); // 텍스트 필드 업데이트

	}

}
