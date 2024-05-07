package login;

import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import IDsearch.IdSearch;
import IDsearch.PwdSearch;
import Mains1.Mainscreen;
import Member.Mframe;

//extends WindowAdapter 
public class LoginFrame extends JFrame {
	private JFrame f;
	private JTextField tfId, tfMsg;
	private JPasswordField tfPwd;
	private JButton btnL, btnI, btnP, btnS;
	private InfoDAO dao;
	ArrayList<InfoVo> list;
	private JPanel tab1Panel;

	public LoginFrame() {

		dao = new InfoDAO();

		f = new JFrame("Login");
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);

		tab1Panel = new JPanel();
		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));// bin폴더 넘어가면 안되는듯?
		tab1Panel.add(jLabel);
		tab1Panel.setLocation(140, 10);
		tab1Panel.setSize(400, 400);
		
		//화면중앙배치
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);

		JLabel lId = new JLabel("ID");
		lId.setLocation(170, 440);
		lId.setSize(50, 50);
		
		
		JLabel lPwd = new JLabel("PWD");
		lPwd.setLocation(170, 480);
		lPwd.setSize(50, 50);

		tfId = new JTextField(10);
		tfId.setLocation(220, 450);
		tfId.setSize(200, 30);
		String id = tfId.getText();							//
		
		tfPwd = new JPasswordField(10);
//		tfPwd.setEchoChar('*');
		tfPwd.setLocation(220, 490);
		tfPwd.setSize(200, 30);

		tfMsg = new JTextField(10);
		tfMsg.setLocation(170, 530);
		tfMsg.setSize(250, 30);

		btnL = new JButton("Login");
		btnL.setLocation(420, 448);
		btnL.setSize(80, 110);

		btnI = new JButton("ID찾기");
		btnI.setLocation(170, 570);
		btnI.setSize(100, 40);

		btnP = new JButton("PWD찾기");
		btnP.setLocation(285, 570);
		btnP.setSize(100, 40);

		btnS = new JButton("SIGN IN");
		btnS.setLocation(400, 570);
		btnS.setSize(100, 40);

		
		btnS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Mframe();								//회원가입열기
			}
		});
		
		btnL.addActionListener(new ActionListener() {		//로그인
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String pwd = new String(tfPwd.getPassword());//SWING에서 .getPassword()는 char[]이기때문에 String변환
				
				System.out.println(tfId.getText() + " : " + pwd);
				String id = tfId.getText();							

				list = dao.list(id);

				if (list.size() != 0) {
					for (int i = 0; i < list.size(); i++) {
						InfoVo data = (InfoVo) list.get(i);
						String gid = data.getId();
						String gpwd = data.getPwd();

						System.out.println(gid + " :: " + gpwd);

						if (tfId.getText().equals(gid) && pwd.equals(gpwd)) {	//성공 메인페이지열기
							tfMsg.setText("로그인이 성공했습니다.");
							Mainscreen mainscreen = new Mainscreen();//
							
							mainscreen.excute();
			                f.setVisible(false); 		//
						} else {
							new FailMessage();  		//로그인 실패
						}
					}
				} else {
					new FailMessage();				
				}

				for (int i = 0; i < list.size(); i++) {			//이거 왜 중복이냐
					InfoVo data = (InfoVo) list.get(i);
					String gid = data.getId();
					String gpwd = data.getPwd();

					System.out.println(gid + " :: " + gpwd);
				}
			}
		});
		
		btnI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new IdSearch();					//
										//ID찾기열기
			}
		});
		
		btnP.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new PwdSearch();		//PWD찾기열기
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		f.getContentPane().add(tab1Panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.addWindowListener(this);
		f.add(lId);
		f.add(tfId);
		f.add(lPwd);
		f.add(tfPwd);
		f.add(tfMsg);
		f.add(btnL);
		f.add(btnI);
		f.add(btnP);
		f.add(btnS);
//		f.add(lb1);

		f.setVisible(true);
	}

	
	
	
	
	public class FailMessage extends JFrame {
		public FailMessage() {
			setSize(300, 200);
			setVisible(true);
			getContentPane().setLayout(null);

			JLabel lFail = new JLabel("로그인이 실패했습니다.");
			lFail.setLocation(40, 10);
			lFail.setSize(200, 50);

			JLabel lFail2 = new JLabel("ID혹은 PWD를 다시 확인하여 주십시오.");
			lFail2.setLocation(40, 30);
			lFail2.setSize(290, 50);

			JButton btnE = new JButton("확인");
			btnE.setLocation(95, 80);
			btnE.setSize(100, 40);

			btnE.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Point centerPoint = ge.getCenterPoint();
			int leftTopX = centerPoint.x - getWidth() / 2;
			int leftTopY = centerPoint.y - getHeight() / 2;
			setLocation(leftTopX, leftTopY);

			this.add(lFail);
			this.add(lFail2);
			this.add(btnE);
			
		}

	}

	
	public static void main(String[] args) {
		new LoginFrame();

	}
}
