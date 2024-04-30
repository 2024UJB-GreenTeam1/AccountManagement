package Post;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class correct extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	ArrayList<DTO> list;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					correct window = new correct();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public correct() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		String pw;
		
		
		Scanner sc = new Scanner(System.in);
		JButton btnNewButton_3;
		ImageIcon img = new ImageIcon("./button_image/image_rogo.jpg");
		frame = new JFrame();
		frame.setTitle("게시글 수정");
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("취소");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(647, 703, 102, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(526, 703, 109, 33);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
//		JButton btnNewButton_2 = new JButton("게시판으로 가기");
//		btnNewButton_2.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnNewButton_2.setBounds(609, 23, 143, 33);
//		frame.getContentPane().add(btnNewButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(51, 168, 698, 504);
		frame.getContentPane().add(textArea);
		
		textField = new JTextField();
		textField.setBounds(93, 137, 417, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("작성자 :");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 16));
		lblNewLabel.setBounds(548, 137, 201, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("제목 :");
		lblNewLabel_1.setBounds(51, 140, 45, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		btnNewButton_3 = new JButton(img);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBounds(51, 28, 180, 79);
		frame.getContentPane().add(btnNewButton_3);
	
		
		textField_1 = new JTextField();
		textField_1.setBounds(157, 703, 189, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password 확인 :");
		pw = sc.next();
		lblNewLabel_2.setBounds(51, 703, 94, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton_4 = new JButton("확인");
		btnNewButton_4.setBounds(357, 703, 97, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String pw = sc.next();
				for(;;) {
					if(!pw.equals("123")) { // db에서 로그인 한 비밀번호 확인 후 수정 
						System.out.print("비밀번호를 확인해주세요.");
					} else {
						System.out.print("확인되었습니다.");
						btnNewButton_1.setEnabled(true);
						break;
			}
		}
	}
	});
}
}
