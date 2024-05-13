package Mains1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarMain extends JPanel implements ActionListener, ItemListener {
   Font fnt = new Font("맑은 고딕", Font.BOLD, 20); // 기본 폰트 설정

   // UI 컴포넌트 선언
   JPanel selectPane = new JPanel(); // 상단의 선택 패널
   JButton prevBtn = new JButton("◀"), nextBtn = new JButton("▶"); // 이전, 다음 버튼
   JComboBox<Integer> yearCombo = new JComboBox<>(), monthCombo = new JComboBox<>(); // 연도, 월 선택 콤보 박스
   JLabel yearLabel = new JLabel("년"), monthLabel = new JLabel("월"); // 연도, 월 라벨
   JPanel centerPane = new JPanel(new BorderLayout()), titlePane = new JPanel(new GridLayout(1, 7)); // 중앙 패널 및 요일 표시
   JLabel lblNewLabel = new JLabel("");
                                                                              // 패널
   
   JPanel dayPane = new JPanel(new GridLayout(0, 7)); // 날짜를 표시할 패널
   String[] title = { "일", "월", "화", "수", "목", "금", "토" }; // 요일 배열

   Calendar date; // 캘린더 객체
   int year, month; // 선택된 연도 및 월

   public CalendarMain() {
      setLayout(new BorderLayout());
      date = Calendar.getInstance(); // 현재 날짜와 시간을 가져오기
      year = date.get(Calendar.YEAR); // 현재 연도
      month = date.get(Calendar.MONTH) + 1; // 현재 월 (0부터 시작하므로 1 추가)

      setupUI(); // UI 설정
      setYear(); // 연도 설정
      setMonth(); // 월 설정
      setCalendarTitle(); // 요일 헤더 설정
      setDay(); // 날짜 버튼 설정

      yearCombo.addItemListener(this); // 콤보 박스 이벤트 리스너 등록
      monthCombo.addItemListener(this);
      prevBtn.addActionListener(this); // 버튼 이벤트 리스너 등록
      nextBtn.addActionListener(this);
   }

   private void setupUI() {
       selectPane.setBackground(new Color(100, 150, 200)); // 선택 패널 배경색 설정
       selectPane.setLayout(new FlowLayout(FlowLayout.CENTER)); // 가운데 정렬로 레이아웃 설정

//       setupJLabel(lblNewLabel); // lblNewLabel 설정 및 추가
       setupButton(prevBtn); // '이전' 버튼 추가
       setupComboBox(yearCombo, yearLabel); // '연도' 콤보박스와 라벨 추가
       setupComboBox(monthCombo, monthLabel); // '월' 콤보박스와 라벨 추가
       setupButton(nextBtn); // '다음' 버튼 추가

       add(BorderLayout.NORTH, selectPane); // 프레임 상단에 선택 패널 추가

       centerPane.add(BorderLayout.NORTH, titlePane); // 중앙 패널 상단에 요일 표시 패널 추가
       centerPane.add(dayPane); // 중앙 패널에 날짜 패널 추가
       add(centerPane); // 프레임에 중앙 패널 추가
   }
   
   private void setupButton(JButton btn) {
       selectPane.add(lblNewLabel);
       selectPane.add(btn); // 버튼 추가
       btn.setFont(fnt); // 버튼 폰트 설정
   }
   
   private void setupComboBox(JComboBox<Integer> combo, JLabel label) {
       selectPane.add(combo); // 콤보박스 추가
       combo.setFont(fnt); // 콤보박스 폰트 설정
       selectPane.add(label); // 라벨 추가
       label.setFont(fnt); // 라벨 폰트 설정
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == prevBtn) {
         prevMonth(); // 이전 달로 변경
      } else if (ae.getSource() == nextBtn) {
         nextMonth(); // 다음 달로 변경
      }
   }

   public void nextMonth() {
      if (month == 12) { // 12월이면 다음 해의 1월로 변경
         year++;
         month = 1;
      } else { // 그 외의 경우 다음 월로 변경
         month++;
      }
      setDayReset(); // 날짜 재설정
   }

   public void prevMonth() {
      if (month == 1) { // 1월이면 전년의 12월로 변경
         year--;
         month = 12;
      } else { // 그 외의 경우 이전 월로 변경
         month--;
      }
      setDayReset(); // 날짜 재설정
   }

   public void itemStateChanged(ItemEvent ie) {
      year = (int) yearCombo.getSelectedItem(); // 선택된 연도 업데이트
      month = (int) monthCombo.getSelectedItem(); // 선택된 월 업데이트
      setDayReset(); // 날짜 재설정
   }

   private void setDayReset() {
      yearCombo.removeItemListener(this); // 이벤트 리스너 일시 해제
      monthCombo.removeItemListener(this);
      yearCombo.setSelectedItem(year); // 콤보 박스 선택 아이템 설정
      monthCombo.setSelectedItem(month);
      dayPane.setVisible(false); // 날짜 패널 숨김
      dayPane.removeAll(); // 날짜 패널 초기화
      setDay(); // 날짜 다시 설정
      dayPane.setVisible(true); // 날짜 패널 표시
      yearCombo.addItemListener(this); // 이벤트 리스너 재등록
      monthCombo.addItemListener(this);
   }

   public void setDay() {
       date.set(year, month - 1, 1);
       int week = date.get(Calendar.DAY_OF_WEEK);
       int lastDay = date.getActualMaximum(Calendar.DATE);
       for (int s = 1; s < week; s++) {
           dayPane.add(new JLabel(" "));
       }
       for (int day = 1; day <= lastDay; day++) {
           JButton btn = new JButton(String.valueOf(day));
           btn.setFont(fnt);
           btn.setHorizontalAlignment(JButton.CENTER);
           date.set(Calendar.DATE, day);
           int w = date.get(Calendar.DAY_OF_WEEK);
           if (w == 1) btn.setForeground(Color.RED);
           if (w == 7) btn.setForeground(Color.BLUE);
           btn.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
            	   CalendarMemo memo = new CalendarMemo();
                   memo.excute(); // CalendarMemo 창을 표시
               }
           });
           dayPane.add(btn);
       }
   }

   public void setYear() {
      for (int i = year - 50; i < year + 20; i++) {
         yearCombo.addItem(i); // 연도 콤보 박스에 연도 추가
      }
      yearCombo.setSelectedItem(year); // 현재 연도 선택
   }

   public void setMonth() {
      for (int i = 1; i <= 12; i++) {
         monthCombo.addItem(i); // 월 콤보 박스에 월 추가
      }
      monthCombo.setSelectedItem(month); // 현재 월 선택
   }

   public void setCalendarTitle() {
      for (String day : title) {
         JLabel lbl = new JLabel(day, JLabel.LEFT);
         lbl.setFont(fnt);
         if (day.equals("일"))
            lbl.setForeground(Color.RED); // 일요일은 빨간색
         if (day.equals("토"))
            lbl.setForeground(Color.BLUE); // 토요일은 파란색
         titlePane.add(lbl); // 요일 라벨을 요일 표시 패널에 추가
      }
   }
//달력이 Jframe 이라 이걸로 연결해줬음
   public static void displayCalendar() {
       JFrame frame = new JFrame("달력");
       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       frame.add(new CalendarMain());
       frame.pack();
       frame.setSize(800, 800);  // 적절한 크기로 설정
       frame.setLocationRelativeTo(null);  // 화면 중앙에 위치
       frame.setVisible(true);  // 프레임을 화면에 표시
   }
}
