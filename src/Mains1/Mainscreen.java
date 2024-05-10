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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Board.Boardset;
import HealthCheck.HealthCheck;
import Profile.Pframe;

public class Mainscreen {
	public void excute() {
		JFrame f = new JFrame("메인페이지");
		f.setSize(800, 800);
		f.setLayout(null);

		Font font1 = new Font("나눔 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("나눔고딕", Font.PLAIN, 12);

		JLabel logo = new JLabel(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\logoMainscreen.jpg"));
		logo.setSize(100, 100);
		logo.setLocation(60, 60);
		
		//버튼을 누르면 다른 클래스로 이동
		JButton mapimg = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\mapimg.jpg.jpg"));
		JButton calenderimg = new JButton(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\calenderimg.jpg.jpg"));
		mapimg.setSize(330, 200);
		mapimg.setLocation(50, 550);
		calenderimg.setSize(330, 200);
		calenderimg.setLocation(410, 550);
		
		mapimg.addActionListener(e -> {
            MapApp mapApp = new MapApp();  // MapApp 인스턴스 생성 및 표시
            mapApp.setVisible(true);
        });

		calenderimg.addActionListener(e -> {
		    CalendarMain.displayCalendar();  // CalendarMain 클래스의 새 창을 열어서 표시
		});
        
			//중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
			
		//버튼
		Button mpg = new Button("마이페이지");
		mpg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Pframe(); 
			}
		});
		
		Button healthbutton = new Button("나의건강일지");
		healthbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new HealthCheck();
			}
		});
		
		Button boardbutton = new Button("게시판이동");
		boardbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Boardset();
			}
		});
		
		mpg.setFont(font1);
		healthbutton.setFont(font1);
		boardbutton.setFont(font1);
		mpg.setSize(130, 40);
		mpg.setLocation(610, 60);
		healthbutton.setSize(130, 40);
		healthbutton.setLocation(610, 105);
		boardbutton.setSize(130, 40);
		boardbutton.setLocation(610, 150);
		
			//텍스트필드
		TextField healthcommentext = new TextField(10);
		TextField popboardtext = new TextField(10);
		healthcommentext.setFont(font3);
		healthcommentext.setSize(580, 25);
		healthcommentext.setLocation(160, 205);
			//코멘트 받아오기
		String healthComment = Healthcoment.getHealthComment();
		healthcommentext.setText(healthComment);
		
		popboardtext.setSize(690, 180);
		popboardtext.setLocation(50, 310);
			//라벨
		Label healthcomment = new Label("운동코멘트");
		healthcomment.setFont(font2);
		Label popboard = new Label("인기게시글");
		popboard.setFont(font2);
		Label maplink = new Label("현위치 헬스장 검색");
		maplink.setFont(font2);
		Label calendarlink = new Label("나의 일정관리");
		calendarlink.setFont(font2);
		healthcomment.setSize(250, 60);
		healthcomment.setLocation(48, 185);
		popboard.setSize(155, 60);
		popboard.setLocation(50, 240);
		maplink.setSize(250, 60);
		maplink.setLocation(50, 490);
		calendarlink.setSize(250, 60);
		calendarlink.setLocation(405, 490);
			//창닫기
		f.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent evt) {
		        int resp = JOptionPane.showConfirmDialog(f, "정말 로그아웃 하시겠습니까?",
		            "Exit?", JOptionPane.YES_NO_OPTION);

		        if (resp == JOptionPane.YES_OPTION) {
//		            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        	f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		        } else {
		            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
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
		
//		JOptionPane optionPane = new JOptionPane("ErrorMsg", JOptionPane.ERROR_MESSAGE);    
//		JDialog dialog = optionPane.createDialog("Failure");
//		dialog.setAlwaysOnTop(true);
//		dialog.setVisible(true);
	}

	private void addWindowListener(WindowAdapter windowAdapter) {
		// TODO Auto-generated method stub
		
	}
}