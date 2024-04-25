package Ranking;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Rank {

	public static void main(String[] args) {
		Frame f = new Frame("랭킹 페이지");
		f.setSize(800, 800);
		f.setLayout(null);
		// 글씨체
		Font font = new Font("맑은 고딕", Font.BOLD, 30);
		// 로고 객체 생성
		JButton logo;
		// 로고 이미지 생성
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(70, 60);
		logo.setLocation(120, 40);
		// 중앙 배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
		// 버튼 생성
		Button gp = new Button("게임사진");
		Button mp = new Button("메인페이지");
		Button myp = new Button("마이페이지");

		gp.setSize(200, 150);
		gp.setLocation(500, 150);
		mp.setSize(200, 150);
		mp.setLocation(500, 320);
		myp.setSize(200, 150);
		myp.setLocation(500, 490);

		// 텍스트 필드 생성
		TextField T11 = new TextField(10);
		TextField T12 = new TextField(10);
		TextField T13 = new TextField(10);
		TextField T14 = new TextField(10);
		TextField T15 = new TextField(10);
		TextField T16 = new TextField(10);
		TextField T17 = new TextField(10);
		TextField T18 = new TextField(10);
		TextField T19 = new TextField(10);
		TextField T20 = new TextField(10);

		T11.setSize(200, 30);
		T11.setLocation(200, 160);
		T12.setSize(200, 30);
		T12.setLocation(200, 210);
		T13.setSize(200, 30);
		T13.setLocation(200, 260);
		T14.setSize(200, 30);
		T14.setLocation(200, 310);
		T15.setSize(200, 30);
		T15.setLocation(200, 360);
		T16.setSize(200, 30);
		T16.setLocation(200, 410);
		T17.setSize(200, 30);
		T17.setLocation(200, 460);
		T18.setSize(200, 30);
		T18.setLocation(200, 510);
		T19.setSize(200, 30);
		T19.setLocation(200, 560);
		T20.setSize(200, 30);
		T20.setLocation(200, 610);

		// 라벨 생성

		Label l12 = new Label("랭킹 페이지");
		l12.setFont(font);

		Label l13 = new Label("1.");
		Label l14 = new Label("2.");
		Label l15 = new Label("3.");
		Label l16 = new Label("4.");
		Label l17 = new Label("5.");
		Label l18 = new Label("6.");
		Label l19 = new Label("7.");
		Label l20 = new Label("8.");
		Label l21 = new Label("9.");
		Label l22 = new Label("10.");

		l12.setSize(200, 60);
		l12.setLocation(200, 50);
		l13.setSize(100, 30);
		l13.setLocation(170, 160);
		l14.setSize(100, 30);
		l14.setLocation(170, 210);
		l15.setSize(100, 30);
		l15.setLocation(170, 260);
		l16.setSize(100, 30);
		l16.setLocation(170, 310);
		l17.setSize(100, 30);
		l17.setLocation(170, 360);
		l18.setSize(100, 30);
		l18.setLocation(170, 410);
		l19.setSize(100, 30);
		l19.setLocation(170, 460);
		l20.setSize(100, 30);
		l20.setLocation(170, 510);
		l21.setSize(100, 30);
		l21.setLocation(170, 560);
		l22.setSize(100, 30);
		l22.setLocation(165, 610);

		// 초이스 생성
		Choice day = new Choice();

		day.add("정렬방법선택");
		day.add("오름차순");
		day.add("내림차순");
		day.add("ID별정렬");

		day.setSize(100, 30);
		day.setLocation(500, 60);

		f.add(gp);
		f.add(mp);
		f.add(myp);
		f.add(T11);
		f.add(T12);
		f.add(T13);
		f.add(T14);
		f.add(T15);
		f.add(T16);
		f.add(T17);
		f.add(T18);
		f.add(T19);
		f.add(T20);
		f.add(l12);
		f.add(l13);
		f.add(l14);
		f.add(l15);
		f.add(l16);
		f.add(l17);
		f.add(l18);
		f.add(l19);
		f.add(l20);
		f.add(l21);
		f.add(l22);
		f.add(day);
		f.add(logo);

		f.setVisible(true);

	}

}