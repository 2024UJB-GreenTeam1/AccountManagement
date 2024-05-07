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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import IDsearch.IdSearch;
import Member.Mframe;

//extends WindowAdapter 
public class HealthCheck extends JFrame {	//Label->textField로 바꿔야함
	private JFrame f;
//	private JTextField tfAt, tfMsg;
	private JPasswordField tfPwd;
	private JButton btnL, btnI, btnP, btnS;
	private HealthDAO dao;					
	ArrayList<HealthVo> list;						//<HealthVo>list2
	private JPanel tab1Panel;
	
						//이미지크기조절기능
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage();  //ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg); 
		return xyimg;
	}
	
	
	
	
	public HealthCheck() {
		
		dao = new HealthDAO();

		
		

		
		
		
		Font fontT = new Font("SansSerif", Font.PLAIN, 35);
		Font font = new Font("SansSerif", Font.PLAIN, 25);
		f = new JFrame("HealthCheck");
		f.setSize(700, 700);
		f.getContentPane().setLayout(null);
		
		tab1Panel = new JPanel();
		JLabel jLabel = new JLabel();
		//이미지크기조절&삽입
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
		
		
		JComboBox<String> ctl20 = new JComboBox<String>();
		ctl20.setFont(new Font("Serif",Font.BOLD,30));
		ctl20.addItem("<주간분석>");
		ctl20.addItem("<월간분석>");
		ctl20.setLocation(250, 120);
		ctl20.setSize(200, 50);


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
		
		
//		LoginFrame login = new LoginFrame();
//		HealthVo data = new HealthVo();
		
//		String id = list.getId();
//		System.out.println(id);
		
		
//		public void actionPerformed(ActionEvent e) {
//		    JComboBox comboBox=(JComboBox) e.getSource();
//		    String s1=(String) comboBox.getSelectedItem();
//		    String s2=(String) comboBox.getActionCommand();
//
//		   System.out.println(s1);
//		   System.out.println(s2);
//		 }
		list = dao.list();
		if (list.size() != 0) {
			for (int i = 0; i < list.size(); i++) {
				HealthVo data = (HealthVo) list.get(i);
				String gid = data.getId();
				 String DIDATE = data.getDIDATE();
				 String INTAKEC = Integer.toString(data.getINTAKEC());
				 String USEUPC = Integer.toString(data.getUSEUPC());
				 String SLEEP = Integer.toString(data.getSLEEP());
				 String WEIGHT = Integer.toString(data.getWEIGHT());
				 String WATER = Integer.toString(data.getWATER());
				  //HealthDAO list에 InfoDAO gid넣어주기?
				
				//프린트테스트OK
				System.out.println(gid);
				
//				if (name.equals(gname) && pwd.equals(gpwd) && email.equals(gemail)) {
//					tfNotice.setText(" 당신의 ID는  :  " + gid + "  입니다."); // 아이디 텍스트필드에 표시
//
//				} else {
//
//					tfNotice.setText("이름, 이메일, 비밀번호를 다시확인하여 주세요.");
//				}
				
				ctl20.addActionListener (new ActionListener () {
				    public void actionPerformed(ActionEvent e) {
				    	//case1 주간 평균
						if (ctl20.getSelectedItem().toString()=="<주간분석>") {	
							dispose();
//							JLabel lAtT = new JLabel("운동시간");
							JLabel lAtT = new JLabel(USEUPC);
							lAtT.setLocation(340, 180);
							lAtT.setSize(150, 50);
							
//							JLabel lUcT = new JLabel("소모cal");
							JLabel lUcT = new JLabel(USEUPC);
							lUcT.setLocation(340, 230);
							lUcT.setSize(150, 50);

//							JLabel lIcT = new JLabel("섭취cal");
							JLabel lIcT = new JLabel(INTAKEC);
							lIcT.setLocation(340, 280);
							lIcT.setSize(150, 50);

//							JLabel lIwT = new JLabel("섭취수분");
							JLabel lIwT = new JLabel(WATER);
							lIwT.setLocation(340, 330);
							lIwT.setSize(150, 50);
							
//							JLabel lBmiT = new JLabel("BMI");
							JLabel lBmiT = new JLabel(WEIGHT);
							lBmiT.setLocation(340, 380);
							lBmiT.setSize(150, 50);
							
//							JLabel lST = new JLabel("평균수면시간");
							JLabel lST = new JLabel(SLEEP);
							lST.setLocation(340, 430);
							lST.setSize(200, 50);

							lAtT.setFont(font);
							lUcT.setFont(font);
							lIcT.setFont(font);
							lIwT.setFont(font);
							lBmiT.setFont(font);
							lST.setFont(font);
							
							
							f.add(lAtT);
							f.add(lUcT);
							f.add(lIcT);
							f.add(lIwT);
							f.add(lBmiT);
							f.add(lST);
							
							
							f.setVisible(true);

						} else {
//							dispose();
							//case2 월간평균
							
//							new HealthCheck();
							
//							JLabel lAtT = new JLabel("운동시간");
							JLabel lAtT = new JLabel("1");
							lAtT.setLocation(340, 180);
							lAtT.setSize(150, 50);
//							lAtT.setText("2");
							
//							JLabel lUcT = new JLabel("소모cal");
							JLabel lUcT = new JLabel("2");
							lUcT.setLocation(340, 230);
							lUcT.setSize(150, 50);

//							JLabel lIcT = new JLabel("섭취cal");
							JLabel lIcT = new JLabel("3");
							lIcT.setLocation(340, 280);
							lIcT.setSize(150, 50);

//							JLabel lIwT = new JLabel("섭취수분");
							JLabel lIwT = new JLabel("4");
							lIwT.setLocation(340, 330);
							lIwT.setSize(150, 50);
							
//							JLabel lBmiT = new JLabel("BMI");
							JLabel lBmiT = new JLabel("5");
							lBmiT.setLocation(340, 380);
							lBmiT.setSize(150, 50);
							
//							JLabel lST = new JLabel("평균수면시간");
							JLabel lST = new JLabel("6");
							lST.setLocation(340, 430);
							lST.setSize(200, 50);

							lAtT.setFont(font);
							lUcT.setFont(font);
							lIcT.setFont(font);
							lIwT.setFont(font);
							lBmiT.setFont(font);
							lST.setFont(font);
							
							
							f.add(lAtT);
							f.add(lUcT);
							f.add(lIcT);
							f.add(lIwT);
							f.add(lBmiT);
							f.add(lST);
							
							
							f.setVisible(true);
						}
				    }
				});
				
				
			
				
			}
		}
		
		
		
		
		
//		lTitle.setFont(fontT);
		
		
		
		
		
		
		

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
		
			
		btnI.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 new IdSearch();					//
										//메인페이지열기
			}
		});
		

		
		
		
		lAt.setFont(font);
		lUc.setFont(font);
		lIc.setFont(font);
		lIw.setFont(font);
		lBmi.setFont(font);
		lS.setFont(font);

		
		
		
		
		
		f.getContentPane().add(tab1Panel);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.addWindowListener(this);
//		f.add(lTitle);
		f.add(ctl20);
		f.add(lAt);
		f.add(lUc);
		f.add(lIc);
		f.add(lIw);
		f.add(lBmi);
		f.add(lS);
		
		
		
		f.add(btnI);
//		f.add(btnP);
		f.add(btnS);
//		f.add(lb1);

		f.setVisible(true);
	}

	
	
	public static void main(String[] args) {
		new HealthCheck();

	}
}