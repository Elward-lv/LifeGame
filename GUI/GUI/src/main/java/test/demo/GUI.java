package test.demo;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{
    JButton resultButton = new JButton("0");
    JPanel panel = new JPanel();

    public GUI(){
        //set to BorderLayout
        setLayout(new BorderLayout());

        add(resultButton, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);

        //gridLayout
        GridLayout gridLayout = new GridLayout(4,4,3,3);
        panel.setLayout(gridLayout);

        //add buttons
        String [] buttonNames = new String []{"7", "8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
        for (String string : buttonNames) {
            panel.add(new JButton(string));
        }
        //config resultButton
        resultButton.setSize(200, 50);
        resultButton.setHorizontalAlignment(SwingConstants.RIGHT);
        resultButton.setEnabled(false);

        //setSize(250,200);
        pack();
        setTitle("GridLayoutDemo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        GUI demo = new GUI();
        demo.setVisible(true);

    }
}
