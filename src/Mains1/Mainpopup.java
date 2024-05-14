package Mains1;

//수정본
import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Mainpopup {

   private static double totalCalories = 0; // 전역변수로 칼로리를 누적해서 관리해줌
   private static double totalFoodCalories = 0; // 마찬가지임
	// 이미지크기조절셋업
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}
	
   // 프레임 생성
   public void excute() {
      JFrame f = new JFrame("메인페이지 팝업");
      f.setSize(800, 800);
      f.setLayout(null);

      // 중앙배치
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension screenSize = tk.getScreenSize();
      f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);

      // 글씨체
      Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
      Font font2 = new Font("맑은 고딕", Font.BOLD, 40);
      // 로고 객체 생성
      JLabel logo;
      // 로고 이미지 생성
  	ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
	imgTest = imageSetSize(imgTest, 79, 79);
      logo = new JLabel(imgTest);
      // 로고 이미지 크기 및 위치
      logo.setSize(80, 80);
      logo.setLocation(60, 60);

      // 라벨 생성
      Label todayLabel = new Label("Today");
      todayLabel.setFont(font2);

      todayLabel.setSize(250, 70);
      todayLabel.setLocation(350, 130);

      Label referenceLabel = new Label("※입력된 값은 나의건강일지로 이동합니다.");
      referenceLabel.setFont(font1);

      referenceLabel.setSize(500, 50);
      referenceLabel.setLocation(190, 530);

      Label todaydateLabel = new Label("오늘 날짜는");
      Label todaydateLabel2 = new Label("입니다.");
      todaydateLabel.setFont(font1);
      todaydateLabel2.setFont(font1);

      todaydateLabel.setSize(130, 60);
      todaydateLabel.setLocation(220, 230);
      todaydateLabel2.setSize(100, 50);
      todaydateLabel2.setLocation(500, 235);

      Label todayweightLabel = new Label("오늘 나의 몸무게는");
      Label todayweightLabel2 = new Label("입니다.");
      todayweightLabel.setFont(font1);
      todayweightLabel2.setFont(font1);

      todayweightLabel.setSize(180, 50);
      todayweightLabel.setLocation(190, 290);
      todayweightLabel2.setSize(100, 50);
      todayweightLabel2.setLocation(540, 290);

      Label todayHealthLabel = new Label("오늘 나의 운동 소비 칼로리는");
      Label todayHealthLabel2 = new Label("입니다.");
      todayHealthLabel.setFont(font1);
      todayHealthLabel2.setFont(font1);

      todayHealthLabel.setSize(280, 50);
      todayHealthLabel.setLocation(50, 340);
      todayHealthLabel2.setSize(100, 50);
      todayHealthLabel2.setLocation(680, 335);

      Label todayfoodLabel = new Label("오늘 나의 음식 칼로리는");
      Label todayfoodLabel2 = new Label("입니다.");
      todayfoodLabel.setFont(font1);
      todayfoodLabel2.setFont(font1);

      todayfoodLabel.setSize(245, 50);
      todayfoodLabel.setLocation(95, 380);
      todayfoodLabel2.setSize(100, 50);
      todayfoodLabel2.setLocation(680, 380);

      Label todaysleepLabel = new Label("오늘 나의 수면시간은");
      Label todaysleepLabel2 = new Label("입니다.");
      todaysleepLabel.setFont(font1);
      todaysleepLabel2.setFont(font1);

      todaysleepLabel.setSize(200, 50);
      todaysleepLabel.setLocation(140, 420);
      todaysleepLabel2.setSize(200, 50);
      todaysleepLabel2.setLocation(680, 420);

      Label todaywaterLabel = new Label("오늘 나의 수분섭취는");
      Label todaywaterLabel2 = new Label("L 입니다.");
      todaywaterLabel.setFont(font1);
      todaywaterLabel2.setFont(font1);

      todaywaterLabel.setSize(200, 50);
      todaywaterLabel.setLocation(170, 460);
      todaywaterLabel2.setSize(200, 50);
      todaywaterLabel2.setLocation(540, 460);

      // 텍스트 필드 생성
      TextField todaydateText = new TextField(15);
      todaydateText.setFont(font1);

      todaydateText.setSize(130, 30);
      todaydateText.setLocation(355, 245);
      // 날짜 가져오기
      LocalDate today = LocalDate.now(); 
      String formattedDate = today.toString(); 
      todaydateText.setText(formattedDate); 
      TextField todayweightText = new TextField(10);
      todayweightText.setFont(font1);

      todayweightText.setSize(100, 30);
      todayweightText.setLocation(380, 300);

      TextField todayHealthText = new TextField(10);
      todayHealthText.setFont(font1);

      todayHealthText.setSize(80, 30);
      todayHealthText.setLocation(590, 345);

      TextField todayfoodText = new TextField(10);
      todayfoodText.setFont(font1);

      todayfoodText.setSize(80, 30);
      todayfoodText.setLocation(590, 390);

      TextField todaysleepText = new TextField(10);
      todaysleepText.setFont(font1);

      todaysleepText.setSize(80, 30);
      todaysleepText.setLocation(590, 430);

      TextField todaywaterText = new TextField(10);
      todaywaterText.setFont(font1);

      todaywaterText.setSize(80, 30);
      todaywaterText.setLocation(390, 470);

      // choice

      Choice exercisechoice = new Choice();
      exercisechoice.add("운동종류");
      exercisechoice.add("걷기");
      exercisechoice.add("빨리걷기");
      exercisechoice.add("달리기");
      exercisechoice.add("계단오르기");
      exercisechoice.add("자전거타기");
      exercisechoice.add("줄넘기");
      exercisechoice.add("등산");

      exercisechoice.setSize(100, 25);
      exercisechoice.setLocation(340, 350);

      Choice exercisechoice2 = new Choice();
      exercisechoice2.add("운동시간");
      exercisechoice2.add("15분");
      exercisechoice2.add("30분");
      exercisechoice2.add("45분");
      exercisechoice2.add("60분");

      exercisechoice2.setSize(80, 25);
      exercisechoice2.setLocation(450, 350);

      // food choice

      Choice foodchoice = new Choice();
      foodchoice.add("음식명");
      foodchoice.add("백미");
      foodchoice.add("현미");
      foodchoice.add("설탕");
      foodchoice.add("소금");
      foodchoice.add("미소된장국");
      foodchoice.add("닭가슴살");
      foodchoice.add("야채샐러드");

      foodchoice.setSize(100, 25);
      foodchoice.setLocation(340, 390);

      Choice foodchoice2 = new Choice();
      foodchoice2.add("1회제공량");
      foodchoice2.add("100g");
      foodchoice2.add("200g");
      foodchoice2.add("300g");

      foodchoice2.setSize(80, 25);
      foodchoice2.setLocation(450, 390);

      // 잠 초이스

      Choice sleepchoice = new Choice();
      sleepchoice.add("취침시간");
      Choice sleepchoice2 = new Choice();
      sleepchoice2.add("기상시간");

      for (int i = 1; i <= 24; i++) {
         String hour = String.format("%02d시", i);
         sleepchoice.add(hour);
         sleepchoice2.add(hour);
      }
      sleepchoice.setSize(80, 25);
      sleepchoice.setLocation(360, 430);
      sleepchoice2.setSize(80, 25);
      sleepchoice2.setLocation(450, 430);

      // 버튼

      Button scc = new Button("완료");
		scc.setFont(font1);
		scc.setSize(80, 60);
		scc.setLocation(430, 600);
		scc.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int weight = Integer.parseInt(todayweightText.getText());
		            int useupc = Integer.parseInt(todayHealthText.getText());
		            int intakec = Integer.parseInt(todayfoodText.getText());
		            int sleep = Integer.parseInt(todaysleepText.getText());
		            int water = Integer.parseInt(todaywaterText.getText());

		            MainpopupDAO dao = new MainpopupDAO();
		            dao.insertDailyInput(weight, useupc, intakec, sleep, water);
		            JOptionPane.showMessageDialog(f, "데이터가 성공적으로 저장되었습니다.");
		            
		            f.setVisible(false);
		            Mainscreen mainScreen = new Mainscreen();
		            mainScreen.setVisible(true);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(f, "입력 형식이 올바르지 않습니다. 숫자를 입력하세요.");
		        } catch (Exception ex) {
		            JOptionPane.showMessageDialog(f, "데이터 저장 중 오류가 발생했습니다: " + ex.getMessage());
		        }
		    }
		});

      Button resetButton = new Button("리셋");
      resetButton.setFont(font1);
      resetButton.setSize(80, 60);
      resetButton.setLocation(330, 600);

      resetButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            todayweightText.setText(""); // TextArea 내용을 비웁니다.
            todayHealthText.setText("");
            todayfoodText.setText("");
            todaysleepText.setText("");
            todaywaterText.setText("");
         }
      });

      Button calculateWeightButton = new Button("입력");
      calculateWeightButton.setSize(50, 30);
      calculateWeightButton.setLocation(485, 300);
      calculateWeightButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               double weight = Double.parseDouble(todayweightText.getText());
            } catch (NumberFormatException ex) {
               todayweightText.setText("Error!");
            }
         }
      });

      Button calculateExerciseButton = new Button("입력");
      calculateExerciseButton.setSize(50, 30);
      calculateExerciseButton.setLocation(535, 345);
      calculateExerciseButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               double weight = Double.parseDouble(todayweightText.getText());
               double factor = 0;
               double time = Double.parseDouble(exercisechoice2.getSelectedItem().replace("분", "")) / 15;

               switch (exercisechoice.getSelectedItem()) {
               case "걷기":
                  factor = 0.9;
                  break;
               case "빨리걷기":
                  factor = 1.2;
                  break;
               case "달리기":
                  factor = 2.0;
                  break;
               case "계단오르기":
                  factor = 1.6;
                  break;
               case "자전거타기":
                  factor = 1.5;
                  break;
               case "줄넘기":
                  factor = 2.6;
                  break;
               case "등산":
                  factor = 1.5;
                  break;
               }

               totalCalories += weight * factor * time; // 기존 칼로리에 추가
               todayHealthText.setText(String.format("%.0f", totalCalories)); // 텍스트 필드에 누적 칼로리 표시
            } catch (NumberFormatException ex) {
               todayweightText.setText("Error!");
            }
         }
      });

      Button calculateFoodButton = new Button("입력");
      calculateFoodButton.setSize(50, 30);
      calculateFoodButton.setLocation(535, 390);
      calculateFoodButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            double caloriesPer100g = 0;
            switch (foodchoice.getSelectedItem()) {
            case "백미":
               caloriesPer100g = 129;
               break;
            case "현미":
               caloriesPer100g = 110;
               break;
            case "설탕":
               caloriesPer100g = 387;
               break;
            case "소금":
               caloriesPer100g = 0;
               break;
            case "미소된장국":
               caloriesPer100g = 59;
               break;
            case "닭가슴살":
               caloriesPer100g = 165;
               break;
            case "야채샐러드":
               caloriesPer100g = 18;
               break;
            }
            int quantity = Integer.parseInt(foodchoice2.getSelectedItem().replace("g", ""));
            totalFoodCalories += (caloriesPer100g * quantity / 100);
            todayfoodText.setText(String.format("%.0f", totalFoodCalories));
         }
      });

      Button calculateSleepButton = new Button("입력");
      calculateSleepButton.setSize(50, 30);
      calculateSleepButton.setLocation(535, 430);
      calculateSleepButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            int startHour = Integer.parseInt(sleepchoice.getSelectedItem().replace("시", ""));
            int endHour = Integer.parseInt(sleepchoice2.getSelectedItem().replace("시", ""));
            int sleepHours = (endHour - startHour);
            if (sleepHours < 0) {
               sleepHours += 24; // 다음 날까지 수면이 이어지는 경우
            }
            todaysleepText.setText(sleepHours + "");
         }
      });

      Button calculateWaterButton = new Button("입력");
      calculateWaterButton.setSize(50, 30);
      calculateWaterButton.setLocation(475, 470);

      calculateWaterButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            try {
               double water = Double.parseDouble(todaywaterText.getText());
            } catch (NumberFormatException ex) {
               todaywaterText.setText("Error!");
            }
         }
      });


      

      f.add(logo);
      f.add(todayLabel);
      f.add(referenceLabel);
      f.add(todaydateLabel);
      f.add(todaydateLabel2);
      f.add(todayHealthLabel);
      f.add(todayHealthLabel2);
      f.add(todayfoodLabel);
      f.add(todayfoodLabel2);
      f.add(todaysleepLabel);
      f.add(todaysleepLabel2);
      f.add(todayweightLabel);
      f.add(todayweightLabel2);
      f.add(todaywaterLabel);
      f.add(todaywaterLabel2);

      f.add(scc);
      f.add(resetButton);
      f.add(calculateFoodButton);
      f.add(calculateSleepButton);
      f.add(calculateExerciseButton);
      f.add(calculateWaterButton);
      f.add(calculateWeightButton);

      f.add(todaydateText);
      f.add(todayHealthText);
      f.add(todayfoodText);
      f.add(todaysleepText);
      f.add(todayweightText);
      f.add(todaywaterText);

      f.add(exercisechoice);
      f.add(exercisechoice2);
      f.add(foodchoice);
      f.add(foodchoice2);
      f.add(sleepchoice);
      f.add(sleepchoice2);

      f.setVisible(true);
      
		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
		    public void windowClosing(WindowEvent evt) {
				JOptionPane.showMessageDialog(f, 
						  "일일입력을 완료해주십시오", "ErrorMsg", JOptionPane.ERROR_MESSAGE);
		    }
		});
		
	


   }

}
