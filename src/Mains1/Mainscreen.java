package Mains1;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		DAO dao = new DAO();

		f.setSize(800, 800);
		f.setLayout(null);

		Font font1 = new Font("나눔 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font3 = new Font("나눔고딕", Font.PLAIN, 12);

		// 로고크기조절&삽입
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
		imgTest = imageSetSize(imgTest, 129, 129);
		JLabel logo = new JLabel(imgTest);
//		logo.setIcon(imgTest);
		logo.setSize(130, 130);
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
			MapApp mapApp = new MapApp(); // MapApp 인스턴스 생성 및 표시
			mapApp.setVisible(true);
		});

		calenderimg.addActionListener(e -> {
			CalendarMain.displayCalendar(); // CalendarMain 클래스의 새 창을 열어서 표시
		});

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
		// 버튼
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

		// 텍스트필드
		TextField healthcommentext = new TextField(10);
		JTextField popboardtext = new JTextField(10);
		healthcommentext.setFont(font3);
		healthcommentext.setSize(580, 25);
		healthcommentext.setLocation(160, 205);
		// 코멘트 받아오기
		String healthComment = Healthcoment.getHealthComment();
		healthcommentext.setText(healthComment);

		popboardtext.setSize(690, 180);
		popboardtext.setLocation(50, 310);

		// 추가내용
		JLabel bid = new JLabel("아이디");
		bid.setBounds(0, 0, 155, 30);
		bid.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(bid);
		JLabel btitle = new JLabel("제목");
		btitle.setBounds(155, 0, 300, 30);
		btitle.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(btitle);
		JLabel blike = new JLabel("좋아요");
		blike.setBounds(455, 0, 115, 30);
		blike.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(blike);
		JLabel bviews = new JLabel("조회수");
		bviews.setBounds(570, 0, 120, 30);
		bviews.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(bviews);
		
		
		JLabel b1id = new JLabel();
		b1id.setBounds(0, 30, 155, 50);
		b1id.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b1id);
		JButton b1title = new JButton();
		b1title.setBounds(155, 30, 300, 50);
		popboardtext.add(b1title);
		b1title.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JLabel b1like = new JLabel();
		b1like.setBounds(455, 30, 115, 50);
		b1like.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b1like);
		JLabel b1views = new JLabel();
		b1views.setBounds(570, 30, 120, 50);
		b1views.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b1views);

		JLabel b2id = new JLabel();
		b2id.setBounds(0, 80, 155, 50);
		b2id.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b2id);
		JButton b2title = new JButton();
		b2title.setBounds(155, 80, 300, 50);
		popboardtext.add(b2title);
		b2title.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel b2like = new JLabel();
		b2like.setBounds(455, 80, 115, 50);
		b2like.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b2like);
		JLabel b2views = new JLabel();
		b2views.setBounds(570, 80, 120, 50);
		b2views.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b2views);

		JLabel b3id = new JLabel();
		b3id.setBounds(0, 130, 155, 50);
		b3id.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b3id);
		JButton b3title = new JButton();
		b3title.setBounds(155, 130, 300, 50);
		popboardtext.add(b3title);
		b3title.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		JLabel b3like = new JLabel();
		b3like.setBounds(455, 130, 115, 50);
		b3like.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b3like);
		JLabel b3views = new JLabel();
		b3views.setBounds(570, 130, 120, 50);
		b3views.setHorizontalAlignment(JLabel.CENTER);
		popboardtext.add(b3views);

		ResultSet resultSet = dao.like3();
		try {
			int i = 0;
			while (resultSet.next() && i < 4) {
				String id = resultSet.getString("USER_ID");
				String title = resultSet.getString("BCTITLE");
				int like = resultSet.getInt("BCLIKES");
				int views = resultSet.getInt("BCVIEWS");

				// 각각의 JLabel과 JButton에 가져온 정보를 설정
				if (i == 0) {
					b1id.setText(id);
					b1title.setText(title);
					b1like.setText(String.valueOf(like));
					b1views.setText(String.valueOf(views));
				} else if (i == 1) {
					b2id.setText(id);
					b2title.setText(title);
					b2like.setText(String.valueOf(like));
					b2views.setText(String.valueOf(views));
				} else if (i == 2) {
					b3id.setText(id);
					b3title.setText(title);
					b3like.setText(String.valueOf(like));
					b3views.setText(String.valueOf(views));
				}

				i++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 라벨
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
	}


	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}