package Mains1;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalendarMemo {

	public static void main(String[] args) {
		JFrame f = new JFrame("일정관리 입력");
		f.setSize(400, 250);
		f.setLayout(new FlowLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		
		//텍스트 창 생성
		TextArea comments = new TextArea("내용을 입력해주세요.", 10, 50);
		
		//버튼 생성
		JButton registrationButton = new JButton("등록");
		JButton modificationButton = new JButton("수정");
		JButton deleteButton = new JButton("삭제");
		
		f.add(comments);
		f.add(registrationButton);
		f.add(modificationButton);
		f.add(deleteButton);
		comments.selectAll();
		f.setVisible(true);

	}

}
