package test.lifeGame;

import javax.swing.*;
import java.util.Random;

/*
* 生命游戏
* Active 表示活,Dead 表示死
 */
public class gameDemo extends JPanel implements Runnable {

    private CellStatus [][] generation1;
    private int MaxRow = 100;
    private int MaxCol = 100;
    private int rows;
    private int cols;
    private int frequenceRate = 1;

    //测试功能
    public static void main(String[] args) {
        gameDemo game = new gameDemo(5, 5);

        while (true) {
            for (int i = 0; i < game.rows; i++) {
                for (int j = 0; j < game.cols; j++) {
                    System.out.println(game.generation1[i][j] + " ");
                }
                System.out.println();
            }
            //game.showUI();
        }
    }

    @Override
    public void run() {

    }

    static enum CellStatus{
        Active ,
        dead
    }

    /*
    * 根据给出得行列创建世界,初始化随机生成矩阵
     */
    public gameDemo(int rows,int cols){
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

//    /*
//    * 初始化UI
//    * 根据矩阵创建UI视图响应变化
//     */
//    public void showUI(){
//        try {
//
//            sleep(1000 * frequenceRate);
//
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
//    }

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
