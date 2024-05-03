package Mains;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Mainpopup {

 // 이미지크기조정
	ImageIcon imageSetSize(ImageIcon icon, int i, int j) { // image Size Setting
		Image ximg = icon.getImage(); // ImageIcon을 Image로 변환.
		Image yimg = ximg.getScaledInstance(i, j, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xyimg = new ImageIcon(yimg);
		return xyimg;
	}

	// 프레임 생성
//	public static void main(String[] args) {
	public Mainpopup() {
		Frame f = new Frame("메인페이지 팝업");
		f.setSize(800, 800);
		f.setLayout(null);

		// 글씨체
		Font font1 = new Font("맑은 고딕", Font.BOLD, 20);
		Font font2 = new Font("맑은 고딕", Font.BOLD, 40);

		// 로고 객체 생성
		JButton logo = new JButton();
		// 로고 크기 및 위치
		logo.setSize(100, 90);
		logo.setLocation(60, 60);

		// 로고 이미지 생성
//		logo = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/1o0.jpg"));
		ImageIcon imgTest = new ImageIcon(getClass().getResource("../img/logo.jpg"));
		imgTest = imageSetSize(imgTest, 100, 90);
		logo.setIcon(imgTest);

		// + 객체 생성
		JButton plus1;
		JButton plus2;
		JButton plus3;
		JButton plus4;
		JButton plus5;
		// + 이미지 생성
		plus1 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/plus.jpg"));
		plus2 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/plus.jpg"));
		plus3 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/plus.jpg"));
		plus4 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/plus.jpg"));
		plus5 = new JButton(new ImageIcon("C:/Users/Manic-063/git/AccountManagement/src/plus.jpg"));

		// + 이미지 크기 및 위치
		plus1.setSize(30, 30);
		plus1.setLocation(490, 260);

		plus2.setSize(30, 30);
		plus2.setLocation(490, 300);

		plus3.setSize(30, 30);
		plus3.setLocation(490, 340);

		plus4.setSize(30, 30);
		plus4.setLocation(490, 380);

		plus5.setSize(30, 30);
		plus5.setLocation(530, 420);
		// 중앙배치
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		f.setLocation(screenSize.width / 2 - 800 / 2, screenSize.height / 2 - 800 / 2);
		// 버튼 생성
		Button scc = new Button("완료");
		scc.setFont(font1);

		scc.setSize(100, 60);
		scc.setLocation(350, 600);
		// 라벨 생성
		Label l3 = new Label("Today");
		l3.setFont(font2);

		Label l4 = new Label("운동");
		l4.setFont(font1);
		Label l5 = new Label("음식");
		l5.setFont(font1);
		Label l6 = new Label("수면");
		l6.setFont(font1);
		Label l7 = new Label("체중");
		l7.setFont(font1);
		Label l8 = new Label("수분섭취");
		l8.setFont(font1);

		l3.setSize(250, 70);
		l3.setLocation(350, 160);

		l4.setSize(50, 50);
		l4.setLocation(100, 250);
		l5.setSize(50, 50);
		l5.setLocation(100, 290);
		l6.setSize(50, 50);
		l6.setLocation(100, 330);
		l7.setSize(50, 50);
		l7.setLocation(100, 370);
		l8.setSize(100, 50);
		l8.setLocation(100, 410);

		// Choice 생성
		Choice ctl1 = new Choice();
		Choice ctl2 = new Choice();

		Choice ctl3 = new Choice();
		Choice ctl4 = new Choice();

		Choice ctl5 = new Choice();
		Choice ctl6 = new Choice();

		Choice ctl17 = new Choice();
		Choice ctl18 = new Choice();

		Choice ctl19 = new Choice();
		Choice ctl20 = new Choice();
		
		
		
		// Choice 내용 생성
		
		String[]arr = new String[]{"걷기","빨리걷기","달리기","근력운동","요가","필라테스","자전거 타기","줄넘기","수영",
				"배드민턴","에어로빅","테니스","등산","볼링","탁구","농구","축구"};
		for(int i =0; i<arr.length;i++) {
			ctl1.add(arr[i]);
		}
		
		ctl2.add("catalog");
		
		
		
		String[]arr3 = new String[]{"<--주식류-->","쌀밥 1공기()","현미밥 1공기", "잡곡밥 1공기","흑미밥 1공기","식빵 2쪽()","군고구마 1개","찐고구마 1개()",
				"피자 1조각()","떡 100g","떡볶이 1인분()","김밥 1줄()","라면 1개","자장면 1인분","햄버거 1개()",
				"<--단백질류-->","삶은 달걀 1개()","구운 계란 1개()","계란후라이 1개()","훈제 닭가슴살 1인분()","두부 100g","돼지고기 삼겹살 구운 것 1인분()","소고기 등심 구이 1인분()","치킨 1마리()",
				"<--과일류,채소류-->","사과 1개()","귤 1개()","딸기 5개()","바나나 1개()","방울토마토 10개()","토마토 1개()","야채샐러드 드레싱 포함 1인분()","양상추 100g","양배추 100g",
				"<--음료-->","우유 1컵()","아메리카노 1잔()","두유 1팩()","아몬드브리즈 1팩()","콜라 1/2병()","파워에이드 1병()","탄산수","오렌지주시 1병()","소주 1병()","맥주 1캔()",
				"<--기타음식-->","아몬드 10개()","하루견과 1봉()","아이스크림 1컵()","초콜렛 1개()"};
		for(int i =0; i<arr3.length;i++) {
			ctl3.add(arr3[i]);
		}
		
		ctl4.add("catalog");

		ctl5.add("catalog");
		ctl6.add("catalog");

		ctl17.add("catalog");
		ctl18.add("catalog");

		ctl19.add("catalog");
		ctl20.add("catalog");
		// Choice 크기 및 위치
		ctl1.setSize(150, 60);
		ctl1.setLocation(160, 265);
		ctl2.setSize(150, 60);
		ctl2.setLocation(330, 265);

		ctl3.setSize(230, 60);
		ctl3.setLocation(160, 305);
		ctl4.setSize(150, 60);
		ctl4.setLocation(410, 305);

		ctl5.setSize(150, 60);
		ctl5.setLocation(160, 345);
		ctl6.setSize(150, 60);
		ctl6.setLocation(330, 345);

		ctl17.setSize(150, 60);
		ctl17.setLocation(160, 385);
		ctl18.setSize(150, 60);
		ctl18.setLocation(330, 385);

		ctl19.setSize(150, 60);
		ctl19.setLocation(200, 425);
		ctl20.setSize(150, 60);
		ctl20.setLocation(370, 425);

		// 프로그램 창 닫기
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		f.add(logo);
		f.add(plus1);
		f.add(plus2);
		f.add(plus3);
		f.add(plus4);
		f.add(plus5);
		f.add(scc);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		f.add(ctl1);
		f.add(ctl2);
		f.add(ctl3);
		f.add(ctl4);
		f.add(ctl5);
		f.add(ctl6);
		f.add(ctl17);
		f.add(ctl18);
		f.add(ctl19);
		f.add(ctl20);

		f.setVisible(true);

	}

	public static void main(String[] args) {
		new Mainpopup();
	}

}