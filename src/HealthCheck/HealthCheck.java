package HealthCheck;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import IDsearch.IdSearch;
import Member.Mframe;

//extends WindowAdapter 
public class HealthCheck extends JFrame { 
	private JFrame f;
//	private JPasswordField tfPwd;
	private JButton btnI, btnS;
	private HealthDAO dao;
	ArrayList<HealthVo> list; // <HealthVo>list2
	private JPanel tab1Panel;

	// 이미지크기조절기능
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	public HealthCheck() {

		dao = new HealthDAO();

//		Font fontT = new Font("SansSerif", Font.PLAIN, 35);
		Font font = new Font("SansSerif", Font.PLAIN, 25);
		f = new JFrame("HealthCheck");
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);

		tab1Panel = new JPanel();
		JLabel jLabel = new JLabel();
		// 이미지크기조절&삽입
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
		imgTest = imageSetSize(imgTest, 145, 145);
		jLabel.setIcon(imgTest);

		
		tab1Panel.add(jLabel);
		tab1Panel.setLocation(10, 20);
		tab1Panel.setSize(150, 150);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);

		JComboBox<String> ctl20 = new JComboBox<String>();
		ctl20.setFont(new Font("Serif", Font.BOLD, 30));
		ctl20.addItem("<주간분석>");
		ctl20.addItem("<월간분석>");
		ctl20.setLocation(250, 120);
		ctl20.setSize(200, 50);

		JLabel lAt = new JLabel("운동시간 : ");
		lAt.setLocation(180, 180);
		lAt.setSize(150, 50);

		JLabel lUc = new JLabel("소모cal : ");
		lUc.setLocation(180, 230);
		lUc.setSize(150, 50);

		JLabel lIc = new JLabel("섭취cal : ");
		lIc.setLocation(180, 280);
		lIc.setSize(150, 50);

		JLabel lIw = new JLabel("섭취수분 : ");
		lIw.setLocation(180, 330);
		lIw.setSize(150, 50);

		JLabel lBmi = new JLabel("BMI : ");
		lBmi.setLocation(180, 380);
		lBmi.setSize(150, 50);

		JLabel lS = new JLabel("평균수면시간 : ");
		lS.setLocation(180, 430);
		lS.setSize(200, 50);

		// ------------------------------

		list = dao.list();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				HealthVo data = (HealthVo) list.get(i);
				String gid = data.getId();
				String DIDATE = data.getDIDATE();
				String INTAKEC = Integer.toString(data.getINTAKEC());
				String USEUPC = Integer.toString(data.getUSEUPC());
				String SLEEP = Integer.toString(data.getSLEEP());
				String WEIGHT = Integer.toString(data.getWEIGHT());
				String WATER = Integer.toString(data.getWATER());
				// HealthDAO list에 InfoDAO gid넣어주기?

				// 프린트테스트OK
				System.out.println(gid);

//				("운동시간");
				JTextField lAtT = new JTextField(USEUPC);
				lAtT.setLocation(340, 180);
				lAtT.setSize(150, 50);

//				("소모cal");
				JTextField lUcT = new JTextField(USEUPC);
				lUcT.setLocation(340, 230);
				lUcT.setSize(150, 50);

//				("섭취cal");
				JTextField lIcT = new JTextField(INTAKEC);
				lIcT.setLocation(340, 280);
				lIcT.setSize(150, 50);

//				("섭취수분");
				JTextField lIwT = new JTextField(WATER);
				lIwT.setLocation(340, 330);
				lIwT.setSize(150, 50);

//				("BMI");
				JTextField lBmiT = new JTextField(WEIGHT);
				lBmiT.setLocation(340, 380);
				lBmiT.setSize(150, 50);

//				("평균수면시간");
				JTextField lST = new JTextField(SLEEP);
				lST.setLocation(340, 430);
				lST.setSize(200, 50);

				lAtT.setFont(font);
				lUcT.setFont(font);
				lIcT.setFont(font);
				lIwT.setFont(font);
				lBmiT.setFont(font);
				lST.setFont(font);

				f.add(lAtT);
				f.add(lUcT);
				f.add(lIcT);
				f.add(lIwT);
				f.add(lBmiT);
				f.add(lST);

				f.setVisible(true);

				ctl20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						// case1 주간 평균
						if (ctl20.getSelectedItem().toString() == "<주간분석>") {
							dispose();

							lAtT.setText(USEUPC);
							lUcT.setText(USEUPC);
							lIcT.setText(INTAKEC);
							lIwT.setText(WATER);
							lBmiT.setText(WEIGHT);
							lST.setText(SLEEP);

						} else {

							// case2 월간평균
							lAtT.setText("1");
							lUcT.setText("2");
							lIcT.setText("3");
							lIwT.setText("4");
							lBmiT.setText("5");
							lST.setText("6");

						}
					}
				});

			}
		}


		btnI = new JButton("메인페이지이동");
		btnI.setLocation(170, 570);
		btnI.setSize(100, 40);

		btnS = new JButton("게시판이동");
		btnS.setLocation(400, 570);
		btnS.setSize(100, 40);

		btnS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Mframe(); // 회원가입열기
			}
		});

		btnI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new IdSearch(); //
				// 메인페이지열기
			}
		});

		lAt.setFont(font);
		lUc.setFont(font);
		lIc.setFont(font);
		lIw.setFont(font);
		lBmi.setFont(font);
		lS.setFont(font);

		f.getContentPane().add(tab1Panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.addWindowListener(this);
//		f.add(lTitle);
		f.add(ctl20);
		f.add(lAt);
		f.add(lUc);
		f.add(lIc);
		f.add(lIw);
		f.add(lBmi);
		f.add(lS);

		f.add(btnI);
		f.add(btnS);
//		f.add(lb1);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		new HealthCheck();

	}
}