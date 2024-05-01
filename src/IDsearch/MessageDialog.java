package IDsearch;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;					//다이얼로그창연습,  여기선 텍스트입력받을 수 없나?

import javax.swing.*;

public class MessageDialog extends JDialog {	//TestTestTestTestTestTestTestTestTestTestTest
    public MessageDialog(Frame parent, String title, String message) {
        super(parent, title, true);
        setSize(300, 150);
        setLayout(null);
        JLabel lblMessage = new JLabel(message);
        JTextField tfId = new JTextField();
    	tfId.setLocation(20, 20);
		tfId.setSize(100, 30);
		tfId.setText("text");
        lblMessage.setBounds(50, 50, 200, 30);
        add(lblMessage);
        add(tfId);
        setLocationRelativeTo(parent);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        setVisible(true);
    }
}