package test.lifeGame;

import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Random;
/**
 * Active 表示活,Dead 表示死
 */
public class gameDemo extends JPanel implements Runnable {

    static enum CellStatus {
        Active ,
        dead
    }


    private boolean isCancel = false; //自定义一个终止标志位

    private CellStatus [][] generation1 ;
    private CellStatus [][] generation2 ;
    private int MaxRow = 50 ;
    private int MaxCol = 50 ;
    private int rows;
    private int cols;
    private float frequenceRate = 1 ;


    @Override
    public void run() {
        System.out.println("线程开始") ;
        while (true) {
            synchronized (this) {
                while ( isCancel ) {
                    try {
                        this.wait() ;
                    } catch (InterruptedException e) {
                        e.printStackTrace() ;
                    }
                }

                repaint() ;
                try {
                    sleep() ;
                } catch (InterruptedException e) {
                    e.printStackTrace() ;
                }
                changeGeneration() ;

            }
        }
    }

    public gameDemo(int rows , int cols) {
       generationRandom(rows , cols ) ;
    }


    /**
     * 根据给出得行列创建世界,初始化随机生成矩阵
     * @param rows
     * @param cols
     */
    public void generationRandom(int rows , int cols ) {
        synchronized(this) {
            if ( ! (rows <= MaxRow && cols <= MaxCol) ) {
                System.out.println("cols,rows error") ;
                return ;
            }
            this.rows = rows ;
            this.cols = cols ;
            generation1 = new CellStatus[cols][rows] ;
            generation2 = new CellStatus[cols][rows] ;

            for ( int i = 0 ; i < this.cols ;  i++)
                for (int j = 0 ; j < this.rows ; j++) {
                    Random r = new Random() ;
                    int z = r.nextInt(100);
                    if ( z > 50 ) {
                        generation1[i][j] = CellStatus.Active;
                    } else {
                        generation1[i][j] = CellStatus.dead;
                    }
                }
            this.notifyAll();
        }
    }

    /**
     * 根据规则改变矩阵
     * @return
     */
    public int changeGeneration() {

        for(int i=0; i < rows; i++) {
            for(int j=0; j <cols ; j++) {
                judgeCellStatus(i,j);
            }
        }
        CellStatus[][] temp =null;
        temp = generation1;
        generation1 = generation2;
        generation2 = temp;

        for(int i=0 ; i < rows ; i++) {
            for(int j=0 ; j < cols ; j++) {
                generation2[i][j] = CellStatus.dead;
            }
        }
        return 1;
    }

    /**
     * 判断每个细胞周围的活细胞个数  并且改变下一代的这个细胞的状态
     * @param col
     * @param row
     * @return
     */
    int judgeCellStatus(int col , int row) {
        int activeCount = 0 ;

        if( (col-1) >= 0 && (row-1) >= 0 && (generation1[col-1][row-1] == CellStatus.Active) )
            activeCount++;//
        if( (col-1) >= 0 && (generation1[col-1][row] == CellStatus.Active))
            activeCount++;
        if( (col-1) >= 0 && (row+1) < rows && (generation1[col-1][row+1] == CellStatus.Active))
            activeCount++;

        if( (row-1) >= 0 && (generation1[col][row-1] == CellStatus.Active))
            activeCount++;//
        if( (row+1) < rows && (generation1[col][row+1] == CellStatus.Active ))
            activeCount++;

        if( (col+1) < cols && (row-1) >= 0 && (generation1[col+1][row-1] == CellStatus.Active))
            activeCount++;
        if( (col+1) < cols  && (generation1[col+1][row] == CellStatus.Active))
            activeCount++;
        if( (col+1) < cols && (row+1) < rows && (generation1[col+1][row+1] == CellStatus.Active))
            activeCount++;

        if(activeCount == 3) {
            generation2[col][row] = CellStatus.Active;
        } else if(activeCount == 2) {
            generation2[col][row] = generation1[col][row];
        } else {
            generation2[col][row] = CellStatus.dead;
        }

        return activeCount;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g) ;
        for (int i=0 ; i < rows; i++ ) {
            for (int j = 0; j < cols; j++) {
                if (generation1[i][j] == CellStatus.Active) {
                    g.fillRect(j * 10, i * 10, 10, 10);
                } else {
                    g.drawRect(j * 10, i * 10, 10, 10);
                }
            }
        }
    }

    /**
     * 终止开启线程刷新
     */
    public void cancle() {
        isCancel = true;
    }
    public void Start() {
        isCancel = false;
    }
    public void sleep() throws InterruptedException {
        int rate = (int) frequenceRate * 1000;
        Thread.sleep(rate);
    }

    public float getFrequenceRate() {
        return frequenceRate;
    }

    /**
     * 修改刷新得频率，默认1s
     * @param frequenceRate
     */
    public void setFrequenceRate(float frequenceRate) {
        if(frequenceRate > 0 && frequenceRate < 10){
            this.frequenceRate = frequenceRate;
        } else {
            return ;
        }
    }

    /**
     * 单元测试需要的参数
     * @return
     */
    public CellStatus[][] getGeneration1() {
        return generation1;
    }

    public CellStatus[][] getGeneration2() {
        return generation2;
    }
}
