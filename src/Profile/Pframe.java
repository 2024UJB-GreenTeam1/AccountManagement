package Profile;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

import Mains1.Mainscreen;
import login.InfoVo;

//import Mains.MainScreen;

public class Pframe {
	private JFrame f;
	private JButton out, logo, delete;
	private JTabbedPane pane;
	private ProfileDAO dao;
	private PTab tab;
	Font font = new Font("SansSerif", Font.PLAIN, 15);

	// 이미지크기조절셋업
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

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
		// 로고크기조절&삽입
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo1.jpg"));
		imgTest = imageSetSize(imgTest, 119, 119);
		JButton logo = new JButton(imgTest);
//		logo.setIcon(imgTest);
		logo.setSize(120, 120);
		logo.setLocation(10, 10);

//		logo = new JButton();
//		logo.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));
//		logo.setLayout(null);
//		logo.setSize(127, 115);
//		logo.setLocation(10, 10);
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
		// 창닫기
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				int resp = JOptionPane.showConfirmDialog(f, "정말 로그아웃 하시겠습니까?", "Exit?", JOptionPane.YES_NO_OPTION);
				if (resp == JOptionPane.YES_OPTION) {
					f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} else {
					f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		// 화면중앙배치
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);
	}

	private String getCurrentUserId() {
		// TODO Auto-generated method stub
//		return InfoVo.getInstance().getId();
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