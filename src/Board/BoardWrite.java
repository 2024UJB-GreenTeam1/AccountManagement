package Board;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class BoardWrite extends BoardCommand implements WindowListener, ActionListener {
<<<<<<< HEAD
	private JTextArea maincontent2;
	private JFrame f;
	private JLabel title;
	private JPanel maindp, maindptitle2, content2;
	private JButton write, cancle, maincontent;
	private JTextField maindptitlecontent;

	public BoardWrite() {
		Font font = new Font("맑은 고딕", Font.BOLD, 50);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
=======
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		f = new JFrame("새글작성");
		f.setSize(800, 800);
		f.setLocationRelativeTo(null);
		f.getContentPane().setLayout(null);
		f.addWindowListener(this);
=======
   private JTextArea maincontent2;
   private JFrame f;
   private JLabel title;
   private JPanel maindp, maindptitle2, content2;
   private JButton write, cancle, maincontent;
   private JTextField maindptitlecontent;
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		JButton write = new JButton("작성");
		write.setBounds(12, 584, 102, 40);
		write.addActionListener(this);
=======
   public BoardWrite() {
      Font font = new Font("맑은 고딕", Font.BOLD, 50);
      Font font2 = new Font("맑은 고딕", Font.BOLD, 20);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		JButton cancle = new JButton("취소");
		cancle.setBounds(670, 584, 102, 40);
		cancle.addActionListener(this);
=======
      f = new JFrame("새글작성");
      f.setSize(800, 800);
      f.setLocationRelativeTo(null);
      f.getContentPane().setLayout(null);
      f.addWindowListener(this);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		JPanel maindp = new JPanel();
		maindp.setBounds(0, 90, 600, 335);
		maindp.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
=======
      JButton write = new JButton("작성");
      write.setBounds(12, 584, 102, 40);
      write.addActionListener(this);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		JPanel content2 = new JPanel(); // 메인쪽패널
		content2.setBounds(15, 60, 757, 500);
		content2.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
=======
      JButton cancle = new JButton("취소");
      cancle.setBounds(670, 584, 102, 40);
      cancle.addActionListener(this);
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		// textArea = new JTextArea(); //내용
		// textArea.setBounds(33, 100, 565, 312);
		// textArea.setColumns(10);
=======
      JPanel maindp = new JPanel();
      maindp.setBounds(0, 90, 600, 335);
      maindp.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		f.getContentPane().add(cancle);
		f.getContentPane().add(write);
		f.getContentPane().add(content2);
		content2.setLayout(null);
=======
      JPanel content2 = new JPanel(); // 메인쪽패널
      content2.setBounds(15, 60, 757, 500);
      content2.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
>>>>>>> refs/remotes/origin/master

<<<<<<< HEAD
		JPanel maindptitle2_1 = new JPanel();
		maindptitle2_1.setBounds(0, 0, 756, 38);
		content2.add(maindptitle2_1);
		maindptitle2_1.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
		maindptitle2_1.setLayout(null);

		JLabel maindptitle = new JLabel("제목");
		maindptitle.setBounds(0, 0, 50, 38);
		maindptitle.setHorizontalAlignment(JLabel.CENTER);
		maindptitle.setFont(font2);
		maindptitle2_1.add(maindptitle);
		maindptitle.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maindptitlecontent = new JTextField("");
		maindptitlecontent.setBounds(50, 1, 707, 37);
		maindptitle2_1.add(maindptitlecontent);
		maindptitlecontent.setColumns(10);

		JLabel content = new JLabel("내용");
		content.setBounds(0, 36, 50, 464);
		content.setFont(font2);
		content.setHorizontalAlignment(JLabel.CENTER);
		content2.add(content);
		content.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

		maincontent2 = new JTextArea("");
		maincontent2.setBounds(50, 38, 705, 460);
		content2.add(maincontent2);

		JLabel title_1 = new JLabel("새글작성");
		title_1.setBounds(257, 10, 200, 40);
		f.getContentPane().add(title_1);
		title_1.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		title_1.setHorizontalAlignment(JLabel.CENTER);
		f.setVisible(true);
	}
=======
      // textArea = new JTextArea(); //내용
      // textArea.setBounds(33, 100, 565, 312);
      // textArea.setColumns(10);
>>>>>>> refs/remotes/origin/master

      f.getContentPane().add(cancle);
      f.getContentPane().add(write);
      f.getContentPane().add(content2);
      content2.setLayout(null);

      JPanel maindptitle2_1 = new JPanel();
      maindptitle2_1.setBounds(0, 0, 756, 38);
      content2.add(maindptitle2_1);
      maindptitle2_1.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));
      maindptitle2_1.setLayout(null);

      JLabel maindptitle = new JLabel("제목");
      maindptitle.setBounds(0, 0, 50, 38);
      maindptitle.setHorizontalAlignment(JLabel.CENTER);
      maindptitle.setFont(font2);
      maindptitle2_1.add(maindptitle);
      maindptitle.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

      maindptitlecontent = new JTextField("제목을 적어주세요");
      maindptitlecontent.setBounds(50, 1, 707, 37);
      maindptitle2_1.add(maindptitlecontent);
      maindptitlecontent.setColumns(10);

      JLabel content = new JLabel("내용");
      content.setBounds(0, 36, 50, 464);
      content.setFont(font2);
      content.setHorizontalAlignment(JLabel.CENTER);
      content2.add(content);
      content.setBorder(new TitledBorder(new LineBorder(Color.black, 1)));

      maincontent2 = new JTextArea("내용을 적어주세요");
      maincontent2.setBounds(50, 38, 705, 460);
      content2.add(maincontent2);

      JLabel title_1 = new JLabel("새글작성");
      title_1.setBounds(257, 10, 200, 40);
      f.getContentPane().add(title_1);
      title_1.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
      title_1.setHorizontalAlignment(JLabel.CENTER);
      f.setVisible(true);
   }

   @Override
   public void windowOpened(WindowEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowClosing(WindowEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowClosed(WindowEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowIconified(WindowEvent e) {
      // TODO Auto-generated method stub

<<<<<<< HEAD
	@Override
	public void actionPerformed(ActionEvent e) { // 나중에 작성부분 command로 옮기기
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("취소")) {
			f.setVisible(false);
		} else if (e.getActionCommand().equals("작성")) {
			try {
				ConnectionB cb = new ConnectionB(); // 연결
				Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
				String sql = "" + "insert into post(User_id,bno, btitle,bcontent, bdate,blikes,bviews) "
						+ "values(default,SEQ_BNO.NEXTVAL,?,?,to_char(Sysdate,'YYYY-MM-DD'),?,?) ";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, maindptitlecontent.getText());
				// System.out.println(maindptitlecontent.getText());
				pstmt.setString(2, maincontent2.getText());
				// System.out.println(maincontent2.getText());
				pstmt.setInt(3, 0);
				pstmt.setInt(4, 0);
				pstmt.executeUpdate();
=======
   }

   @Override
   public void windowDeiconified(WindowEvent e) {
      // TODO Auto-generated method stub
>>>>>>> refs/remotes/origin/master

   }

   @Override
   public void windowActivated(WindowEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void windowDeactivated(WindowEvent e) {
      // TODO Auto-generated method stub

   }

   @Override
   public void actionPerformed(ActionEvent e) { // 나중에 작성부분 command로 옮기기
      // TODO Auto-generated method stub
      if (e.getActionCommand().equals("취소")) {
         f.setVisible(false);
      } else if (e.getActionCommand().equals("작성")) {
         try {
            ConnectionB cb = new ConnectionB(); // 연결
            Connection conn = DriverManager.getConnection(URL, USERID, USERPWD);
            String sql = "" + "insert into Boards(bno, btitle,bmain, bdate, busy) "
                  + "values(SEQ_BNO.NEXTVAL,?,?,SYSDATE,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, maindptitlecontent.getText());
            // System.out.println(maindptitlecontent.getText());
            pstmt.setString(2, maincontent2.getText());
            // System.out.println(maincontent2.getText());
            pstmt.setInt(3, 1);
            pstmt.executeUpdate();

            maindptitlecontent.setText("");
            maincontent2.setText("");

         } catch (SQLException e2) {
            e2.printStackTrace();
         } finally {
         }
         try {
            pstmt.close();
            // System.exit(0);
         } catch (SQLException e3) {
            e3.printStackTrace();
         }
      }
   }

}