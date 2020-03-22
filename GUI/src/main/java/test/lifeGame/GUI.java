package test.lifeGame;


import test.demo.MyBtnListen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {
    private  gameDemo game;

    private JButton jbuttonRun;
    private JLabel jlabelRows;

    private JTextField jtextRows;
    private JLabel jLabelCols;
    private JTextField jtextCols;

    private JLabel jLabelRate;
    private JTextField jtextRate;

    public GUI(){

    }

    public  void init(){
        setTitle("生命游戏");
        setBounds(200,150,700,600);
        getContentPane().setLayout(null);

        //设置Rate文本
        jLabelRate = new JLabel("Rate:");
        jLabelRate.setBounds(500,100,40,20);
        this.getContentPane().add(jLabelRate);

        jtextRate = new JTextField("1=>1s");
        jtextRate.setBounds(540,100,60,20);
        this.getContentPane().add(jtextRate);

        //设置cols文本
        jLabelCols = new JLabel("Cols:");
        jLabelCols.setBounds(500,200,40,20);
        this.getContentPane().add(jLabelCols);

        jtextCols = new JTextField();
        jtextCols.setBounds(540,200,60,20);
        this.getContentPane().add(jtextCols);

        //设置Rows文本
        jlabelRows = new JLabel();
        jlabelRows.setText("Rows:");
        jlabelRows.setBounds(500,300,40,20);
        this.getContentPane().add(jlabelRows);

        jtextRows = new JTextField();
        jtextRows.setBounds(540,300,60,20);
        this.getContentPane().add(jtextRows);

        //run按钮
        jbuttonRun = new JButton("run");
        jbuttonRun.setBounds(500,400,100,40);
        this.getContentPane().add(jbuttonRun);
        jbuttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加获取输入的代码，以及执行规则的代码
                game = new gameDemo(40,50);//可用像素:500
                new Thread(game).start();
                add(game);
            }
        });

    }

    public static void main(String[] args) {
        GUI game = new GUI();
        game.init();
        game.setVisible(true);

    }

}
