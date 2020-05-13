package test.lifeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * 对于遇到的覆盖问题，可以使用多个JPanel试试能不能解决，实在不行其他控件只能放菜单栏
 */
public class GUI extends JFrame  {
    Thread thread;

    private final gameDemo game;
    private boolean GameStatus = false;

    private JButton jbuttonRun;
    private JLabel jlabelRows;

    private JTextField jtextRows;
    private JLabel jLabelCols;
    private JTextField jtextCols;

    private JLabel jLabelRate;
    private JTextField jtextRate;

    public GUI() {
        game = new gameDemo(50,50);//可用像素:500
        game.setBounds(0,0,450,450);
        thread = new Thread(game);
        thread.start();
        add(game);
    }

    public  void init() {
        setTitle("生命游戏");
        setBounds(200,150,700,540);
        getContentPane().setLayout(null);

        jLabelRate = new JLabel("Rate:");
        jLabelRate.setBounds(500,100,40,20);
        this.getContentPane().add(jLabelRate);

        jtextRate = new JTextField("1=>1s");
        jtextRate.setBounds(540,100,60,20);
        this.getContentPane().add(jtextRate);

        jLabelCols = new JLabel("Cols:");
        jLabelCols.setBounds(500,200,40,20);
        this.getContentPane().add(jLabelCols);

        jtextCols = new JTextField();
        jtextCols.setBounds(540,200,60,20);
        this.getContentPane().add(jtextCols);

        jlabelRows = new JLabel();
        jlabelRows.setText("Rows:");
        jlabelRows.setBounds(500,300,40,20);
        this.getContentPane().add(jlabelRows);

        jtextRows = new JTextField();
        jtextRows.setBounds(540,300,60,20);
        this.getContentPane().add(jtextRows);

        jbuttonRun = new JButton("run");
        jbuttonRun.setBounds(500,400,100,40);
        this.getContentPane().add(jbuttonRun);
        jbuttonRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * 添加获取输入的代码，以及执行规则的代码,线程的暂停和重启
                 */
                if(!GameStatus) {
                    GameStatus=true;
                    game.cancle();
                    jbuttonRun.setText("stop");
                }else{
                    String col_st = jtextCols.getText();
                    String row_st = jtextRows.getText();
                    String rate_st = jtextRate.getText();

                    System.out.println("col:" + Integer.parseInt(col_st)+ ",row:" + Integer.parseInt(row_st) + ",rate:" + Float.parseFloat(rate_st));
                    game.Start();
                    game.generationRandom(Integer.parseInt(col_st) , Integer.parseInt(row_st) );
                    game.setFrequenceRate(Float.parseFloat(rate_st));

                    GameStatus = false ;
                    jbuttonRun.setText("run");
                }

            }
        } ) ;

    }

    public static void main(String[] args) {
        GUI frame = new GUI();
        frame.init();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
