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

public class Reg_Frame implements ActionListener {
    JFrame regFrame;
    JLabel head, lid, lname, lbatch, ldep, ladd, lmes;
    JButton bregister, breset, back;
    JTextField tid, tname, tbatch, tdep, tadd;
    Student_detail ob;

    public Reg_Frame() {
        regFrame = new JFrame("Create Profile");

        head = new JLabel("Registration form");
        head.setBounds(170, 40, 300, 50);
        head.setFont(new Font("Verdana", Font.PLAIN, 17));

        lid = new JLabel("Registration no : ");
        lid.setBounds(120, 90, 100, 50);

        tid = new JTextField();
        tid.setBounds(250, 110, 100, 17);

        lname = new JLabel("Student name : ");
        lname.setBounds(120, 130, 100, 50);

        tname = new JTextField();
        tname.setBounds(250, 150, 100, 17);

        lbatch = new JLabel("Batch : ");
        lbatch.setBounds(120, 170, 100, 50);

        tbatch = new JTextField();
        tbatch.setBounds(250, 190, 100, 17);

        ldep = new JLabel("Department : ");
        ldep.setBounds(120, 210, 120, 50);

        tdep = new JTextField();
        tdep.setBounds(250, 230, 100, 17);

        ladd = new JLabel("Address : ");
        ladd.setBounds(120, 250, 120, 50);

        tadd = new JTextField();
        tadd.setBounds(250, 270, 100, 17);

        bregister = new JButton("Register");
        bregister.setBounds(260, 320, 100, 40);
        bregister.addActionListener(this);

        breset = new JButton("Reset");
        breset.setBounds(110, 320, 100, 40);
        breset.addActionListener(this);

        back = new JButton("Back");
        back.setBounds(10, 410, 100, 40);
        back.addActionListener(this);

        lmes = new JLabel();
        lmes.setBounds(200, 360, 150, 50);

        regFrame.setLayout(null);
        regFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regFrame.setSize(500, 500);
        regFrame.setVisible(true);

        regFrame.add(head);
        regFrame.add(lid);
        regFrame.add(tid);
        regFrame.add(lname);
        regFrame.add(tname);
        regFrame.add(lbatch);
        regFrame.add(tbatch);
        regFrame.add(tadd);
        regFrame.add(ladd);
        regFrame.add(bregister);
        regFrame.add(breset);
        regFrame.add(back);
        regFrame.add(lmes);
        regFrame.add(tdep);
        regFrame.add(ldep);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Back")) {
            regFrame.setVisible(false);
            new Main_Frame();
        }
        if (s.equals("Register")) {
            if (tname.getText().equals("") || tid.getText().equals("") || tbatch.getText().equals("")
                    || tdep.getText().equals("") || tadd.getText().equals("")) {
                lmes.setText("Empty Creditals");
                lmes.setForeground(Color.RED);
            } else {
                ob = new Student_detail(tname.getText(), tid.getText(), tbatch.getText(), tdep.getText(),
                        tadd.getText());
                if (ob.add_detail() == 1) {
                    lmes.setText("Sucessfully registered!!");
                    lmes.setForeground(Color.GREEN);
                } else {
                    lmes.setText("Error!!");
                    lmes.setForeground(Color.RED);
                }
            }
        }
        if (s.equals("Reset")) {
            tname.setText("");
            tid.setText("");
            tbatch.setText("");
            tdep.setText("");
            tadd.setText("");
            lmes.setText("");
        }
    }
}
