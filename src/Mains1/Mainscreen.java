package Mains1;
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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import HealthCheck.HealthCheck;
import login.InfoVo;
import login.LoginFrame;

public class Mainscreen {
	
	private String id;
	ArrayList<InfoVo> list;
//	private LoginFrame login; 
		
	
	// 프레임 생성
	public void excute() {
//		new LoginFrame();
//		InfoVo data = new InfoVo();
//		id = list.getTfId();
//		System.out.println(id);
		
		
		
		Frame f = new Frame("메인페이지");
		f.setSize(800, 800);
		f.setLayout(null);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 25);

		// 로고 및 지도, 달력 이미지 객체 생성
		JButton logo;
		JButton mapimg;
		JButton calenderimg;
		// 로고 및 지도, 달력 이미지 이미지 생성
		logo = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\bin\\img\\logo_Mains.jpg"));
		mapimg = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\bin\\img\\mapimg.jpg.jpg"));
		calenderimg = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\bin\\img\\calenderimg.jpg.jpg"));
		// 로고 및 지도, 달력 이미지 크기 및 위치
		logo.setSize(100, 100);
		logo.setLocation(60, 60);
		
		mapimg.setSize(330, 200);
		mapimg.setLocation(50, 550);
		
		
		calenderimg.setSize(330, 200);
		calenderimg.setLocation(410, 550);
		
		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
		// 버튼 생성
		Button mpg = new Button("마이페이지");
		Button healthbutton = new Button("나의건강일지");
		Button boardbutton  = new Button("게시판이동");
		mpg.setFont(font1);
		healthbutton.setFont(font1);
		boardbutton.setFont(font1);
		healthbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new HealthCheck();		//PWD찾기열기
				
			}
		});
		
		
		

		mpg.setSize(130, 40);
		mpg.setLocation(610, 60);
		healthbutton.setSize(130, 40);
		healthbutton.setLocation(610, 105);
		boardbutton.setSize(130, 40);
		boardbutton.setLocation(610, 150);//고치고 라벨 추가
		// 텍스트필드 생성
		TextField healthcommentext = new TextField(10);
		TextField popboardtext = new TextField(10);
		healthcommentext.setFont(font2);

		healthcommentext.setSize(540, 30);
		healthcommentext.setLocation(200, 205);
		popboardtext.setSize(690, 180);
		popboardtext.setLocation(50, 310);
		// 라벨 생성
		Label healthcomment = new Label("운동코멘트");
		healthcomment.setFont(font3);
		Label popboard = new Label("인기게시글");
		popboard.setFont(font3);
		Label maplink = new Label("현위치 헬스장 검색");
		maplink.setFont(font3);
		Label calendarlink = new Label("나의 일정관리");
		calendarlink.setFont(font3);

		healthcomment.setSize(250, 60);
		healthcomment.setLocation(50, 190);
		popboard.setSize(155, 60);
		popboard.setLocation(50, 240);
		maplink.setSize(250, 60);
		maplink.setLocation(50, 490);
		calendarlink.setSize(250, 60);
		calendarlink.setLocation(405, 490);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		f.add(logo);
		f.add(mapimg);
		f.add(calenderimg);
		f.add(mpg);
		f.add(healthbutton);
		f.add(boardbutton);
		f.add(healthcommentext);
		f.add(popboardtext);
		f.add(healthcomment);
		f.add(popboard);
		f.add(maplink);
		f.add(calendarlink);

		f.setVisible(true);

	}

}