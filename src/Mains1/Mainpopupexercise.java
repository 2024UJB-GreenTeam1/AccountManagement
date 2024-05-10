package Mains1;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mainpopupexercise {

	// 프레임 생성
	public void excute() {
		Frame f = new Frame("운동칼로리");
		f.setSize(800, 800);
		f.setLayout(null);

		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);

		// 글씨체
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
		TextField myweighttext = new TextField(7);

		myweighttext.setSize(70, 25);
		myweighttext.setLocation(225, 162);
		myweighttext.setFont(font1);

		// 텍스트 아리아
		TextArea exercisetext = new TextArea();

		exercisetext.setSize(300, 465);
		exercisetext.setLocation(50, 200);
		exercisetext.setFont(font3);

		// 라벨
		Label exerciseMainLabel = new Label("오늘의 운동 칼로리 계산");
		Label myweightLabel = new Label("몸무게를 입력하세요");
		Label exercisename = new Label("운동명");
		Label exercisetime = new Label("운동시간");
		Label exercisekcal = new Label("소비칼로리");
		Label exercisereference = new Label("※kcal: 몸무게X운동시간X소비칼로리");
		Label exercisereference2 = new Label("※운동시간: 15분=1, 30분=2, 45분=3, 60분=4");
		Label exercisereference3 = new Label("총 칼로리 값");

		Label walkingnameLabel = new Label("걷기");
		Label walkingkcalLabel = new Label("0.9kcal");

		Label briskwalkingnameLabel = new Label("빨리걷기");
		Label briskwalkingkcalLabel = new Label("1.2kcal");

		Label runnameLabel = new Label("달리기");
		Label runkcalLabel = new Label("2.0kcal");

		Label climbingstairsnameLabel = new Label("계단오르기");
		Label climbingstairskcalLabel = new Label("1.6kcal");

		Label bicyclenameLabel = new Label("자전거타기");
		Label bicyclekcalLabel = new Label("1.5kcal");

		Label JumpRopenameLabel = new Label("줄넘기");
		Label JumpRopekcalLabel = new Label("2.6kcal");

		Label climbingnameLabel = new Label("등산");
		Label climbingkcalLabel = new Label("1.5kcal");

		Label swimmingnameLabel = new Label("수영");
		Label swimmingkcalLabel = new Label("2.0kcal");

		Label aerobicnameLabel = new Label("에어로빅");
		Label aerobickcalLabel = new Label("1.5kcal");

		Label gymnasticsnameLabel = new Label("체조");
		Label gymnasticskcalLabel = new Label("1.0kcal");

		Label tennisnameLabel = new Label("테니스");
		Label tenniskcalLabel = new Label("1.9kcal");

		Label skinameLabel = new Label("스키");
		Label skikcalLabel = new Label("1.6kcal");

		exerciseMainLabel.setSize(280, 70);
		exerciseMainLabel.setLocation(260, 60);
		exerciseMainLabel.setFont(font2);
		// 몸무게 라벨
		myweightLabel.setSize(250, 70);
		myweightLabel.setLocation(45, 140);
		myweightLabel.setFont(font1);
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
		walkingnameLabel.setSize(60, 60);
		walkingnameLabel.setLocation(360, 180);
		walkingnameLabel.setFont(font1);

		walkingkcalLabel.setSize(70, 60);
		walkingkcalLabel.setLocation(685, 180);
		walkingkcalLabel.setFont(font1);

		// 빨리 걷기 라벨
		briskwalkingnameLabel.setSize(75, 60);
		briskwalkingnameLabel.setLocation(360, 220);
		briskwalkingnameLabel.setFont(font1);

		briskwalkingkcalLabel.setSize(70, 60);
		briskwalkingkcalLabel.setLocation(685, 220);
		briskwalkingkcalLabel.setFont(font1);

		// 달리기 라벨
		runnameLabel.setSize(60, 60);
		runnameLabel.setLocation(360, 260);
		runnameLabel.setFont(font1);

		runkcalLabel.setSize(70, 60);
		runkcalLabel.setLocation(685, 260);
		runkcalLabel.setFont(font1);

		// 계단오르기 라벨
		climbingstairsnameLabel.setSize(100, 60);
		climbingstairsnameLabel.setLocation(360, 300);
		climbingstairsnameLabel.setFont(font1);

		climbingstairskcalLabel.setSize(70, 60);
		climbingstairskcalLabel.setLocation(685, 300);
		climbingstairskcalLabel.setFont(font1);

		// 자전거타기 라벨
		bicyclenameLabel.setSize(100, 60);
		bicyclenameLabel.setLocation(360, 340);
		bicyclenameLabel.setFont(font1);

		bicyclekcalLabel.setSize(70, 60);
		bicyclekcalLabel.setLocation(685, 340);
		bicyclekcalLabel.setFont(font1);

		// 줄넘기 라벨

		JumpRopenameLabel.setSize(100, 60);
		JumpRopenameLabel.setLocation(360, 380);
		JumpRopenameLabel.setFont(font1);

		JumpRopekcalLabel.setSize(70, 60);
		JumpRopekcalLabel.setLocation(685, 380);
		JumpRopekcalLabel.setFont(font1);

		// 등산 라벨

		climbingnameLabel.setSize(100, 60);
		climbingnameLabel.setLocation(360, 420);
		climbingnameLabel.setFont(font1);

		climbingkcalLabel.setSize(70, 60);
		climbingkcalLabel.setLocation(685, 420);
		climbingkcalLabel.setFont(font1);

		// 수영 라벨

		swimmingnameLabel.setSize(100, 60);
		swimmingnameLabel.setLocation(360, 460);
		swimmingnameLabel.setFont(font1);

		swimmingkcalLabel.setSize(70, 60);
		swimmingkcalLabel.setLocation(685, 460);
		swimmingkcalLabel.setFont(font1);

		// 에어로빅 라벨

		aerobicnameLabel.setSize(100, 60);
		aerobicnameLabel.setLocation(360, 500);
		aerobicnameLabel.setFont(font1);

		aerobickcalLabel.setSize(70, 60);
		aerobickcalLabel.setLocation(685, 500);
		aerobickcalLabel.setFont(font1);

		// 체조 라벨

		gymnasticsnameLabel.setSize(100, 60);
		gymnasticsnameLabel.setLocation(360, 540);
		gymnasticsnameLabel.setFont(font1);

		gymnasticskcalLabel.setSize(70, 60);
		gymnasticskcalLabel.setLocation(685, 540);
		gymnasticskcalLabel.setFont(font1);

		// 테니스 라벨

		tennisnameLabel.setSize(100, 60);
		tennisnameLabel.setLocation(360, 580);
		tennisnameLabel.setFont(font1);

		tenniskcalLabel.setSize(70, 60);
		tenniskcalLabel.setLocation(685, 580);
		tenniskcalLabel.setFont(font1);

		// 스키 라벨

		skinameLabel.setSize(100, 55);
		skinameLabel.setLocation(360, 620);
		skinameLabel.setFont(font1);

		skikcalLabel.setSize(70, 60);
		skikcalLabel.setLocation(685, 620);
		skikcalLabel.setFont(font1);

		// 버튼
		// 몸무게 입력 버튼
		Button todayexercisebutton = new Button("입력");

		todayexercisebutton.setSize(50, 30);
		todayexercisebutton.setLocation(300, 159);
		todayexercisebutton.setFont(font1);

		// 삭제 버튼
		Button exercisedirectbutton = new Button("리셋");

		exercisedirectbutton.setSize(50, 30);
		exercisedirectbutton.setLocation(240, 670);
		exercisedirectbutton.setFont(font1);

		exercisedirectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exercisetext.setText(""); // TextArea 내용을 비웁니다.
			}
		});

		f.add(exercisedirectbutton);

		// 완료 버튼
		Button exercisesccbutton = new Button("완료");
		
		

		exercisesccbutton.setSize(50, 30);
		exercisesccbutton.setLocation(300, 670);
		exercisesccbutton.setFont(font1);
		exercisesccbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 f.dispose();
			}
		});


		// 걷기 버튼
		Button walkingbutton1 = new Button("15분");

		walkingbutton1.addActionListener(new ActionListener() {
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
		f.add(walkingbutton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button walkingbutton2 = new Button("30분");

		walkingbutton2.addActionListener(new ActionListener() {
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
		f.add(walkingbutton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button walkingbutton3 = new Button("45분");

		walkingbutton3.addActionListener(new ActionListener() {
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
		f.add(walkingbutton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button walkingbutton4 = new Button("60분");

		walkingbutton4.addActionListener(new ActionListener() {
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
		f.add(walkingbutton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// 걷기 시간 버튼 위치
		walkingbutton1.setSize(50, 30);
		walkingbutton1.setLocation(460, 195);
		walkingbutton1.setFont(font1);

		walkingbutton2.setSize(50, 30);
		walkingbutton2.setLocation(515, 195);
		walkingbutton2.setFont(font1);

		walkingbutton3.setSize(50, 30);
		walkingbutton3.setLocation(570, 195);
		walkingbutton3.setFont(font1);

		walkingbutton4.setSize(50, 30);
		walkingbutton4.setLocation(625, 195);
		walkingbutton4.setFont(font1);

		// 빨리 걷기 버튼
		Button briskwalkingbutton1 = new Button("15분");

		briskwalkingbutton1.addActionListener(new ActionListener() {
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
		f.add(briskwalkingbutton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button briskwalkingbutton2 = new Button("30분");

		briskwalkingbutton2.addActionListener(new ActionListener() {
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
		f.add(briskwalkingbutton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button briskwalkingbutton3 = new Button("45분");

		briskwalkingbutton3.addActionListener(new ActionListener() {
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
		f.add(briskwalkingbutton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button briskwalkingbutton4 = new Button("60분");

		briskwalkingbutton4.addActionListener(new ActionListener() {
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
		f.add(briskwalkingbutton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		// 빨리 걷기 버튼 위치
		briskwalkingbutton1.setSize(50, 30);
		briskwalkingbutton1.setLocation(460, 235);
		briskwalkingbutton1.setFont(font1);

		briskwalkingbutton2.setSize(50, 30);
		briskwalkingbutton2.setLocation(515, 235);
		briskwalkingbutton2.setFont(font1);

		briskwalkingbutton3.setSize(50, 30);
		briskwalkingbutton3.setLocation(570, 235);
		briskwalkingbutton3.setFont(font1);

		briskwalkingbutton4.setSize(50, 30);
		briskwalkingbutton4.setLocation(625, 235);
		briskwalkingbutton4.setFont(font1);

		Button runbutton1 = new Button("15분");

		runbutton1.addActionListener(new ActionListener() {
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
		f.add(runbutton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button runbutton2 = new Button("30분");

		runbutton2.addActionListener(new ActionListener() {
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
		f.add(runbutton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button runbutton3 = new Button("45분");

		runbutton3.addActionListener(new ActionListener() {
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
		f.add(runbutton3);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button runbutton4 = new Button("60분");

		runbutton4.addActionListener(new ActionListener() {
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
		f.add(runbutton4);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});


		// 달리기 버튼 위치

		runbutton1.setSize(50, 30);
		runbutton1.setLocation(460, 275);
		runbutton1.setFont(font1);

		runbutton2.setSize(50, 30);
		runbutton2.setLocation(515, 275);
		runbutton2.setFont(font1);

		runbutton3.setSize(50, 30);
		runbutton3.setLocation(570, 275);
		runbutton3.setFont(font1);

		runbutton4.setSize(50, 30);
		runbutton4.setLocation(625, 275);
		runbutton4.setFont(font1);

		// 계단 오르기 버튼
		Button climbingstairsbutton1 = new Button("15분");

		climbingstairsbutton1.addActionListener(new ActionListener() {
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
		f.add(climbingstairsbutton1);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button climbingstairsbutton2 = new Button("30분");

		climbingstairsbutton2.addActionListener(new ActionListener() {
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
		f.add(climbingstairsbutton2);

		f.add(exercisetext);

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		Button climbingstairsbutton3 = new Button("45분");

		climbingstairsbutton3.addActionListener(new ActionListener() {
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
		f.add(climbingstairsbutton3);

		f.add(exercisetext);

		Button climbingstairsbutton4 = new Button("60분");

		climbingstairsbutton4.addActionListener(new ActionListener() {
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
		f.add(climbingstairsbutton4);

		f.add(exercisetext);

		// 계단오르기 버튼 위치

		climbingstairsbutton1.setSize(50, 30);
		climbingstairsbutton1.setLocation(460, 315);
		climbingstairsbutton1.setFont(font1);

		climbingstairsbutton2.setSize(50, 30);
		climbingstairsbutton2.setLocation(515, 315);
		climbingstairsbutton2.setFont(font1);

		climbingstairsbutton3.setSize(50, 30);
		climbingstairsbutton3.setLocation(570, 315);
		climbingstairsbutton3.setFont(font1);

		climbingstairsbutton4.setSize(50, 30);
		climbingstairsbutton4.setLocation(625, 315);
		climbingstairsbutton4.setFont(font1);

		// 자전거타기 버튼

		Button bicyclebutton1 = new Button("15분");

		bicyclebutton1.addActionListener(new ActionListener() {
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
		f.add(bicyclebutton1);

		f.add(exercisetext);

		Button bicyclebutton2 = new Button("30분");

		bicyclebutton2.addActionListener(new ActionListener() {
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
		f.add(bicyclebutton2);

		f.add(exercisetext);

		Button bicyclebutton3 = new Button("45분");

		bicyclebutton3.addActionListener(new ActionListener() {
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
		f.add(bicyclebutton3);

		f.add(exercisetext);

		Button bicyclebutton4 = new Button("60분");

		bicyclebutton4.addActionListener(new ActionListener() {
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
		f.add(bicyclebutton4);

		f.add(exercisetext);

		// 자전거타기 버튼 위치

		bicyclebutton1.setSize(50, 30);
		bicyclebutton1.setLocation(460, 355);
		bicyclebutton1.setFont(font1);

		bicyclebutton2.setSize(50, 30);
		bicyclebutton2.setLocation(515, 355);
		bicyclebutton2.setFont(font1);

		bicyclebutton3.setSize(50, 30);
		bicyclebutton3.setLocation(570, 355);
		bicyclebutton3.setFont(font1);

		bicyclebutton4.setSize(50, 30);
		bicyclebutton4.setLocation(625, 355);
		bicyclebutton4.setFont(font1);

		// 줄넘기 버튼

		Button JumpRopebutton1 = new Button("15분");

		JumpRopebutton1.addActionListener(new ActionListener() {
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
		f.add(JumpRopebutton1);

		f.add(exercisetext);

		Button JumpRopebutton2 = new Button("30분");

		JumpRopebutton2.addActionListener(new ActionListener() {
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
		f.add(JumpRopebutton2);

		f.add(exercisetext);

		Button JumpRopebutton3 = new Button("45분");

		JumpRopebutton3.addActionListener(new ActionListener() {
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
		f.add(JumpRopebutton3);

		f.add(exercisetext);

		Button JumpRopebutton4 = new Button("60분");

		JumpRopebutton4.addActionListener(new ActionListener() {
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
		f.add(JumpRopebutton4);

		f.add(exercisetext);

		// 줄넘기 버튼 위치

		JumpRopebutton1.setSize(50, 30);
		JumpRopebutton1.setLocation(460, 395);
		JumpRopebutton1.setFont(font1);

		JumpRopebutton2.setSize(50, 30);
		JumpRopebutton2.setLocation(515, 395);
		JumpRopebutton2.setFont(font1);

		JumpRopebutton3.setSize(50, 30);
		JumpRopebutton3.setLocation(570, 395);
		JumpRopebutton3.setFont(font1);

		JumpRopebutton4.setSize(50, 30);
		JumpRopebutton4.setLocation(625, 395);
		JumpRopebutton4.setFont(font1);

		// 등산 버튼

		Button climbingbutton1 = new Button("15분");

		climbingbutton1.addActionListener(new ActionListener() {
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
		f.add(climbingbutton1);

		f.add(exercisetext);

		Button climbingbutton2 = new Button("30분");

		climbingbutton2.addActionListener(new ActionListener() {
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
		f.add(climbingbutton2);

		f.add(exercisetext);

		Button climbingbutton3 = new Button("45분");

		climbingbutton3.addActionListener(new ActionListener() {
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
		f.add(climbingbutton3);

		f.add(exercisetext);

		Button climbingbutton4 = new Button("60분");

		climbingbutton4.addActionListener(new ActionListener() {
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
		f.add(climbingbutton4);

		f.add(exercisetext);

		// 등산 버튼 위치

		climbingbutton1.setSize(50, 30);
		climbingbutton1.setLocation(460, 435);
		climbingbutton1.setFont(font1);

		climbingbutton2.setSize(50, 30);
		climbingbutton2.setLocation(515, 435);
		climbingbutton2.setFont(font1);

		climbingbutton3.setSize(50, 30);
		climbingbutton3.setLocation(570, 435);
		climbingbutton3.setFont(font1);

		climbingbutton4.setSize(50, 30);
		climbingbutton4.setLocation(625, 435);
		climbingbutton4.setFont(font1);

		// 수영 버튼

		Button swimmingbutton1 = new Button("15분");

		swimmingbutton1.addActionListener(new ActionListener() {
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
		f.add(swimmingbutton1);

		f.add(exercisetext);

		Button swimmingbutton2 = new Button("30분");

		swimmingbutton2.addActionListener(new ActionListener() {
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
		f.add(swimmingbutton2);

		f.add(exercisetext);

		Button swimmingbutton3 = new Button("45분");

		swimmingbutton3.addActionListener(new ActionListener() {
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
		f.add(swimmingbutton3);

		f.add(exercisetext);

		Button swimmingbutton4 = new Button("60분");

		swimmingbutton4.addActionListener(new ActionListener() {
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
		f.add(swimmingbutton4);

		f.add(exercisetext);

		// 수영 버튼 위치

		swimmingbutton1.setSize(50, 30);
		swimmingbutton1.setLocation(460, 475);
		swimmingbutton1.setFont(font1);

		swimmingbutton2.setSize(50, 30);
		swimmingbutton2.setLocation(515, 475);
		swimmingbutton2.setFont(font1);

		swimmingbutton3.setSize(50, 30);
		swimmingbutton3.setLocation(570, 475);
		swimmingbutton3.setFont(font1);

		swimmingbutton4.setSize(50, 30);
		swimmingbutton4.setLocation(625, 475);
		swimmingbutton4.setFont(font1);

		// 에어로빅 버튼

		Button aerobicbutton1 = new Button("15분");

		aerobicbutton1.addActionListener(new ActionListener() {
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
		f.add(aerobicbutton1);

		f.add(exercisetext);

		Button aerobicbutton2 = new Button("30분");

		aerobicbutton2.addActionListener(new ActionListener() {
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
		f.add(aerobicbutton2);

		f.add(exercisetext);

		Button aerobicbutton3 = new Button("45분");

		aerobicbutton3.addActionListener(new ActionListener() {
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
		f.add(aerobicbutton3);

		f.add(exercisetext);

		Button aerobicbutton4 = new Button("60분");

		aerobicbutton4.addActionListener(new ActionListener() {
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
		f.add(aerobicbutton4);

		f.add(exercisetext);

		// 에어로빅 버튼 위치

		aerobicbutton1.setSize(50, 30);
		aerobicbutton1.setLocation(460, 515);
		aerobicbutton1.setFont(font1);

		aerobicbutton2.setSize(50, 30);
		aerobicbutton2.setLocation(515, 515);
		aerobicbutton2.setFont(font1);

		aerobicbutton3.setSize(50, 30);
		aerobicbutton3.setLocation(570, 515);
		aerobicbutton3.setFont(font1);

		aerobicbutton4.setSize(50, 30);
		aerobicbutton4.setLocation(625, 515);
		aerobicbutton4.setFont(font1);

		// 체조 버튼

		Button gymnasticsbutton1 = new Button("15분");

		gymnasticsbutton1.addActionListener(new ActionListener() {
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
		f.add(gymnasticsbutton1);

		f.add(exercisetext);

		Button gymnasticsbutton2 = new Button("30분");

		gymnasticsbutton2.addActionListener(new ActionListener() {
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
		f.add(gymnasticsbutton2);

		f.add(exercisetext);

		Button gymnasticsbutton3 = new Button("45분");

		gymnasticsbutton3.addActionListener(new ActionListener() {
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
		f.add(gymnasticsbutton3);

		f.add(exercisetext);

		Button gymnasticsbutton4 = new Button("60분");

		gymnasticsbutton4.addActionListener(new ActionListener() {
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
		f.add(gymnasticsbutton4);

		f.add(exercisetext);

		// 체조 버튼 위치

		gymnasticsbutton1.setSize(50, 30);
		gymnasticsbutton1.setLocation(460, 555);
		gymnasticsbutton1.setFont(font1);

		gymnasticsbutton2.setSize(50, 30);
		gymnasticsbutton2.setLocation(515, 555);
		gymnasticsbutton2.setFont(font1);

		gymnasticsbutton3.setSize(50, 30);
		gymnasticsbutton3.setLocation(570, 555);
		gymnasticsbutton3.setFont(font1);

		gymnasticsbutton4.setSize(50, 30);
		gymnasticsbutton4.setLocation(625, 555);
		gymnasticsbutton4.setFont(font1);

		// 테니스 버튼

		Button tennisbutton1 = new Button("15분");

		tennisbutton1.addActionListener(new ActionListener() {
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
		f.add(tennisbutton1);

		f.add(exercisetext);

		Button tennisbutton2 = new Button("30분");

		tennisbutton2.addActionListener(new ActionListener() {
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
		f.add(tennisbutton2);

		f.add(exercisetext);

		Button tennisbutton3 = new Button("45분");

		tennisbutton3.addActionListener(new ActionListener() {
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
		f.add(tennisbutton3);

		f.add(exercisetext);

		Button tennisbutton4 = new Button("60분");

		tennisbutton4.addActionListener(new ActionListener() {
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
		f.add(tennisbutton4);

		f.add(exercisetext);

		// 테니스 버튼 위치

		tennisbutton1.setSize(50, 30);
		tennisbutton1.setLocation(460, 595);
		tennisbutton1.setFont(font1);

		tennisbutton2.setSize(50, 30);
		tennisbutton2.setLocation(515, 595);
		tennisbutton2.setFont(font1);

		tennisbutton3.setSize(50, 30);
		tennisbutton3.setLocation(570, 595);
		tennisbutton3.setFont(font1);

		tennisbutton4.setSize(50, 30);
		tennisbutton4.setLocation(625, 595);
		tennisbutton4.setFont(font1);

		// 스키 버튼

		Button skibutton1 = new Button("15분");

		skibutton1.addActionListener(new ActionListener() {
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
		f.add(skibutton1);

		f.add(exercisetext);

		Button skibutton2 = new Button("30분");

		skibutton2.addActionListener(new ActionListener() {
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
		f.add(skibutton2);

		f.add(exercisetext);

		Button skibutton3 = new Button("45분");

		skibutton3.addActionListener(new ActionListener() {
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
		f.add(skibutton3);

		f.add(exercisetext);

		Button skibutton4 = new Button("60분");

		skibutton4.addActionListener(new ActionListener() {
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
		f.add(skibutton4);

		f.add(exercisetext);

		// 스키 버튼 위치

		skibutton1.setSize(50, 30);
		skibutton1.setLocation(460, 635);
		skibutton1.setFont(font1);

		skibutton2.setSize(50, 30);
		skibutton2.setLocation(515, 635);
		skibutton2.setFont(font1);

		skibutton3.setSize(50, 30);
		skibutton3.setLocation(570, 635);
		skibutton3.setFont(font1);

		skibutton4.setSize(50, 30);
		skibutton4.setLocation(625, 635);
		skibutton4.setFont(font1);

		// 버튼을 입력하면 다른 클래스에 입력됨(진행중)
		todayexercisebutton.addActionListener(new ActionListener() {
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

		f.add(exerciseMainLabel);
		f.add(myweightLabel);
		f.add(exercisename);
		f.add(exercisetime);
		f.add(exercisekcal);
		f.add(exercisereference);
		f.add(exercisereference2);

		f.add(walkingnameLabel);
		f.add(walkingkcalLabel);
		f.add(briskwalkingnameLabel);
		f.add(briskwalkingkcalLabel);
		f.add(runnameLabel);
		f.add(runkcalLabel);
		f.add(climbingstairsnameLabel);
		f.add(climbingstairskcalLabel);
		f.add(climbingstairskcalLabel);
		f.add(bicyclenameLabel);
		f.add(bicyclekcalLabel);
		f.add(JumpRopenameLabel);
		f.add(JumpRopekcalLabel);
		f.add(climbingnameLabel);
		f.add(climbingkcalLabel);
		f.add(swimmingnameLabel);
		f.add(swimmingkcalLabel);
		f.add(aerobicnameLabel);
		f.add(aerobickcalLabel);
		f.add(gymnasticsnameLabel);
		f.add(gymnasticskcalLabel);
		f.add(tennisnameLabel);
		f.add(tenniskcalLabel);
		f.add(skinameLabel);
		f.add(skikcalLabel);

		f.add(todayexercisebutton);
		f.add(exercisedirectbutton);
		f.add(exercisesccbutton);

		f.add(walkingbutton1);
		f.add(walkingbutton2);
		f.add(walkingbutton3);
		f.add(walkingbutton4);
		f.add(briskwalkingbutton1);
		f.add(briskwalkingbutton2);
		f.add(briskwalkingbutton3);
		f.add(briskwalkingbutton4);
		f.add(climbingstairsbutton1);
		f.add(climbingstairsbutton2);
		f.add(climbingstairsbutton3);
		f.add(climbingstairsbutton4);
		f.add(runbutton1);
		f.add(runbutton2);
		f.add(runbutton3);
		f.add(runbutton4);
		f.add(bicyclebutton1);
		f.add(bicyclebutton2);
		f.add(bicyclebutton3);
		f.add(bicyclebutton4);
		f.add(JumpRopebutton1);
		f.add(JumpRopebutton2);
		f.add(JumpRopebutton3);
		f.add(JumpRopebutton4);
		f.add(climbingbutton1);
		f.add(climbingbutton2);
		f.add(climbingbutton3);
		f.add(climbingbutton4);
		f.add(swimmingbutton1);
		f.add(swimmingbutton2);
		f.add(swimmingbutton3);
		f.add(swimmingbutton4);
		f.add(aerobicbutton1);
		f.add(aerobicbutton2);
		f.add(aerobicbutton3);
		f.add(aerobicbutton4);
		f.add(gymnasticsbutton1);
		f.add(gymnasticsbutton2);
		f.add(gymnasticsbutton3);
		f.add(gymnasticsbutton4);
		f.add(tennisbutton1);
		f.add(tennisbutton2);
		f.add(tennisbutton3);
		f.add(tennisbutton4);
		f.add(skibutton1);
		f.add(skibutton2);
		f.add(skibutton3);
		f.add(skibutton4);

		f.setVisible(true);

	}

}