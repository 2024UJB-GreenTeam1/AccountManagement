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
import javax.swing.JButton;

public class Mainscreen {
	// 프레임 생성
	public static void main(String[] args) {
		Frame f = new Frame("메인페이지");
		f.setSize(800, 800);
		f.setLayout(null);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 15);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 30);

		// 로고 객체 생성
		JButton logo;
		// 로고 이미지 생성
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(100, 90);
		logo.setLocation(60, 60);
		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
		// 버튼 생성
		Button mpg = new Button("마이페이지");
		mpg.setFont(font1);

		mpg.setSize(130, 50);
		mpg.setLocation(610, 100);
		// 텍스트필드 생성
		TextField T1 = new TextField(10);
		TextField T2 = new TextField(10);

		T1.setSize(500, 30);
		T1.setLocation(240, 195);
		T2.setSize(690, 180);
		T2.setLocation(50, 350);
		// 라벨 생성
		Label l1 = new Label("운동코멘트");
		l1.setFont(font2);
		Label l2 = new Label("인기게시글");
		l2.setFont(font2);

		l1.setSize(250, 60);
		l1.setLocation(50, 180);
		l2.setSize(155, 60);
		l2.setLocation(45, 280);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		f.add(logo);
		f.add(mpg);
		f.add(T1);
		f.add(T2);
		f.add(l1);
		f.add(l2);

		f.setVisible(true);

	}

}
