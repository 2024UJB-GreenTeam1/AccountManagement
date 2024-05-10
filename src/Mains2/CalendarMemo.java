package Mains2;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		JButton registrationButton = new JButton("리셋");
		
		registrationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comments.setText("");
			}
		});
		
		JButton modificationButton = new JButton("등록");

		f.add(modificationButton);
		
		f.add(comments);
		f.add(registrationButton);
		f.add(modificationButton);
		comments.selectAll();
		f.setVisible(true);

	}

}
