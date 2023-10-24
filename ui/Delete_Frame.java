package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import backend.Student_detail;

public class Delete_Frame implements ActionListener {
    JFrame deleteFrame;
    JLabel head, lid, lcheck, lstate, lsuccess;
    JTextField tid;
    JButton bcheck, bdelete, back;
    Student_detail ob;

    public Delete_Frame() {
        deleteFrame = new JFrame("Delete Profile");

        head = new JLabel("Delete Profile");
        head.setBounds(150, 60, 300, 50);
        head.setFont(new Font("Verdana", Font.PLAIN, 17));

        lid = new JLabel("Registration no: ");
        lid.setBounds(70, 120, 100, 30);

        tid = new JTextField();
        tid.setBounds(200, 130, 100, 17);

        bcheck = new JButton("Check");
        bcheck.setBounds(320, 120, 100, 30);
        bcheck.addActionListener(this);

        lcheck = new JLabel();
        lcheck.setBounds(150, 150, 200, 30);

        lstate = new JLabel();
        lstate.setBounds(150, 220, 230, 30);
        lstate.setVisible(false);

        bdelete = new JButton("Delete");
        bdelete.setBounds(160, 270, 100, 30);
        bdelete.addActionListener(this);
        bdelete.setVisible(false);

        lsuccess = new JLabel("");
        lsuccess.setBounds(150, 350, 200, 30);

        back = new JButton("Back");
        back.setBounds(10, 410, 100, 40);
        back.addActionListener(this);

        deleteFrame.add(head);
        deleteFrame.add(lid);
        deleteFrame.add(tid);
        deleteFrame.add(bcheck);
        deleteFrame.add(lcheck);
        deleteFrame.add(lstate);
        deleteFrame.add(bdelete);
        deleteFrame.add(back);
        deleteFrame.add(lsuccess);

        deleteFrame.setLayout(null);
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        deleteFrame.setSize(500, 500);
        deleteFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Back")) {
            deleteFrame.setVisible(false);
            new Main_Frame();
        }
        if (s.equals("Check")) {
            ob = new Student_detail();
            if (ob.check(tid.getText()) == 1) {
                lcheck.setText("Profile Present");
                lcheck.setForeground(Color.GREEN);
                lstate.setText("Are you sure to delete?");
                lstate.setForeground(Color.RED);
                lstate.setVisible(true);
                bdelete.setVisible(true);
            } else {
                lcheck.setText("No such Profile");
                lcheck.setForeground(Color.RED);
            }
        }
        if (s.equals("Delete")) {
            if (ob.deleted(tid.getText()) == 1) {
                lsuccess.setText("Deleted successfully!!");
                lsuccess.setForeground(Color.GREEN);
            } else {
                lsuccess.setText("Error!!");
                lsuccess.setForeground(Color.RED);
            }
        }
    }
}
