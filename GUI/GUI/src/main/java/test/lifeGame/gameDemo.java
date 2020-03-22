package test.lifeGame;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/*
* 生命游戏
* Active 表示活,Dead 表示死
 */
public class gameDemo extends JPanel implements Runnable {

    static enum CellStatus{
        Active ,
        dead
    }

    private boolean isCancel = false; //自定义一个终止标志位

    private CellStatus [][] generation1;
    private int MaxRow = 100;
    private int MaxCol = 100;
    private int rows;
    private int cols;
    private int frequenceRate = 1;


    @Override
    public void run() {
        System.out.println("线程开始");
        while (true) {
            while (!isCancel && !Thread.currentThread().isInterrupted()) {
                //这里是线程的代码，取消线程刷新只需要调用cancle()函数
//                synchronized (this) {
//                    while (!isCancel) {
//                        repaint();
//
//                        try {
//                            Thread.sleep(1000 * frequenceRate);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }

            }
            System.out.println("退出线程");
        }
    }

    public gameDemo(int rows,int cols){
       generationRandom(rows,cols);
    }

    /*
    * 根据给出得行列创建世界,初始化随机生成矩阵
     */
    public void generationRandom(int rows,int cols){
        if(!(rows <= MaxRow && cols<= MaxCol)){
            System.out.println("cols,rows error");
            return ;
        }
        this.rows = rows;
        this.cols = cols;
        generation1 = new CellStatus[cols][rows];

        //随机生成
        for(int i=0;i<this.cols;i++)
            for(int j=0;j<this.rows;j++){
                Random r = new Random();
                int z = r.nextInt(100);
                if(z>50)
                    generation1[i][j] = CellStatus.Active;
                else
                    generation1[i][j] = CellStatus.dead;
            }
    }


    /*
    * 根据规则改变矩阵
     * para:原始矩阵
     * out:变化后得矩阵
     */
    public int changeGeneration(){
        return 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0;i<rows;i++)
           for(int j=0;j<cols;j++){
                if(generation1[i][j]==CellStatus.Active){
                    g.fillRect(j*10, i*10, 10, 10);
                }else{
                    g.drawRect(j*10, i*10, 10, 10);
                }
            }
    }

    //终止线程
    public void cancle(){ isCancel = true; }
    public void Start(){ isCancel = false; }

    public int getFrequenceRate() {
        return frequenceRate;
    }

    /*
    * 修改刷新得频率，默认1s
     */
    public void setFrequenceRate(int frequenceRate) {
        this.frequenceRate = frequenceRate;
    }
}
