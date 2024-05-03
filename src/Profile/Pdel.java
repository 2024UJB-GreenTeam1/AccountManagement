package Profile;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Pdel extends JFrame {

	private JPanel contentPane;
	private ProfileDAO dao;
	private String userId;
	
	public Pdel(String userId) {
		this.userId = userId;
		this.dao = new ProfileDAO();
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pdel frame = new Pdel();
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
	public Pdel() {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("탈퇴 하겠습니까?");
		lblNewLabel.setBounds(169, 85, 102, 23);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(109, 134, 97, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			// db 자료 삭제 및 로그인 화면 띄우기
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dao.delete(userId);
				dispose();
			}

		});

		JButton btnNewButton_1 = new JButton("취소");
		btnNewButton_1.setBounds(229, 134, 97, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}

		});
	}
}
