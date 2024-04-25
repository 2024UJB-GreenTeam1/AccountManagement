package Mains;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MainScreen {
			
		//프레임 생성
	public static void main(String[] args) {
		Frame f = new Frame("메인");
		f.setSize(800, 800);
		f.setLayout(null);
		//로고 객체 생성
		JButton logo;
		//로고 이미지 생성
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		//로고 이미지 크기 및 위치
		logo.setSize(420,150);
		logo.setLocation(70,110);
			//중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width/2-800/2, screenSize.height/2-800/2);
			//버튼생성
		Button myp = new Button("마이페이지");
		Button start = new Button("게임시작버튼");
		Button rank = new Button("랭킹");
		Button win = new Button("승률전적");
		
		myp.setSize(200, 300);
		myp.setLocation(70, 295);
		start.setSize(200, 300);
		start.setLocation(290, 295);
		rank.setSize(60, 40);
		rank.setLocation(520, 110);
		win.setSize(60, 40);
		win.setLocation(520, 160);
		
			//텍스트 필드 생성
		TextField T = new TextField(10);
		TextField TT = new TextField(10);
		TextField T1 = new TextField(10);
		TextField T2 = new TextField(10);
		TextField T3 = new TextField(10);
		TextField T4 = new TextField(10);
		TextField T5 = new TextField(10);
		TextField T6 = new TextField(10);
		TextField T7 = new TextField(10);
		TextField T8 = new TextField(10);
		TextField T9 = new TextField(10);
		TextField T10 = new TextField(10);
		
		T.setSize(100, 40);
		T.setLocation(600, 110);
		TT.setSize(100, 40);
		TT.setLocation(600, 160);
		
		T1.setSize(150, 30);
		T1.setLocation(550, 235);
		T2.setSize(150, 30);
		T2.setLocation(550, 275);
		T3.setSize(150, 30);
		T3.setLocation(550, 315);
		T4.setSize(150, 30);
		T4.setLocation(550, 355);
		T5.setSize(150, 30);
		T5.setLocation(550, 395);
		T6.setSize(150, 30);
		T6.setLocation(550, 435);
		T7.setSize(150, 30);
		T7.setLocation(550, 475);
		T8.setSize(150, 30);
		T8.setLocation(550, 515);
		T9.setSize(150, 30);
		T9.setLocation(550, 555);
		T10.setSize(150, 30);
		T10.setLocation(550, 595);
		
			//라벨 생성
		Label l1 = new Label("1.");
		Label l2 = new Label("2.");
		Label l3 = new Label("3.");
		Label l4 = new Label("4.");
		Label l5 = new Label("5.");
		Label l6 = new Label("6.");
		Label l7 = new Label("7.");
		Label l8 = new Label("8.");
		Label l9 = new Label("9.");
		Label l10 = new Label("10.");

		l1.setSize(100, 30);
		l1.setLocation(530, 235);
		l2.setSize(100, 30);
		l2.setLocation(530, 275);
		l3.setSize(100, 30);
		l3.setLocation(530, 315);
		l4.setSize(100, 30);
		l4.setLocation(530, 355);
		l5.setSize(100, 30);
		l5.setLocation(530, 395);
		l6.setSize(100, 30);
		l6.setLocation(530, 435);
		l7.setSize(100, 30);
		l7.setLocation(530, 475);
		l8.setSize(100, 30);
		l8.setLocation(530, 515);
		l9.setSize(100, 30);
		l9.setLocation(530, 555);
		l10.setSize(100, 30);
		l10.setLocation(525, 595);
		
		f.add(myp);
		f.add(start);
		f.add(rank);
		f.add(win);
		f.add(T);
		f.add(TT);
		f.add(T1);
		f.add(T2);
		f.add(T3);
		f.add(T4);
		f.add(T5);
		f.add(T6);
		f.add(T7);
		f.add(T8);
		f.add(T9);
		f.add(T10);
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		f.add(l9);
		f.add(l10);
		f.add(logo);
		
		f.setVisible(true);

	}

}
