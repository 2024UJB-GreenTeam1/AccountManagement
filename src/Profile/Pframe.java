package Profile;

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
import javax.swing.JTabbedPane;

import Mains1.Mainscreen;

//import Mains.MainScreen;

public class Pframe {
	private JFrame f;
	private JButton out, logo, delete;
	private JTabbedPane pane;
	private ProfileDAO dao;
	private PTab tab;
	Font font = new Font("SansSerif", Font.PLAIN, 15);

	public Pframe() {
		dao = new ProfileDAO();

		f = new JFrame("MY PAGE");
		f.setSize(800, 800);
		f.setLayout(null);

		out = new JButton("메인페이지로");
		out.setBounds(650, 10, 120, 30);
		out.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Mainscreen mainscreen = new Mainscreen();
				mainscreen.excute();
				f.dispose();
			}
		});

		delete = new JButton("회원 탈퇴");
		delete.setBounds(680, 700, 100, 30);
		delete.addActionListener(new ActionListener() {
			// 탈퇴 확인 취소 팝업 띄우기
			@Override
			public void actionPerformed(ActionEvent arg0) {

				// TODO Auto-generated method stub
				new Pdel();
				f.dispose();
			}
		});

		logo = new JButton();
		logo.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));
		logo.setLayout(null);
		logo.setSize(127, 115);
		logo.setLocation(10, 10);
		logo.addActionListener(new ActionListener() {
			// 메인페이지로 이동
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mainscreen mainscreen = new Mainscreen();
				mainscreen.excute();
				f.dispose();
			}
		});
		String userId = getCurrentUserId();
		DTO user = dao.getUserProfile(userId);

		pane = new JTabbedPane();
		PTab profileTab = new PTab("내 프로필", user);
		pane.addTab("내 프로필", profileTab);
		PTab idChangeTab = new PTab("E-MAIL 변경", user);
		pane.addTab("E-MAIL 변경", idChangeTab);
		PTab passwordChangeTab = new PTab("비밀번호 변경", user);
		pane.addTab("비밀번호 변경", passwordChangeTab);
		pane.setBounds(100, 130, 600, 550);

		f.add(out);
		f.add(delete);
		f.add(pane);
		f.add(logo);
		f.setVisible(true);

		// 화면중앙배치
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);
	}

	private String getCurrentUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pframe();
	}

}

class EventHandler extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent we) {
		we.getWindow().setVisible(false);
		we.getWindow().dispose();
		System.exit(0);
	}
}