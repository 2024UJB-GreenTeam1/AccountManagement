package Mains2;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mainpopupwater {

	public static void main(String[] args) {
		Frame f = new Frame("메인페이지 팝업");
		f.setSize(600, 400);
		f.setLayout(null);

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 600 / 2, screenSize.height / 2 - 400 / 2);

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
		Label waterMainLabel = new Label("오늘의 수분섭취 계산");
		Label mywaterLabel = new Label("저는 오늘");
		Label mywaterLabel2 = new Label("L를 섭취했습니다.");
		Label mywaterLabel3 = new Label("※참고: 종이컵 1컵이 180ml=0.18L 입니다.");

		waterMainLabel.setSize(280, 70);
		waterMainLabel.setLocation(180, 100);
		waterMainLabel.setFont(font1);

		mywaterLabel.setSize(100, 70);
		mywaterLabel.setLocation(130, 160);
		mywaterLabel.setFont(font2);

		mywaterLabel2.setSize(190, 70);
		mywaterLabel2.setLocation(315, 160);
		mywaterLabel2.setFont(font2);

		mywaterLabel3.setSize(300, 60);
		mywaterLabel3.setLocation(155, 210);
		mywaterLabel3.setFont(font3);

		// 텍스트 필드
		TextField mywatertext = new TextField(7);

		mywatertext.setSize(80, 25);
		mywatertext.setLocation(230, 180);
		mywatertext.setFont(font2);

		TextField mywatertext2 = new TextField(7);

		mywatertext2.setSize(250, 25);
		mywatertext2.setLocation(180, 270);
		mywatertext2.setFont(font2);

		// 입력 버튼
		Button todaywatersscbutton = new Button("완료");

		todaywatersscbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double totalCalories = Double.parseDouble(mywatertext.getText());
					mywatertext2.setText(String.format("%.2fL 입력되었습니다.", totalCalories));
				} catch (NumberFormatException nfe) {
					mywatertext2.setText("유효한 숫자를 입력하세요.");
				}
			}
		});

		todaywatersscbutton.setSize(70, 30);
		todaywatersscbutton.setLocation(270, 320);
		todaywatersscbutton.setFont(font3);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		f.add(logo);
		f.add(waterMainLabel);
		f.add(mywaterLabel);
		f.add(mywaterLabel2);
		f.add(mywaterLabel3);
		f.add(mywatertext);
		f.add(mywatertext2);
		f.add(todaywatersscbutton);

		f.setVisible(true);
	}
}