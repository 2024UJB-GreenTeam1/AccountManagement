package Board;
//보드 프레임 클래스
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Boardset  extends WindowAdapter implements ActionListener {
	private Frame f;
	private Button np,search2;
	private JButton logo;
	private JLabel board,writer,writing,date;
	private TextField search;
	private JPanel main;
	
	public Boardset(){
		f = new Frame("1o0");
		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		logo.setBorderPainted(false);
		logo.setFocusPainted(false);
		logo.setContentAreaFilled(false);
		
		Font font = new Font("맑은 고딕",Font.BOLD,50);
		//Font font2 = new Font("궁서체",Font.BOLD,10);
		np = new Button("새글작성");
		search2 = new Button("검색");
		board = new JLabel("게시판");
		board.setFont(font);
		writer = new JLabel("작성자");
		writing = new JLabel("내용");
		date = new JLabel("날짜");
		main = new JPanel();
		main.setBorder(new TitledBorder(new LineBorder(Color.black,2)));
		search = new TextField();
		
		f.setLayout(null);
}
	
	
	public void startFrame() {
		f.setSize(800,800);
		f.addWindowListener(this);   // 이거 없으면 창닫기도 안된다.
		f.setLocationRelativeTo(null);
		
		logo.setSize(100,100);   //로고
		logo.setLocation(10,30);
		
		np.setSize(50,25);     //새글작성
		np.setLocation(7,750);
		 
		writer.setSize(50,25);      //작성자
		writer.setLocation(50,150);
			
		writing.setSize(50,25); 	//내용   
		writing.setLocation(300,150);
		
		date.setSize(50,25);  	//날짜
		date.setLocation(650,150);
		
		board.setSize(200,100);     //x 클수록 오른쪽 y 클수록 아래로 
		board.setLocation(320,50);   //게시판 라벨
		
		main.setSize(800,600);       //내용들어갈 예정
		main.setLocation(8,150);
		
		search.setSize(100,25);   //검색창
		search.setLocation(650,750);
			
		search2.setSize(50,25);   //검색버튼 
		search2.setLocation(750,750);
		
		
		f.add(writer);
		f.add(writing);
		f.add(date);
		f.add(search2);
		f.add(search);
		f.add(np);
		f.add(main);
		f.add(logo);
		f.add(board);
		f.setVisible(true);
		
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);  //닫기 눌러서 창닫기
	}

	@Override
	public void actionPerformed(ActionEvent e) {    
		// TODO Auto-generated method stub
		
		
	}
}
