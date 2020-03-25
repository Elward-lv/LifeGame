package test.demo;

import test.lifeGame.gameDemo;

import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JFrame{
    private final gameDemo jpanel;
    private JTextField jt ;
    public MyJPanel(){
        //竟然只有这种方式才可以显示
        jpanel = new gameDemo(20,20);
        jpanel.setBounds(0,0,400,400);
        add(jpanel);
    }

    public void init(){

        setTitle("生命游戏");
        setBounds(200,200,600,600);
        getContentPane().setLayout(null);

        jt = new JTextField("hello");
        jt.setBounds(500,500,40,20);
        this.add(jt);
    }

    public static void main(String[] args) {
        MyJPanel jFrame = new MyJPanel();
        jFrame.init();//************区别**************
        jFrame.setVisible(true);

    }
}
