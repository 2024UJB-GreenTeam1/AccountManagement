package Profile;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MessageDialog extends Dialog {
    public MessageDialog(Frame parent, String title, String message) {
        super(parent, title, true);
        setSize(300, 150);
        setLayout(null);
        Label lblMessage = new Label(message);
        lblMessage.setBounds(30, 50, 400, 30);
        add(lblMessage);
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
