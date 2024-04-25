package test;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.text.*;

import java.util.*;

import java.util.Timer;


public class game150 {
 
public static void main(String[] ar) {

MainFrame mf = new MainFrame();

//메인클래스, 메인프레임을불러와실행

}

}










class MainFrame extends JFrame implements MouseListener, Runnable {

//메인프레임클래스


private JLabel lb_title = new JLabel();

//게임타이틀표시용라벨

private JLabel lb_time = new JLabel();

//시간표시용라벨


private JButton bt_start = new JButton("START");

//게임시작버튼

private JButton bt_reset = new JButton("RESET");

//게임리셋버튼


SimpleDateFormat time_format;

//시간값을변환하기위한포맷

String show_time;

//진행시간값을받아들일문자열

long start_time, current_time, actual_time;

//게임시작시간, 컴퓨터시간, 실제게임진행시간


boolean time_run = false;


Thread th;

//스레드


ImagePanel sc;

//게임화면을표시할패널클래스접근키


MainFrame() {

//화면에띄울프레임정의

init();

start();


setTitle("1 to 50 Game");

setSize(600, 600);

Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

int xpos = (int) (screen.getWidth() / 2 - getWidth() / 2);

int ypos = (int) (screen.getHeight() / 2 - getHeight() / 2);

setLocation(xpos, ypos);

setResizable(false);

setVisible(true);


}


public void init() {

//게임라벨, 버튼및게임화면용패널설정


Container con = this.getContentPane();

con.setLayout(null);


lb_title.setBounds(250, 10, 300, 30);

lb_title.setFont(new Font("Default", Font.BOLD, 20));

con.add(lb_title);

lb_time.setBounds(400, 50, 150, 30);

lb_time.setFont(new Font("Default", Font.BOLD, 20));

con.add(lb_time);

//프레임에표시할텍스트라벨


bt_start.setBounds(100, 520, 100, 30);

bt_start.setFont(new Font("Default", Font.BOLD, 20));

con.add(bt_start);

bt_reset.setBounds(400, 520, 100, 30);

bt_reset.setFont(new Font("Default", Font.BOLD, 20));

con.add(bt_reset);

//프레임에표시할게임시작및리셋버튼


sc = new ImagePanel();

sc.setBounds(100, 100, 410, 410);

con.add(sc);

//게임화면용패널


}


public void start() {

//프레임내실행시킬기본내용


this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//프레임종료용X버튼활성화

this.addMouseListener(this);

//프레임내마우스동작활성화


bt_start.addMouseListener(this);

// start 버튼에마우스동작활성화

bt_reset.addMouseListener(this);

// reset 버튼에마우스동작활성화


th = new Thread(this);

th.start();

//스레드시작


time_format = new SimpleDateFormat("HH:mm:ss.SSS");

//시간포맷설정


lb_time.setText("00:00:00.000");

lb_title.setText("1 to 50 Game");

//라벨텍스트내용설정


sc.gameStart(false);

//게임은대기상태로


}


public void run() {

while (true) {

try {


repaint();

TimeCheck();


Thread.sleep(15);

//무한스레드돌리기


} catch (Exception e) {

}

}


}


public void TimeCheck() {


if (time_run) {


current_time = System.currentTimeMillis();

actual_time = current_time - start_time;

//게임시작버튼을눌렀을때의시간값과

//실제시간값으로게임진행시간계산.


sc.countDown((int) actual_time / 1000);

//카운트다운표시용시간값전송


if (!sc.game_start && sc.check <= 50) {

//게임세팅완료후게임시작되면게임진행시간갱신


show_time = time_format.format(actual_time - 32403000);

lb_time.setText(show_time);


}

}


if ( sc.check > 50){


sc.ClearTime(lb_time.getText());

//숫자50까지클릭이끝나면게임클리어메세지띄울준비

}

}


public void mouseClicked(MouseEvent e) {


if (e.getSource() == bt_start) {

//게임시작버튼


if (!time_run && !sc.game_start ) {


start_time = System.currentTimeMillis();

//시작버튼눌렀을시시간값받기


sc.rect_select.clear();

time_run = true;

sc.gameStart(true);

//게임및시간세팅


//System.out.println("start");

}


} else if (e.getSource() == bt_reset) {

//게임초기화버튼


start_time = 0;

lb_time.setText("00:00:00.000");


sc.rect_select.clear();

sc.countDown(0);

time_run = false;

sc.gameStart(false);

sc.check = 0;

//게임초기화


//System.out.println("reset");

}

}


public void mousePressed(MouseEvent e) {}

public void mouseReleased(MouseEvent e) {}

public void mouseEntered(MouseEvent e) {}

public void mouseExited(MouseEvent e) {}


}












class ImagePanel extends JPanel implements MouseListener {

//실제게임화면을표시할패널


int count = 3;//카운트다운표시용

int x, y; //좌표값

int check; //숫자체크용


String time;//클리어시간값표시용


boolean game_start = false;


Random ran_num = new Random();

//랜덤함수


Vector rect_select = new Vector();

//1-50 숫자보관용벡터


SelectRect sr;

//숫자보관용객체클래스접근키


ImagePanel() {

this.addMouseListener(this);

}


public void countDown(int count) {

//게임시간값을받아와카운트다운표시


switch (count) {

case 0:

this.count = 3;

break;

case 1:

this.count = 2;

break;

case 2:

this.count = 1;

break;

case 3:

this.count = 0;

game_start = false;

break;

}

}


public void gameStart(boolean game_start) {

//게임기본세팅

//25개의사각박스와해당박스안에

//랜덤으로난수를발생시켜나온숫자를받아입력한다.


this.game_start = game_start;


if ( this.game_start ){

check = 1;


for (int i = 0; i < 5; ++i) {

for (int j = 0; j < 5; ++j) {

int num = 0;


int xx = 5 + i * 80;

int yy = 5 + j * 80;

//25개사각형좌표값들


num = ran_num.nextInt(25) + 1;

for (int k = 0; k < rect_select.size(); ++k) {

sr = (SelectRect) rect_select.get(k);

if ( sr.number == num ) {

num = ran_num.nextInt(25) + 1;

k = -1;

}

}

//중복없는난수발생


sr = new SelectRect(xx, yy, num);

rect_select.add(sr);

//받은좌표및난수값을객체화시켜벡터로저장


}

}

}

}


public void paint(Graphics g) {


g.drawRect(0, 0, 400, 400);

//게임화면사각테두리


if (game_start) {

//카운트다운텍스트그리기


g.setFont(new Font("Default", Font.BOLD, 50));

g.drawString("CountDown", 70, 150);

g.setFont(new Font("Default", Font.BOLD, 100));

g.drawString("" + count, 170, 250);


}else if ( !game_start && count == 0 ){


for (int i = 0; i < rect_select.size(); ++i) {


sr = (SelectRect) rect_select.get(i);

g.drawRect(sr.x, sr.y, 70, 70);

g.setFont(new Font("Default", Font.BOLD, 30));

g.drawString("" + sr.number, sr.x + 22, sr.y + 45);

//벡터에저장된각각의숫자값을받아사각형과숫자그리기

}


g.setColor(Color.red);

g.drawRect(x * 80 + 5, y * 80 + 5, 70, 70);

//마우스로선택된사각박스를붉게표시


}


if ( check > 50 ){

g.setColor(Color.blue);

g.setFont(new Font("Default", Font.BOLD, 50));

g.drawString("GAME CLEAR!", 40, 150);

g.setColor(Color.red);

g.setFont(new Font("Default", Font.BOLD, 40));

g.drawString("" + time, 90, 250);

//게임이클리어되면클리어화면표시

}


}


public void ClearTime(String time){

this.time = time;

}


public void mouseClicked(MouseEvent e) {}


public void mousePressed(MouseEvent e) {


x = e.getX() / 80;

y = e.getY() / 80;


if ( count == 0 ){

for (int i = 0; i < rect_select.size(); ++i) {

sr = (SelectRect) rect_select.get(i);

if (x == sr.x / 80 && y == sr.y / 80) {

int xx = sr.x;

int yy = sr.y;

if ( sr.number - check == 0 ) {


check ++;

rect_select.remove(i);

//1-50 숫자순서대로클릭되면해당하는숫자제거


if ( check < 27 ){

int num = 0;


num = ran_num.nextInt(25) + 26;


for (int k = 0; k < rect_select.size(); ++k) {

sr = (SelectRect) rect_select.get(k);

if ( sr.number == num ) {

num = ran_num.nextInt(25) + 26;

k = -1;

}

}


sr = new SelectRect(xx, yy, num);

rect_select.add(sr);

//제거된숫자가있으면그자리에

//다시난수를발생시켜숫자를추가


}

}


}


}

}


}

public void mouseReleased(MouseEvent e) {}

public void mouseEntered(MouseEvent e) {}

public void mouseExited(MouseEvent e) {}

}


class SelectRect {

//숫자및위치보관용클래스


int x, y;

int number;


SelectRect(int x, int y, int number) {

this.x = x;

this.y = y;

this.number = number;

}


}