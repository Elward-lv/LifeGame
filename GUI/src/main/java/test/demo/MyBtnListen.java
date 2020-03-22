package test.demo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyBtnListen implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("btn is prey");
    }
}
