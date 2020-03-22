package test.demo;

import javax.swing.*;
import java.awt.*;

/*
*事实证明需要先把JFrame创建之后再继续添加初始化和添加其他组件。。要不然会出现乱序
 */
public class Table extends JFrame {
    private JButton btn_result;

    public void initUI(){

        this.setBounds(100,100,400,400);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        btn_result = new JButton("submit");
        btn_result.setBounds(10, 15, 82, 23);
        btn_result.addActionListener(new MyBtnListen());
        this.getContentPane().add(btn_result);

    }

    public static void main(String[] args) {
        Table t = new Table();
        t.initUI();
        t.setVisible(true);
    }
}
