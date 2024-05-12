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
import javax.swing.JTextField;

import Board.Boardset;
import Mains1.Mainscreen;

//extends WindowAdapter 
public class HealthCheck extends JFrame {
	private JFrame f;
//	private JPasswordField tfPwd;
	private JButton btnI, btnS;
	private HealthDAO dao;
	ArrayList<HealthVo> list, list2, list3; // <HealthVo>list2
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
		Font font = new Font("SansSerif", Font.PLAIN, 20);
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

		JComboBox<String> ctl20 = new JComboBox<String>();
		ctl20.setFont(new Font("Serif", Font.BOLD, 30));
		ctl20.addItem("<주간분석>");
		ctl20.addItem("<월간분석>");
		ctl20.addItem("<연간분석>");
		ctl20.setLocation(250, 120);
		ctl20.setSize(200, 50);

		JLabel lAt = new JLabel("평균운동시간 : ");
		lAt.setLocation(180, 180);
		lAt.setSize(150, 50);
		lAt.setFont(font);

		JLabel lUc = new JLabel("평균소모cal : ");
		lUc.setLocation(180, 230);
		lUc.setSize(150, 50);
		lUc.setFont(font);
		
		JLabel lIc = new JLabel("평균섭취cal : ");
		lIc.setLocation(180, 280);
		lIc.setSize(150, 50);
		lIc.setFont(font);
		
		JLabel lIw = new JLabel("평균섭취수분 : ");
		lIw.setLocation(180, 330);
		lIw.setSize(150, 50);
		lIw.setFont(font);
		
		JLabel lBmi = new JLabel("현재 BMI : ");
		lBmi.setLocation(180, 450);
		lBmi.setSize(180, 50);
		lBmi.setFont(font);
		
		JLabel lS = new JLabel("평균수면시간 : ");
		lS.setLocation(180, 380);
		lS.setSize(150, 50);
		lS.setFont(font);
		// ------------------------------

		list = dao.list();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				HealthVo data = (HealthVo) list.get(i);
				String avg_exercise_hours = Integer.toString(data.getAvg_exercise_hours());
				String avg_calories_burned = Integer.toString(data.getAvg_calories_burned());
				String avg_calories_intake = Integer.toString(data.getAvg_calories_intake());
				String avg_water_intake = Integer.toString(data.getAvg_water_intake());
				String avg_sleep_hours = Integer.toString(data.getAvg_sleep_hours());
				String current_BMI = Integer.toString(data.getCurrent_BMI());

				// HealthDAO list에 InfoDAO gid넣어주기?

				// 프린트테스트OK
//				System.out.println(gid);

//				("운동시간");
				JLabel lAtT = new JLabel(avg_exercise_hours);
				lAtT.setLocation(340, 180);
				lAtT.setSize(150, 50);

//				("소모cal");
				JLabel lUcT = new JLabel(avg_calories_burned);
				lUcT.setLocation(340, 230);
				lUcT.setSize(150, 50);

//				("섭취cal");
				JLabel lIcT = new JLabel(avg_calories_intake);
				lIcT.setLocation(340, 280);
				lIcT.setSize(150, 50);

//				("섭취수분");
				JLabel lIwT = new JLabel(avg_water_intake);
				lIwT.setLocation(340, 330);
				lIwT.setSize(150, 50);

//				("BMI");
				JLabel lBmiT = new JLabel(current_BMI);
				lBmiT.setLocation(340, 450);
				lBmiT.setSize(150, 50);

//				("평균수면시간");
				JLabel lST = new JLabel(avg_sleep_hours);
				lST.setLocation(340, 380);
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

							lAtT.setText(avg_exercise_hours);
							lUcT.setText(avg_calories_burned);
							lIcT.setText(avg_calories_intake);
							lIwT.setText(avg_water_intake);
							lBmiT.setText(current_BMI);
							lST.setText(avg_sleep_hours);

							// case2 월간평균
						} else if(ctl20.getSelectedItem().toString() == "<월간분석>") {
							list2 = dao.list2();
							if (list2.size() != 0) {
								for (int i = 0; i < list2.size(); i++) {
									HealthVo data = (HealthVo) list2.get(i);
									String avg_exercise_hours = Integer.toString(data.getAvg_exercise_hours());
									String avg_calories_burned = Integer.toString(data.getAvg_calories_burned());
									String avg_calories_intake = Integer.toString(data.getAvg_calories_intake());
									String avg_water_intake = Integer.toString(data.getAvg_water_intake());
									String avg_sleep_hours = Integer.toString(data.getAvg_sleep_hours());
									String current_BMI = Integer.toString(data.getCurrent_BMI());
						
							lAtT.setText(avg_exercise_hours);
							lUcT.setText(avg_calories_burned);
							lIcT.setText(avg_calories_intake);
							lIwT.setText(avg_water_intake);
							lBmiT.setText(current_BMI);
							lST.setText(avg_sleep_hours);
								}
							}
							//case3 연간평균
						}else {
							list3 = dao.list3();
							if (list3.size() != 0) {
								for (int i = 0; i < list3.size(); i++) {
									HealthVo data = (HealthVo) list3.get(i);
									String avg_exercise_hours = Integer.toString(data.getAvg_exercise_hours());
									String avg_calories_burned = Integer.toString(data.getAvg_calories_burned());
									String avg_calories_intake = Integer.toString(data.getAvg_calories_intake());
									String avg_water_intake = Integer.toString(data.getAvg_water_intake());
									String avg_sleep_hours = Integer.toString(data.getAvg_sleep_hours());
									String current_BMI = Integer.toString(data.getCurrent_BMI());
						
							lAtT.setText(avg_exercise_hours);
							lUcT.setText(avg_calories_burned);
							lIcT.setText(avg_calories_intake);
							lIwT.setText(avg_water_intake);
							lBmiT.setText(current_BMI);
							lST.setText(avg_sleep_hours);
								}
							}
						}
					}
				});

			}
		}

		btnI = new JButton("메인페이지이동");
		btnI.setLocation(170, 570);
		btnI.setSize(150, 40);
		btnI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Mainscreen mainscreen = new Mainscreen(); //
				f.dispose();
				mainscreen.excute();
				// 메인페이지열기
			}
		});

		btnS = new JButton("게시판이동");
		btnS.setLocation(370, 570);
		btnS.setSize(150, 40);
		btnS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new Boardset();
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
		f.setLocationRelativeTo(null);
//		f.add(lb1);

		f.setVisible(true);
	}

	public static void main(String[] args) {
		new HealthCheck();

	}
}