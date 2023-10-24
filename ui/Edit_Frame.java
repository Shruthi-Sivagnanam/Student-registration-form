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

public class Edit_Frame implements ActionListener {
    JFrame editFrame;
    JLabel head, lstep, lid, lcheck, lstep2, lname, ladd, lupdate;
    JTextField tid, tname, tadd;
    JButton bcheck, bupdate, back;
    Student_detail ob;

    public Edit_Frame() {
        editFrame = new JFrame("Edit-Address");

        head = new JLabel("Edit-Profile(Address)");
        head.setBounds(160, 30, 300, 50);
        head.setFont(new Font("Verdana", Font.PLAIN, 17));

        lstep = new JLabel("Step-1");
        lstep.setBounds(50, 90, 100, 30);

        lid = new JLabel("Registration no: ");
        lid.setBounds(70, 120, 100, 30);

        tid = new JTextField();
        tid.setBounds(200, 130, 100, 17);

        bcheck = new JButton("Check");
        bcheck.setBounds(320, 120, 100, 30);
        bcheck.addActionListener(this);

        lcheck = new JLabel();
        lcheck.setBounds(150, 150, 200, 30);

        lstep2 = new JLabel("Step-2");
        lstep2.setBounds(50, 200, 100, 30);

        lname = new JLabel("Student Name : ");
        lname.setBounds(70, 230, 200, 30);

        tname = new JTextField();
        tname.setBounds(250, 240, 100, 17);
        tname.setEditable(false);

        ladd = new JLabel("Change of Address : ");
        ladd.setBounds(70, 270, 200, 30);

        tadd = new JTextField();
        tadd.setBounds(250, 280, 100, 17);
        tadd.setEditable(false);

        bupdate = new JButton("Update");
        bupdate.setBounds(170, 320, 100, 30);
        bupdate.setEnabled(false);
        bupdate.addActionListener(this);

        lupdate = new JLabel("");
        lupdate.setBounds(150, 350, 200, 30);

        back = new JButton("Back");
        back.setBounds(10, 410, 100, 40);
        back.addActionListener(this);

        editFrame.add(bcheck);
        editFrame.add(head);
        editFrame.add(lstep);
        editFrame.add(lid);
        editFrame.add(tid);
        editFrame.add(lcheck);
        editFrame.add(lstep2);
        editFrame.add(tadd);
        editFrame.add(ladd);
        editFrame.add(tname);
        editFrame.add(lname);
        editFrame.add(bupdate);
        editFrame.add(lupdate);
        editFrame.add(back);

        editFrame.setLayout(null);
        editFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editFrame.setSize(500, 500);
        editFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Back")) {
            editFrame.setVisible(false);
            new Main_Frame();
        }
        if (s.equals("Check")) {
            ob = new Student_detail();
            if (ob.check(tid.getText()) == 1) {
                lcheck.setText("Profile Present");
                lcheck.setForeground(Color.GREEN);
                tname.setText(ob.name);
                tadd.setEditable(true);
                bupdate.setEnabled(true);
            } else {
                lcheck.setText("No such Profile");
                lcheck.setForeground(Color.RED);
            }
        }
        if (s.equals("Update")) {
            if (tadd.getText().equals("")) {
                lupdate.setText("Empty Creditals");
                lupdate.setForeground(Color.RED);
            } else if (ob.update(tadd.getText()) == 1) {
                lupdate.setText("Updated Successfully!");
                lupdate.setForeground(Color.GREEN);
            } else {
                lupdate.setText("Error!!");
                lupdate.setForeground(Color.RED);
            }
        }
    }
}
