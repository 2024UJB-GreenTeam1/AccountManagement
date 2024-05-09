package Profile;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//<<<<<<< HEAD
import login.InfoVo;
//=======
//import Member.Mframe;
//>>>>>>> branch 'master' of https://github.com/2024UJB-GreenTeam1/AccountManagement.git
import login.LoginFrame;

public class Pdel {
	private JFrame f;
	private JLabel ldelete;
	private JButton Btok, Btno;
	private ProfileDAO dao;
	private DTO user;
	
	Font font = new Font("SansSerif", Font.PLAIN, 15);

	public Pdel() {
		dao = new ProfileDAO();
				
		f = new JFrame("회원탈퇴");
		f.setBounds(100, 100, 450, 300);
		f.setLayout(null);

		ldelete = new JLabel("탈퇴 하겠습니까?");
		ldelete.setBounds(169, 85, 102, 23);

		Btok = new JButton("확인");
		Btok.setBounds(109, 134, 97, 23);
		Btok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dao.delete(user);
				new LoginFrame();
				f.dispose();
			}
		});
		
		
		Btno = new JButton("취소");
		Btno.setBounds(229, 134, 97, 23);
		Btno.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				f.dispose();
			}
		});
		
		f.add(ldelete);
		f.add(Btno);
		f.add(Btok);
		
		f.setFont(font);
		f.setVisible(true);	
		
	}
	public static void main(String[] args) {
		new Pdel();
	}

}
