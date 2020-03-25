package test.demo;

import javax.swing.*;
import java.awt.*;

public class extendsJPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<10;i++)
            for(int j=0;j<10;j++){
                if(i%2 ==0){
                    g.fillRect(j*10, i*10, 10, 10);
                }else{
                    g.drawRect(j*10, i*10, 10, 10);
                }
            }
    }
}
