package Mains1;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mainpopupfood {

	// 프레임 생성
	public void excute() {
		Frame f = new Frame("음식칼로리");
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

		// 아리아
		TextArea foodtext = new TextArea();

		foodtext.setSize(300, 465);
		foodtext.setLocation(50, 200);
		foodtext.setFont(font3);

		// 라벨
		Label foodMainLabel = new Label("오늘의 음식 칼로리 계산");
		Label foodname = new Label("음식명");
		Label foodservingsizeLabel = new Label("1회 제공량");
		Label foodkcal = new Label("음식칼로리");

		Label whitericenameLabel = new Label("백미");
		Label whitericekcalLabel = new Label("129kcal");

		Label brownricenameLabel = new Label("현미");
		Label brownricekcalLabel = new Label("110kcal");

		Label sugarnameLabel = new Label("설탕");
		Label sugarkcalLabel = new Label("387kcal");

		Label saltnameLabel = new Label("소금");
		Label saltkcalLabel = new Label("0kcal");

		Label misonameLabel = new Label("미소된장국");
		Label misokcalLabel = new Label("38kcal");

		Label breastnameLabel = new Label("닭가슴살");
		Label breastkcalLabel = new Label("195kcal");

		Label breastnameLabel2 = new Label("닭가슴살(구이)");
		Label breastkcalLabel2 = new Label("195kcal");

		Label steaknameLabel = new Label("쇠고기스테이크");
		Label steakkcalLabel = new Label("252kcal");

		Label saladnameLabel = new Label("야채샐러드");
		Label saladkcalLabel = new Label("98kcal");

		Label saladnameLabel2 = new Label("야채샐러드(드레싱X)");
		Label saladkcalLabel2 = new Label("67kcal");

		Label mangonameLabel = new Label("망고");
		Label mangokcalLabel = new Label("65kcal");

		Label melonnameLabel = new Label("멜론");
		Label melonkcalLabel = new Label("34kcal");

		foodMainLabel.setSize(280, 70);
		foodMainLabel.setLocation(260, 60);
		foodMainLabel.setFont(font2);

		// 음식명 라벨
		foodname.setSize(70, 50);
		foodname.setLocation(360, 145);
		foodname.setFont(font1);
		// 1회 제공량 라벨
		foodservingsizeLabel.setSize(100, 50);
		foodservingsizeLabel.setLocation(550, 145);
		foodservingsizeLabel.setFont(font1);
		// 소비칼로리 라벨
		foodkcal.setSize(100, 50);
		foodkcal.setLocation(675, 145);
		foodkcal.setFont(font1);

		// 백미 라벨
		whitericenameLabel.setSize(100, 60);
		whitericenameLabel.setLocation(360, 180);
		whitericenameLabel.setFont(font1);

		whitericekcalLabel.setSize(70, 60);
		whitericekcalLabel.setLocation(685, 180);
		whitericekcalLabel.setFont(font1);

		// 현미 라벨
		brownricenameLabel.setSize(100, 60);
		brownricenameLabel.setLocation(360, 220);
		brownricenameLabel.setFont(font1);

		brownricekcalLabel.setSize(70, 60);
		brownricekcalLabel.setLocation(685, 220);
		brownricekcalLabel.setFont(font1);

		// 설탕 라벨
		sugarnameLabel.setSize(100, 60);
		sugarnameLabel.setLocation(360, 260);
		sugarnameLabel.setFont(font1);

		sugarkcalLabel.setSize(70, 60);
		sugarkcalLabel.setLocation(685, 260);
		sugarkcalLabel.setFont(font1);

		// 소금 라벨
		saltnameLabel.setSize(100, 60);
		saltnameLabel.setLocation(360, 300);
		saltnameLabel.setFont(font1);

		saltkcalLabel.setSize(70, 60);
		saltkcalLabel.setLocation(685, 300);
		saltkcalLabel.setFont(font1);

		// 미소된장 라벨
		misonameLabel.setSize(100, 60);
		misonameLabel.setLocation(360, 340);
		misonameLabel.setFont(font1);

		misokcalLabel.setSize(70, 60);
		misokcalLabel.setLocation(685, 340);
		misokcalLabel.setFont(font1);

		// 닭가슴살 라벨

		breastnameLabel.setSize(100, 60);
		breastnameLabel.setLocation(360, 380);
		breastnameLabel.setFont(font1);

		breastkcalLabel.setSize(70, 60);
		breastkcalLabel.setLocation(685, 380);
		breastkcalLabel.setFont(font1);

		// 구운 닭가슴살 라벨

		breastnameLabel2.setSize(150, 60);
		breastnameLabel2.setLocation(360, 420);
		breastnameLabel2.setFont(font1);

		breastkcalLabel2.setSize(70, 60);
		breastkcalLabel2.setLocation(685, 420);
		breastkcalLabel2.setFont(font1);

		// 스테이크 라벨

		steaknameLabel.setSize(150, 60);
		steaknameLabel.setLocation(360, 460);
		steaknameLabel.setFont(font1);

		steakkcalLabel.setSize(70, 60);
		steakkcalLabel.setLocation(685, 460);
		steakkcalLabel.setFont(font1);

		// 샐러드 라벨

		saladnameLabel.setSize(100, 60);
		saladnameLabel.setLocation(360, 500);
		saladnameLabel.setFont(font1);

		saladkcalLabel.setSize(70, 60);
		saladkcalLabel.setLocation(685, 500);
		saladkcalLabel.setFont(font1);

		// 샐러드2 라벨

		saladnameLabel2.setSize(190, 60);
		saladnameLabel2.setLocation(360, 540);
		saladnameLabel2.setFont(font1);

		saladkcalLabel2.setSize(70, 60);
		saladkcalLabel2.setLocation(685, 540);
		saladkcalLabel2.setFont(font1);

		// 망고 라벨

		mangonameLabel.setSize(100, 60);
		mangonameLabel.setLocation(360, 580);
		mangonameLabel.setFont(font1);

		mangokcalLabel.setSize(70, 60);
		mangokcalLabel.setLocation(685, 580);
		mangokcalLabel.setFont(font1);

		// 메론 라벨

		melonnameLabel.setSize(100, 60);
		melonnameLabel.setLocation(360, 620);
		melonnameLabel.setFont(font1);

		melonkcalLabel.setSize(70, 60);
		melonkcalLabel.setLocation(685, 620);
		melonkcalLabel.setFont(font1);

		// 버튼

		// 리셋 버튼
		Button fooddirectbutton = new Button("리셋");

		fooddirectbutton.setSize(50, 30);
		fooddirectbutton.setLocation(240, 670);
		fooddirectbutton.setFont(font1);
		
		fooddirectbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodtext.setText("");
			}
		});

		f.add(fooddirectbutton);

		// 완료 버튼
		Button foodsccbutton = new Button("완료");

		foodsccbutton.setSize(50, 30);
		foodsccbutton.setLocation(300, 670);
		foodsccbutton.setFont(font1);

		// 백미 버튼
		Button whitericebutton1 = new Button("100g");

		whitericebutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 129; // 칼로리 소모량
				foodtext.append(String.format("백미 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		whitericebutton1.setSize(100, 30);
		whitericebutton1.setLocation(550, 195);
		whitericebutton1.setFont(font1);

		// 현미 버튼
		Button brownricebutton1 = new Button("100g");

		brownricebutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 129; // 칼로리 소모량
				foodtext.append(String.format("현미 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		brownricebutton1.setSize(100, 30);
		brownricebutton1.setLocation(550, 235);
		brownricebutton1.setFont(font1);

		// 설탕 버튼
		Button sugarbutton1 = new Button("100g");

		sugarbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 387; // 칼로리 소모량
				foodtext.append(String.format("설탕 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		sugarbutton1.setSize(100, 30);
		sugarbutton1.setLocation(550, 275);
		sugarbutton1.setFont(font1);

		// 소금 버튼
		Button saltbutton1 = new Button("100g");

		saltbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 0; // 칼로리 소모량
				foodtext.append(String.format("소금 칼로리: %.0f kcal\n", foodcalories));
			}
		});
		
		saltbutton1.setSize(100, 30);
		saltbutton1.setLocation(550, 315);
		saltbutton1.setFont(font1);

		// 미소된장국 버튼

		Button misobutton1 = new Button("100g");

		misobutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 38; // 칼로리 소모량
				foodtext.append(String.format("미소된장국 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		misobutton1.setSize(100, 30);
		misobutton1.setLocation(550, 355);
		misobutton1.setFont(font1);

		// 닭가슴살

		Button breastbutton1 = new Button("100g");

		breastbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 195; // 칼로리 소모량
				foodtext.append(String.format("닭가슴살 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		breastbutton1.setSize(100, 30);
		breastbutton1.setLocation(550, 395);
		breastbutton1.setFont(font1);

		// 닭가슴살2

		Button breastbutton12 = new Button("100g");

		breastbutton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 195; // 칼로리 소모량
				foodtext.append(String.format("닭가슴살(구이) 칼로리: %.0f kcal\n", foodcalories));
			}
		});
		

		breastbutton12.setSize(100, 30);
		breastbutton12.setLocation(550, 435);
		breastbutton12.setFont(font1);

		// 스테이크

		Button steakbutton1 = new Button("100g");

		steakbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 252; // 칼로리 소모량
				foodtext.append(String.format("쇠고기스테이크 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		steakbutton1.setSize(100, 30);
		steakbutton1.setLocation(550, 475);
		steakbutton1.setFont(font1);

		// 샐러드

		Button saladbutton1 = new Button("100g");

		saladbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 98; // 칼로리 소모량
				foodtext.append(String.format("야채샐러드 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		saladbutton1.setSize(100, 30);
		saladbutton1.setLocation(550, 515);
		saladbutton1.setFont(font1);

		// 샐러드2 버튼

		Button saladbutton12 = new Button("100g");

		saladbutton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 67; // 칼로리 소모량
				foodtext.append(String.format("야채샐러드(드레싱X) 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		saladbutton12.setSize(100, 30);
		saladbutton12.setLocation(550, 555);
		saladbutton12.setFont(font1);

		// 망고

		Button mangobutton1 = new Button("100g");

		mangobutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 65; // 칼로리 소모량
				foodtext.append(String.format("망고 칼로리: %.0f kcal\n", foodcalories));
			}
		});

		mangobutton1.setSize(100, 30);
		mangobutton1.setLocation(550, 595);
		mangobutton1.setFont(font1);

		// 멜론 버튼

		Button melonbutton1 = new Button("100g");

		melonbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double foodcalories = 34; // 칼로리 소모량
				foodtext.append(String.format("멜론 칼로리: %.0f kcal\n", foodcalories));
			}
		});
	
		melonbutton1.setSize(100, 30);
		melonbutton1.setLocation(550, 635);
		melonbutton1.setFont(font1);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				f.setVisible(false);
			}
		});

		f.add(logo);
		f.add(foodtext);

		f.add(foodMainLabel);
		f.add(foodname);
		f.add(foodservingsizeLabel);
		f.add(foodkcal);

		f.add(whitericenameLabel);
		f.add(whitericekcalLabel);
		f.add(brownricenameLabel);
		f.add(brownricekcalLabel);
		f.add(sugarnameLabel);
		f.add(sugarkcalLabel);
		f.add(saltnameLabel);
		f.add(saltkcalLabel);
		f.add(misonameLabel);
		f.add(misokcalLabel);
		f.add(breastnameLabel);
		f.add(breastkcalLabel);
		f.add(breastnameLabel2);
		f.add(breastkcalLabel2);
		f.add(steaknameLabel);
		f.add(steakkcalLabel);
		f.add(saladnameLabel);
		f.add(saladkcalLabel);
		f.add(saladnameLabel2);
		f.add(saladkcalLabel2);
		f.add(mangonameLabel);
		f.add(mangokcalLabel);
		f.add(melonnameLabel);
		f.add(melonkcalLabel);

		f.add(fooddirectbutton);
		f.add(foodsccbutton);

		f.add(whitericebutton1);
		f.add(brownricebutton1);
		f.add(sugarbutton1);
		f.add(saltbutton1);
		f.add(misobutton1);
		f.add(breastbutton1);
		f.add(breastbutton12);
		f.add(steakbutton1);
		f.add(saladbutton1);
		f.add(saladbutton12);
		f.add(mangobutton1);
		f.add(melonbutton1);

		f.setVisible(true);

	}

}