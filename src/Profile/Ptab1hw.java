package Profile;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import login.InfoVo;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Ptab1hw extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	ProfileDAO dao = new ProfileDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ptab1hw frame = new Ptab1hw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ptab1hw() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("키");
		lblNewLabel.setBounds(86, 82, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("몸무게");
		lblNewLabel_1.setBounds(86, 107, 63, 37);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(155, 79, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(155, 115, 116, 21);
		contentPane.add(textField_1);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(283, 79, 69, 57);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(344, 221, 78, 30);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});

		btnNewButton.addActionListener(new ActionListener() {
			// 키 몸무게 수정
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String heightStr = textField.getText();
				String weightStr = textField_1.getText();

				if (heightStr.isEmpty() || weightStr.isEmpty()) {
					new MessageDialog(null, "알림", "키와 몸무게를 모두 입력하세요.");
				} else {
					new MessageDialog(null, "알림", "저장되었습니다");
					int height = Integer.parseInt(heightStr);
					int weight = Integer.parseInt(weightStr);
					dao.updateHW(height, weight);
					dispose();
				}
			}
		});
	}
}
