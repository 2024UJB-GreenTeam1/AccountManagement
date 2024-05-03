package HealthCheck;


import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
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


//extends WindowAdapter 
public class HealthCheck extends JFrame {
	private JFrame f;
//	private JTextField tfAt, tfMsg;
	private JPasswordField tfPwd;
	private JButton btnL, btnI, btnP, btnS;
	private InfoDAO dao;
	ArrayList<InfoVo> list;
	private JPanel tab1Panel;
	
						//이미지크기조정
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	
	
	
	
	public HealthCheck() {

		dao = new InfoDAO();
		Font fontT = new Font("SansSerif", Font.PLAIN, 35);
		Font font = new Font("SansSerif", Font.PLAIN, 25);
		f = new JFrame("Login");
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);
		
		tab1Panel = new JPanel();
		JLabel jLabel = new JLabel();
		
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
		imgTest = imageSetSize(imgTest, 145, 145);
		jLabel.setIcon(imgTest);
//		jLabel.setIcon(new ImageIcon(getClass().getResource("../img/logo.jpg")));// bin폴더 넘어가면 안되는듯?
		tab1Panel.add(jLabel);
		tab1Panel.setLocation(10, 20);
		tab1Panel.setSize(150, 150);

		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Point centerPoint = ge.getCenterPoint();
		int leftTopX = centerPoint.x - f.getWidth() / 2;
		int leftTopY = centerPoint.y - f.getHeight() / 2;
		f.setLocation(leftTopX, leftTopY);
		
		JLabel lTitle = new JLabel("<주간분석>");
		lTitle.setLocation(250, 120);
		lTitle.setSize(200, 50);
		lTitle.setText("<월간분석>");

		JLabel lAt = new JLabel("운동시간 : ");
		lAt.setLocation(180, 180);
		lAt.setSize(150, 50);
		
		JLabel lUc = new JLabel("소모cal : ");
		lUc.setLocation(180, 230);
		lUc.setSize(150, 50);

		JLabel lIc = new JLabel("섭취cal : ");
		lIc.setLocation(180, 280);
		lIc.setSize(150, 50);

		JLabel lIw = new JLabel("섭취수분 : ");
		lIw.setLocation(180, 330);
		lIw.setSize(150, 50);
		
		JLabel lBmi = new JLabel("BMI : ");
		lBmi.setLocation(180, 380);
		lBmi.setSize(150, 50);
		
		JLabel lS = new JLabel("평균수면시간 : ");
		lS.setLocation(180, 430);
		lS.setSize(200, 50);
		
		//------------------------------
		JLabel lAtT = new JLabel("운동시간");
		lAtT.setLocation(340, 180);
		lAtT.setSize(150, 50);
		
		JLabel lUcT = new JLabel("소모cal");
		lUcT.setLocation(340, 230);
		lUcT.setSize(150, 50);

		JLabel lIcT = new JLabel("섭취cal");
		lIcT.setLocation(340, 280);
		lIcT.setSize(150, 50);

		JLabel lIwT = new JLabel("섭취수분");
		lIwT.setLocation(340, 330);
		lIwT.setSize(150, 50);
		
		JLabel lBmiT = new JLabel("BMI");
		lBmiT.setLocation(340, 380);
		lBmiT.setSize(150, 50);
		
		JLabel lST = new JLabel("평균수면시간");
		lST.setLocation(340, 430);
		lST.setSize(200, 50);

		lAt.setFont(font);
		lUc.setFont(font);
		lIc.setFont(font);
		lIw.setFont(font);
		lBmi.setFont(font);
		lS.setFont(font);
		lAtT.setFont(font);
		lUcT.setFont(font);
		lIcT.setFont(font);
		lIwT.setFont(font);
		lBmiT.setFont(font);
		lST.setFont(font);
		lTitle.setFont(fontT);
		
		
		
		
		
		
		

//		btnL = new JButton("Login");
//		btnL.setLocation(420, 448);
//		btnL.setSize(80, 110);

		btnI = new JButton("메인페이지이동");
		btnI.setLocation(170, 570);
		btnI.setSize(100, 40);

//		btnP = new JButton("PWD찾기");
//		btnP.setLocation(285, 570);
//		btnP.setSize(100, 40);

		btnS = new JButton("게시판이동");
		btnS.setLocation(400, 570);
		btnS.setSize(100, 40);

		
		btnS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Mframe();								//회원가입열기
			}
		});
		
//		btnL.addActionListener(new ActionListener() {		//로그인
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				String pwd = new String(tfPwd.getPassword());//SWING에서 .getPassword()는 char[]이기때문에 String변환
//				
//				System.out.println(tfId.getText() + " : " + pwd);
//				String id = tfId.getText();							
//
//				list = dao.list(id);
//
//				if (list.size() != 0) {
//					for (int i = 0; i < list.size(); i++) {
//						InfoVo data = (InfoVo) list.get(i);
//						String gid = data.getId();
//						String gpwd = data.getPwd();
//
//						System.out.println(gid + " :: " + gpwd);
//
//						if (tfId.getText().equals(gid) && pwd.equals(gpwd)) {	//성공 메인페이지열기
//							tfMsg.setText("로그인이 성공했습니다.");
//							MainScreen mainscreen = new MainScreen();//
//							
//							mainscreen.excute();
//			                f.setVisible(false); 		//
//						} else {
//							new FailMessage();  		//로그인 실패
//						}
//					}
//				} else {
//					new FailMessage();				
//				}
//
//				for (int i = 0; i < list.size(); i++) {			//이거 왜 중복이냐
//					InfoVo data = (InfoVo) list.get(i);
//					String gid = data.getId();
//					String gpwd = data.getPwd();
//
//					System.out.println(gid + " :: " + gpwd);
//				}
//			}
//		});
		
		btnI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new IdSearch();					//
										//ID찾기열기
			}
		});
		
//		btnP.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				 new PwdSearch();		//PWD찾기열기
//				
//			}
//		});
		
		
		
		
		
		
		
		
		
		
		f.getContentPane().add(tab1Panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.addWindowListener(this);
		f.add(lTitle);
		f.add(lAt);
		f.add(lUc);
		f.add(lIc);
		f.add(lIw);
		f.add(lBmi);
		f.add(lS);
		f.add(lAtT);
		f.add(lUcT);
		f.add(lIcT);
		f.add(lIwT);
		f.add(lBmiT);
		f.add(lST);
		
		
		f.add(btnI);
//		f.add(btnP);
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
		new HealthCheck();

	}
}