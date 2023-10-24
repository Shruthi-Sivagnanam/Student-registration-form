package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main_Frame implements ActionListener {
    JFrame mainFrame;
    JButton breg, bedit, bdel;
    JLabel head;

    public Main_Frame() {
        mainFrame = new JFrame("Student-Profile");

        head = new JLabel("Student-Registration");
        head.setBounds(150, 60, 300, 50);
        head.setFont(new Font("Verdana", Font.PLAIN, 17));

        breg = new JButton("Create Profile");
        breg.setBounds(140, 150, 200, 50);
        breg.addActionListener(this);

        bedit = new JButton("Edit Profile");
        bedit.setBounds(140, 230, 200, 50);
        bedit.addActionListener(this);

        bdel = new JButton("Delete Profile");
        bdel.setBounds(140, 320, 200, 50);
        bdel.addActionListener(this);

        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setVisible(true);

        mainFrame.add(head);
        mainFrame.add(breg);
        mainFrame.add(bedit);
        mainFrame.add(bdel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Create Profile")) {
            mainFrame.setVisible(false);
            new Reg_Frame();
        }
        if (s.equals("Edit Profile")) {
            mainFrame.setVisible(false);
            new Edit_Frame();
        }
        if (s.equals("Delete Profile")) {
            mainFrame.setVisible(false);
            new Delete_Frame();
        }
    }
}
