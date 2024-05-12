package Mains1;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Board.Boardset;
import HealthCheck.HealthCheck;
import Profile.Pframe;

public class Mainscreen {
	// 이미지크기조절셋업
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
	
	public void excute() {
		JFrame f = new JFrame("메인페이지");
	
		f.setSize(800, 800);
		f.setLayout(null);

		Font font1 = new Font("나눔 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("나눔고딕", Font.PLAIN, 12);

		
		// 로고크기조절&삽입
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
		imgTest = imageSetSize(imgTest, 60, 60);
		JLabel logo = new JLabel(imgTest);
//		logo.setIcon(imgTest);
		logo.setSize(100, 100);
		logo.setLocation(60, 60);
		
		//버튼을 누르면 다른 클래스로 이동
		java.net.URL imageUrl2 = getClass().getResource("../img/mapimg.jpg");
		JButton mapimg = new JButton(new ImageIcon(imageUrl2));
		java.net.URL imageUrl3 = getClass().getResource("../img/calenderimg.jpg");
		JButton calenderimg = new JButton(new ImageIcon(imageUrl3));
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
        
		// 화면중앙배치
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		Point centerPoint = ge.getCenterPoint();
//		int leftTopX = centerPoint.x - f.getWidth() / 2;
//		int leftTopY = centerPoint.y - f.getHeight() / 2;
//		f.setLocation(leftTopX, leftTopY);
			
		//버튼
		JButton mpg = new JButton("마이페이지");
		mpg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Pframe(); 
			}
		});
		
		JButton healthbutton = new JButton("나의건강일지");
		healthbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new HealthCheck();
			}
		});
		
		JButton boardbutton = new JButton("게시판이동");
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
		JTextField healthcommentext = new JTextField(10);
		JTextField popboardtext = new JTextField(10);
		healthcommentext.setFont(font3);
		healthcommentext.setSize(580, 25);
		healthcommentext.setLocation(160, 205);
			//코멘트 받아오기
		String healthComment = Healthcoment.getHealthComment();
		healthcommentext.setText(healthComment);
		
		popboardtext.setSize(690, 180);
		popboardtext.setLocation(50, 310);
			//라벨
		JLabel healthcomment = new JLabel("운동코멘트");
		healthcomment.setFont(font2);
		JLabel popboard = new JLabel("인기게시글");
		popboard.setFont(font2);
		JLabel maplink = new JLabel("현위치 헬스장 검색");
		maplink.setFont(font2);
		JLabel calendarlink = new JLabel("나의 일정관리");
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
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
//		f.setExtendedState(JFrame.MAXIMIZED_BOTH);	//
		
	}

}