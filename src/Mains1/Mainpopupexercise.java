package Mains1;

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
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Mainpopupexercise {

	// 프레임 생성
	public void excute() {
		JFrame f = new JFrame("운동칼로리");
		f.setSize(800, 800);
		f.setLayout(null);

		// 화면중앙배치
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);

		// 글씨체
		Font font0 = new Font("맑은 고딕",Font.PLAIN, 12);
		Font font1 = new Font("맑은 고딕", Font.BOLD, 18);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 25);
		Font font3 = new Font("맑은 고딕", Font.BOLD, 16);
		// 로고 객체 생성
		JLabel logo;
		// 로고 이미지 생성
		logo = new JLabel(new ImageIcon("C:\\Users\\Manic-063\\git\\AccountManagement\\img\\logoMap.jpg"));
		// 로고 이미지 크기 및 위치
		logo.setSize(80, 80);
		logo.setLocation(50, 60);

		// 텍스트필드
		JTextField myweighttext = new JTextField(7);

		myweighttext.setSize(70, 25);
		myweighttext.setLocation(225, 162);
		myweighttext.setFont(font1);

		// 텍스트 아리아
		JTextArea exercisetext = new JTextArea();

		exercisetext.setSize(300, 465);
		exercisetext.setLocation(50, 200);
		exercisetext.setFont(font3);
		

		// 라벨
		JLabel exerciseMainJLabel = new JLabel("오늘의 운동 칼로리 계산");
		JLabel myweightJLabel = new JLabel("몸무게를 입력하세요");
		JLabel exercisename = new JLabel("운동명");
		JLabel exercisetime = new JLabel("운동시간");
		JLabel exercisekcal = new JLabel("소비칼로리");
		JLabel exercisereference = new JLabel("※kcal: 몸무게X운동시간X소비칼로리");
		JLabel exercisereference2 = new JLabel("※운동시간: 15분=1, 30분=2, 45분=3, 60분=4");
		JLabel exercisereference3 = new JLabel("총 칼로리 값");

		JLabel walkingnameJLabel = new JLabel("걷기");
		JLabel walkingkcalJLabel = new JLabel("0.9kcal");

		JLabel briskwalkingnameJLabel = new JLabel("빨리걷기");
		JLabel briskwalkingkcalJLabel = new JLabel("1.2kcal");

		JLabel runnameJLabel = new JLabel("달리기");
		JLabel runkcalJLabel = new JLabel("2.0kcal");

		JLabel climbingstairsnameJLabel = new JLabel("계단오르기");
		JLabel climbingstairskcalJLabel = new JLabel("1.6kcal");

		JLabel bicyclenameJLabel = new JLabel("자전거타기");
		JLabel bicyclekcalJLabel = new JLabel("1.5kcal");

		JLabel JumpRopenameJLabel = new JLabel("줄넘기");
		JLabel JumpRopekcalJLabel = new JLabel("2.6kcal");

		JLabel climbingnameJLabel = new JLabel("등산");
		JLabel climbingkcalJLabel = new JLabel("1.5kcal");

		JLabel swimmingnameJLabel = new JLabel("수영");
		JLabel swimmingkcalJLabel = new JLabel("2.0kcal");

		JLabel aerobicnameJLabel = new JLabel("에어로빅");
		JLabel aerobickcalJLabel = new JLabel("1.5kcal");

		JLabel gymnasticsnameJLabel = new JLabel("체조");
		JLabel gymnasticskcalJLabel = new JLabel("1.0kcal");

		JLabel tennisnameJLabel = new JLabel("테니스");
		JLabel tenniskcalJLabel = new JLabel("1.9kcal");

		JLabel skinameJLabel = new JLabel("스키");
		JLabel skikcalJLabel = new JLabel("1.6kcal");

		exerciseMainJLabel.setSize(280, 70);
		exerciseMainJLabel.setLocation(260, 60);
		exerciseMainJLabel.setFont(font2);
		// 몸무게 라벨
		myweightJLabel.setSize(250, 70);
		myweightJLabel.setLocation(45, 140);
		myweightJLabel.setFont(font1);
		// 운동명 라벨
		exercisename.setSize(70, 50);
		exercisename.setLocation(360, 145);
		exercisename.setFont(font1);
		// 운동시간 라벨
		exercisetime.setSize(90, 50);
		exercisetime.setLocation(460, 145);
		exercisetime.setFont(font1);
		// 소비칼로리 라벨
		exercisekcal.setSize(100, 50);
		exercisekcal.setLocation(675, 145);
		exercisekcal.setFont(font1);
		// 참고 라벨
		exercisereference.setSize(400, 35);
		exercisereference.setLocation(360, 670);
		exercisereference.setFont(font3);

		exercisereference2.setSize(400, 35);
		exercisereference2.setLocation(360, 700);
		exercisereference2.setFont(font3);
		
		exercisereference3.setSize(400, 35);
		exercisereference3.setLocation(360, 700);
		exercisereference3.setFont(font3);

		// 걷기 라벨
		walkingnameJLabel.setSize(60, 60);
		walkingnameJLabel.setLocation(360, 180);
		walkingnameJLabel.setFont(font1);

		walkingkcalJLabel.setSize(70, 60);
		walkingkcalJLabel.setLocation(686, 180);
		walkingkcalJLabel.setFont(font1);

		// 빨리 걷기 라벨
		briskwalkingnameJLabel.setSize(75, 60);
		briskwalkingnameJLabel.setLocation(360, 220);
		briskwalkingnameJLabel.setFont(font1);

		briskwalkingkcalJLabel.setSize(70, 60);
		briskwalkingkcalJLabel.setLocation(686, 220);
		briskwalkingkcalJLabel.setFont(font1);

		// 달리기 라벨
		runnameJLabel.setSize(60, 60);
		runnameJLabel.setLocation(360, 260);
		runnameJLabel.setFont(font1);

		runkcalJLabel.setSize(70, 60);
		runkcalJLabel.setLocation(686, 260);
		runkcalJLabel.setFont(font1);

		// 계단오르기 라벨
		climbingstairsnameJLabel.setSize(100, 60);
		climbingstairsnameJLabel.setLocation(360, 300);
		climbingstairsnameJLabel.setFont(font1);

		climbingstairskcalJLabel.setSize(70, 60);
		climbingstairskcalJLabel.setLocation(686, 300);
		climbingstairskcalJLabel.setFont(font1);

		// 자전거타기 라벨
		bicyclenameJLabel.setSize(100, 60);
		bicyclenameJLabel.setLocation(360, 340);
		bicyclenameJLabel.setFont(font1);

		bicyclekcalJLabel.setSize(70, 60);
		bicyclekcalJLabel.setLocation(686, 340);
		bicyclekcalJLabel.setFont(font1);

		// 줄넘기 라벨

		JumpRopenameJLabel.setSize(100, 60);
		JumpRopenameJLabel.setLocation(360, 380);
		JumpRopenameJLabel.setFont(font1);

		JumpRopekcalJLabel.setSize(70, 60);
		JumpRopekcalJLabel.setLocation(686, 380);
		JumpRopekcalJLabel.setFont(font1);

		// 등산 라벨

		climbingnameJLabel.setSize(100, 60);
		climbingnameJLabel.setLocation(360, 420);
		climbingnameJLabel.setFont(font1);

		climbingkcalJLabel.setSize(70, 60);
		climbingkcalJLabel.setLocation(686, 420);
		climbingkcalJLabel.setFont(font1);

		// 수영 라벨

		swimmingnameJLabel.setSize(100, 60);
		swimmingnameJLabel.setLocation(360, 460);
		swimmingnameJLabel.setFont(font1);

		swimmingkcalJLabel.setSize(70, 60);
		swimmingkcalJLabel.setLocation(686, 460);
		swimmingkcalJLabel.setFont(font1);

		// 에어로빅 라벨

		aerobicnameJLabel.setSize(100, 60);
		aerobicnameJLabel.setLocation(360, 500);
		aerobicnameJLabel.setFont(font1);

		aerobickcalJLabel.setSize(70, 60);
		aerobickcalJLabel.setLocation(686, 500);
		aerobickcalJLabel.setFont(font1);

		// 체조 라벨

		gymnasticsnameJLabel.setSize(100, 60);
		gymnasticsnameJLabel.setLocation(360, 540);
		gymnasticsnameJLabel.setFont(font1);

		gymnasticskcalJLabel.setSize(70, 60);
		gymnasticskcalJLabel.setLocation(686, 540);
		gymnasticskcalJLabel.setFont(font1);

		// 테니스 라벨

		tennisnameJLabel.setSize(100, 60);
		tennisnameJLabel.setLocation(360, 580);
		tennisnameJLabel.setFont(font1);

		tenniskcalJLabel.setSize(70, 60);
		tenniskcalJLabel.setLocation(686, 580);
		tenniskcalJLabel.setFont(font1);

		// 스키 라벨

		skinameJLabel.setSize(100, 55);
		skinameJLabel.setLocation(360, 620);
		skinameJLabel.setFont(font1);

		skikcalJLabel.setSize(70, 60);
		skikcalJLabel.setLocation(686, 620);
		skikcalJLabel.setFont(font1);

		// 버튼
		// 몸무게 입력 버튼
		JButton todayexerciseJButton = new JButton("입력");

		todayexerciseJButton.setSize(59, 30);
		todayexerciseJButton.setLocation(299, 159);
		todayexerciseJButton.setFont(font0);

		// 삭제 버튼
		JButton exercisedirectJButton = new JButton("리셋");

		exercisedirectJButton.setSize(70, 30);
		exercisedirectJButton.setLocation(210, 670);
		exercisedirectJButton.setFont(font1);

		exercisedirectJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exercisetext.setText(""); // TextArea 내용을 비웁니다.
			}
		});

		f.add(exercisedirectJButton);

		// 완료 버튼
		JButton exercisesccJButton = new JButton("완료");
		
		

		exercisesccJButton.setSize(70, 30);
		exercisesccJButton.setLocation(280, 670);
		exercisesccJButton.setFont(font1);
		exercisesccJButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 f.dispose();
			}
		});


		// 걷기 버튼
		JButton walkingJButton1 = new JButton("15분");

		walkingJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 0.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("걷기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(walkingJButton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton walkingJButton2 = new JButton("30분");

		walkingJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2; // 15분 = 1 unit
					double caloriePerMinute = 0.9; // 15분 동안의 칼로리 소모량
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("걷기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(walkingJButton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton walkingJButton3 = new JButton("45분");

		walkingJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 0.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("걷기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(walkingJButton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
//				System.exit(0);
				f.dispose();
			}
		});

		JButton walkingJButton4 = new JButton("60분");

		walkingJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 0.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("걷기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(walkingJButton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// 걷기 시간 버튼 위치
		walkingJButton1.setSize(59, 30);
		walkingJButton1.setLocation(453, 195);
		walkingJButton1.setFont(font0);

		walkingJButton2.setSize(59, 30);
		walkingJButton2.setLocation(511, 195);
		walkingJButton2.setFont(font0);

		walkingJButton3.setSize(59, 30);
		walkingJButton3.setLocation(569, 195);
		walkingJButton3.setFont(font0);

		walkingJButton4.setSize(59, 30);
		walkingJButton4.setLocation(627, 195);
		walkingJButton4.setFont(font0);

		// 빨리 걷기 버튼
		JButton briskwalkingJButton1 = new JButton("15분");

		briskwalkingJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.2;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("빨리걷기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(briskwalkingJButton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton briskwalkingJButton2 = new JButton("30분");

		briskwalkingJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.2;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("빨리걷기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(briskwalkingJButton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton briskwalkingJButton3 = new JButton("45분");

		briskwalkingJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.2;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("빨리걷기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(briskwalkingJButton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton briskwalkingJButton4 = new JButton("60분");

		briskwalkingJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.2;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("빨리걷기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(briskwalkingJButton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// 빨리 걷기 버튼 위치
		briskwalkingJButton1.setSize(59, 30);
		briskwalkingJButton1.setLocation(453, 235);
		briskwalkingJButton1.setFont(font0);

		briskwalkingJButton2.setSize(59, 30);
		briskwalkingJButton2.setLocation(511, 235);
		briskwalkingJButton2.setFont(font0);

		briskwalkingJButton3.setSize(59, 30);
		briskwalkingJButton3.setLocation(569, 235);
		briskwalkingJButton3.setFont(font0);

		briskwalkingJButton4.setSize(59, 30);
		briskwalkingJButton4.setLocation(627, 235);
		briskwalkingJButton4.setFont(font0);

		JButton runJButton1 = new JButton("15분");

		runJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("달리기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(runJButton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton runJButton2 = new JButton("30분");

		runJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("달리기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(runJButton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton runJButton3 = new JButton("45분");

		runJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("달리기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(runJButton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton runJButton4 = new JButton("60분");

		runJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("달리기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(runJButton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});


		// 달리기 버튼 위치

		runJButton1.setSize(59, 30);
		runJButton1.setLocation(453, 275);
		runJButton1.setFont(font0);

		runJButton2.setSize(59, 30);
		runJButton2.setLocation(511, 275);
		runJButton2.setFont(font0);

		runJButton3.setSize(59, 30);
		runJButton3.setLocation(569, 275);
		runJButton3.setFont(font0);

		runJButton4.setSize(59, 30);
		runJButton4.setLocation(627, 275);
		runJButton4.setFont(font0);

		// 계단 오르기 버튼
		JButton climbingstairsJButton1 = new JButton("15분");

		climbingstairsJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("계단오르기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingstairsJButton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton climbingstairsJButton2 = new JButton("30분");

		climbingstairsJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("계단오르기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingstairsJButton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		JButton climbingstairsJButton3 = new JButton("45분");

		climbingstairsJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("계단오르기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingstairsJButton3);

		f.add(exercisetext);

		JButton climbingstairsJButton4 = new JButton("60분");

		climbingstairsJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("계단오르기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingstairsJButton4);

		f.add(exercisetext);

		// 계단오르기 버튼 위치

		climbingstairsJButton1.setSize(59, 30);
		climbingstairsJButton1.setLocation(453, 315);
		climbingstairsJButton1.setFont(font0);

		climbingstairsJButton2.setSize(59, 30);
		climbingstairsJButton2.setLocation(511, 315);
		climbingstairsJButton2.setFont(font0);

		climbingstairsJButton3.setSize(59, 30);
		climbingstairsJButton3.setLocation(569, 315);
		climbingstairsJButton3.setFont(font0);

		climbingstairsJButton4.setSize(59, 30);
		climbingstairsJButton4.setLocation(627, 315);
		climbingstairsJButton4.setFont(font0);

		// 자전거타기 버튼

		JButton bicycleJButton1 = new JButton("15분");

		bicycleJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("자전거타기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(bicycleJButton1);

		f.add(exercisetext);

		JButton bicycleJButton2 = new JButton("30분");

		bicycleJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("자전거타기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(bicycleJButton2);

		f.add(exercisetext);

		JButton bicycleJButton3 = new JButton("45분");

		bicycleJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("자전거타기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(bicycleJButton3);

		f.add(exercisetext);

		JButton bicycleJButton4 = new JButton("60분");

		bicycleJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("자전거타기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(bicycleJButton4);

		f.add(exercisetext);

		// 자전거타기 버튼 위치

		bicycleJButton1.setSize(59, 30);
		bicycleJButton1.setLocation(453, 355);
		bicycleJButton1.setFont(font0);

		bicycleJButton2.setSize(59, 30);
		bicycleJButton2.setLocation(511, 355);
		bicycleJButton2.setFont(font0);

		bicycleJButton3.setSize(59, 30);
		bicycleJButton3.setLocation(569, 355);
		bicycleJButton3.setFont(font0);

		bicycleJButton4.setSize(59, 30);
		bicycleJButton4.setLocation(627, 355);
		bicycleJButton4.setFont(font0);

		// 줄넘기 버튼

		JButton JumpRopeJButton1 = new JButton("15분");

		JumpRopeJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 2.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("줄넘기 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(JumpRopeJButton1);

		f.add(exercisetext);

		JButton JumpRopeJButton2 = new JButton("30분");

		JumpRopeJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 2.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("줄넘기 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(JumpRopeJButton2);

		f.add(exercisetext);

		JButton JumpRopeJButton3 = new JButton("45분");

		JumpRopeJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 2.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("줄넘기 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(JumpRopeJButton3);

		f.add(exercisetext);

		JButton JumpRopeJButton4 = new JButton("60분");

		JumpRopeJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 2.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("줄넘기 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(JumpRopeJButton4);

		f.add(exercisetext);

		// 줄넘기 버튼 위치

		JumpRopeJButton1.setSize(59, 30);
		JumpRopeJButton1.setLocation(453, 395);
		JumpRopeJButton1.setFont(font0);

		JumpRopeJButton2.setSize(59, 30);
		JumpRopeJButton2.setLocation(511, 395);
		JumpRopeJButton2.setFont(font0);

		JumpRopeJButton3.setSize(59, 30);
		JumpRopeJButton3.setLocation(569, 395);
		JumpRopeJButton3.setFont(font0);

		JumpRopeJButton4.setSize(59, 30);
		JumpRopeJButton4.setLocation(627, 395);
		JumpRopeJButton4.setFont(font0);

		// 등산 버튼

		JButton climbingJButton1 = new JButton("15분");

		climbingJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("등산 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingJButton1);

		f.add(exercisetext);

		JButton climbingJButton2 = new JButton("30분");

		climbingJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("등산 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingJButton2);

		f.add(exercisetext);

		JButton climbingJButton3 = new JButton("45분");

		climbingJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("등산 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingJButton3);

		f.add(exercisetext);

		JButton climbingJButton4 = new JButton("60분");

		climbingJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("등산 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(climbingJButton4);

		f.add(exercisetext);

		// 등산 버튼 위치

		climbingJButton1.setSize(59, 30);
		climbingJButton1.setLocation(453, 435);
		climbingJButton1.setFont(font0);

		climbingJButton2.setSize(59, 30);
		climbingJButton2.setLocation(511, 435);
		climbingJButton2.setFont(font0);

		climbingJButton3.setSize(59, 30);
		climbingJButton3.setLocation(569, 435);
		climbingJButton3.setFont(font0);

		climbingJButton4.setSize(59, 30);
		climbingJButton4.setLocation(627, 435);
		climbingJButton4.setFont(font0);

		// 수영 버튼

		JButton swimmingJButton1 = new JButton("15분");

		swimmingJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("수영 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(swimmingJButton1);

		f.add(exercisetext);

		JButton swimmingJButton2 = new JButton("30분");

		swimmingJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("수영 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(swimmingJButton2);

		f.add(exercisetext);

		JButton swimmingJButton3 = new JButton("45분");

		swimmingJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("수영 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(swimmingJButton3);

		f.add(exercisetext);

		JButton swimmingJButton4 = new JButton("60분");

		swimmingJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 2.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("수영 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(swimmingJButton4);

		f.add(exercisetext);

		// 수영 버튼 위치

		swimmingJButton1.setSize(59, 30);
		swimmingJButton1.setLocation(453, 475);
		swimmingJButton1.setFont(font0);

		swimmingJButton2.setSize(59, 30);
		swimmingJButton2.setLocation(511, 475);
		swimmingJButton2.setFont(font0);

		swimmingJButton3.setSize(59, 30);
		swimmingJButton3.setLocation(569, 475);
		swimmingJButton3.setFont(font0);

		swimmingJButton4.setSize(59, 30);
		swimmingJButton4.setLocation(627, 475);
		swimmingJButton4.setFont(font0);

		// 에어로빅 버튼

		JButton aerobicJButton1 = new JButton("15분");

		aerobicJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("에어로빅 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(aerobicJButton1);

		f.add(exercisetext);

		JButton aerobicJButton2 = new JButton("30분");

		aerobicJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("에어로빅 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(aerobicJButton2);

		f.add(exercisetext);

		JButton aerobicJButton3 = new JButton("45분");

		aerobicJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("에어로빅 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(aerobicJButton3);

		f.add(exercisetext);

		JButton aerobicJButton4 = new JButton("60분");

		aerobicJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.5;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("에어로빅 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(aerobicJButton4);

		f.add(exercisetext);

		// 에어로빅 버튼 위치

		aerobicJButton1.setSize(59, 30);
		aerobicJButton1.setLocation(453, 515);
		aerobicJButton1.setFont(font0);

		aerobicJButton2.setSize(59, 30);
		aerobicJButton2.setLocation(511, 515);
		aerobicJButton2.setFont(font0);

		aerobicJButton3.setSize(59, 30);
		aerobicJButton3.setLocation(569, 515);
		aerobicJButton3.setFont(font0);

		aerobicJButton4.setSize(59, 30);
		aerobicJButton4.setLocation(627, 515);
		aerobicJButton4.setFont(font0);

		// 체조 버튼

		JButton gymnasticsJButton1 = new JButton("15분");

		gymnasticsJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("체조 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(gymnasticsJButton1);

		f.add(exercisetext);

		JButton gymnasticsJButton2 = new JButton("30분");

		gymnasticsJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("체조 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(gymnasticsJButton2);

		f.add(exercisetext);

		JButton gymnasticsJButton3 = new JButton("45분");

		gymnasticsJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("체조 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(gymnasticsJButton3);

		f.add(exercisetext);

		JButton gymnasticsJButton4 = new JButton("60분");

		gymnasticsJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.0;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("체조 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(gymnasticsJButton4);

		f.add(exercisetext);

		// 체조 버튼 위치

		gymnasticsJButton1.setSize(59, 30);
		gymnasticsJButton1.setLocation(453, 555);
		gymnasticsJButton1.setFont(font0);

		gymnasticsJButton2.setSize(59, 30);
		gymnasticsJButton2.setLocation(511, 555);
		gymnasticsJButton2.setFont(font0);

		gymnasticsJButton3.setSize(59, 30);
		gymnasticsJButton3.setLocation(569, 555);
		gymnasticsJButton3.setFont(font0);

		gymnasticsJButton4.setSize(59, 30);
		gymnasticsJButton4.setLocation(627, 555);
		gymnasticsJButton4.setFont(font0);

		// 테니스 버튼

		JButton tennisJButton1 = new JButton("15분");

		tennisJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("테니스 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(tennisJButton1);

		f.add(exercisetext);

		JButton tennisJButton2 = new JButton("30분");

		tennisJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("테니스 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(tennisJButton2);

		f.add(exercisetext);

		JButton tennisJButton3 = new JButton("45분");

		tennisJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("테니스 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(tennisJButton3);

		f.add(exercisetext);

		JButton tennisJButton4 = new JButton("60분");

		tennisJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.9;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("테니스 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(tennisJButton4);

		f.add(exercisetext);

		// 테니스 버튼 위치

		tennisJButton1.setSize(59, 30);
		tennisJButton1.setLocation(453, 595);
		tennisJButton1.setFont(font0);

		tennisJButton2.setSize(59, 30);
		tennisJButton2.setLocation(511, 595);
		tennisJButton2.setFont(font0);

		tennisJButton3.setSize(59, 30);
		tennisJButton3.setLocation(569, 595);
		tennisJButton3.setFont(font0);

		tennisJButton4.setSize(59, 30);
		tennisJButton4.setLocation(627, 595);
		tennisJButton4.setFont(font0);

		// 스키 버튼

		JButton skiJButton1 = new JButton("15분");

		skiJButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 1;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("스키 15분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(skiJButton1);

		f.add(exercisetext);

		JButton skiJButton2 = new JButton("30분");

		skiJButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 2;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("스키 30분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(skiJButton2);

		f.add(exercisetext);

		JButton skiJButton3 = new JButton("45분");

		skiJButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 3;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("스키 45분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(skiJButton3);

		f.add(exercisetext);

		JButton skiJButton4 = new JButton("60분");

		skiJButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double weight = Double.parseDouble(myweighttext.getText());
					double minutes = 4;
					double caloriePerMinute = 1.6;
					double totalCalories = weight * minutes * caloriePerMinute;
					exercisetext.append("스키 60분: " + String.format("%.2f kcal\n", totalCalories));
				} catch (NumberFormatException nfe) {
					exercisetext.append("유효한 숫자를 입력하세요.\n");
				}
			}
		});
		f.add(skiJButton4);

		f.add(exercisetext);

		// 스키 버튼 위치

		skiJButton1.setSize(59, 30);
		skiJButton1.setLocation(453, 635);
		skiJButton1.setFont(font0);

		skiJButton2.setSize(59, 30);
		skiJButton2.setLocation(511, 635);
		skiJButton2.setFont(font0);

		skiJButton3.setSize(59, 30);
		skiJButton3.setLocation(569, 635);
		skiJButton3.setFont(font0);

		skiJButton4.setSize(59, 30);
		skiJButton4.setLocation(627, 635);
		skiJButton4.setFont(font0);

		// 버튼을 입력하면 다른 클래스에 입력됨(진행중)
		todayexerciseJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mainpopup.updateWeightText(myweighttext.getText()); // Mainpopup 클래스의 메서드 호출
			}
		});

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				f.setVisible(false);
			}
		});

		f.add(logo);
		f.add(myweighttext);
		f.add(exercisetext);

		f.add(exerciseMainJLabel);
		f.add(myweightJLabel);
		f.add(exercisename);
		f.add(exercisetime);
		f.add(exercisekcal);
		f.add(exercisereference);
		f.add(exercisereference2);

		f.add(walkingnameJLabel);
		f.add(walkingkcalJLabel);
		f.add(briskwalkingnameJLabel);
		f.add(briskwalkingkcalJLabel);
		f.add(runnameJLabel);
		f.add(runkcalJLabel);
		f.add(climbingstairsnameJLabel);
		f.add(climbingstairskcalJLabel);
		f.add(climbingstairskcalJLabel);
		f.add(bicyclenameJLabel);
		f.add(bicyclekcalJLabel);
		f.add(JumpRopenameJLabel);
		f.add(JumpRopekcalJLabel);
		f.add(climbingnameJLabel);
		f.add(climbingkcalJLabel);
		f.add(swimmingnameJLabel);
		f.add(swimmingkcalJLabel);
		f.add(aerobicnameJLabel);
		f.add(aerobickcalJLabel);
		f.add(gymnasticsnameJLabel);
		f.add(gymnasticskcalJLabel);
		f.add(tennisnameJLabel);
		f.add(tenniskcalJLabel);
		f.add(skinameJLabel);
		f.add(skikcalJLabel);

		f.add(todayexerciseJButton);
		f.add(exercisedirectJButton);
		f.add(exercisesccJButton);

		f.add(walkingJButton1);
		f.add(walkingJButton2);
		f.add(walkingJButton3);
		f.add(walkingJButton4);
		f.add(briskwalkingJButton1);
		f.add(briskwalkingJButton2);
		f.add(briskwalkingJButton3);
		f.add(briskwalkingJButton4);
		f.add(climbingstairsJButton1);
		f.add(climbingstairsJButton2);
		f.add(climbingstairsJButton3);
		f.add(climbingstairsJButton4);
		f.add(runJButton1);
		f.add(runJButton2);
		f.add(runJButton3);
		f.add(runJButton4);
		f.add(bicycleJButton1);
		f.add(bicycleJButton2);
		f.add(bicycleJButton3);
		f.add(bicycleJButton4);
		f.add(JumpRopeJButton1);
		f.add(JumpRopeJButton2);
		f.add(JumpRopeJButton3);
		f.add(JumpRopeJButton4);
		f.add(climbingJButton1);
		f.add(climbingJButton2);
		f.add(climbingJButton3);
		f.add(climbingJButton4);
		f.add(swimmingJButton1);
		f.add(swimmingJButton2);
		f.add(swimmingJButton3);
		f.add(swimmingJButton4);
		f.add(aerobicJButton1);
		f.add(aerobicJButton2);
		f.add(aerobicJButton3);
		f.add(aerobicJButton4);
		f.add(gymnasticsJButton1);
		f.add(gymnasticsJButton2);
		f.add(gymnasticsJButton3);
		f.add(gymnasticsJButton4);
		f.add(tennisJButton1);
		f.add(tennisJButton2);
		f.add(tennisJButton3);
		f.add(tennisJButton4);
		f.add(skiJButton1);
		f.add(skiJButton2);
		f.add(skiJButton3);
		f.add(skiJButton4);

		f.setVisible(true);

	}

}