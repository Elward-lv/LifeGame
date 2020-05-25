package test.lifeGame;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 测试按照规则更新矩阵  以及判断方格周围格子状态
 */
public class TestChangeAndJudge {
    private gameDemo game = new gameDemo(10,10);

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");

    }

    /**
     * 检查换代函数的问题
     */
    @Test
    public void changeGeneration() {
        gameDemo.CellStatus[][] statuses = game.getGeneration1();
        showCellStatus(statuses);
        game.changeGeneration();
        showCellStatus(game.getGeneration1());
    }

    /**
     * 检查 检查细胞状态的函数
     * 输入值：矩阵中某个元素的坐标 合法范围 (0，0 )-> (col,row) = (10,10)
     * 返回值：周围活着细胞的个数
     *
     * 边界范围 (0,0)周围活细胞的个数
     */
    @Test
    public void judgeCellStatus() {
        showCellStatus(game.getGeneration1());
        int count = game.judgeCellStatus(0,0);
        System.out.println("count:"+count);

    }

    /**
     * 越界范围 （10，10）周围活细胞的个数
     * 错误：ArrayIndexOutOfBoundsException
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void judgeCellStatusOut() {
        int count = game.judgeCellStatus(10,10);
        System.out.println("count:"+count);
    }

    /**
     * 正常范围
     */
    @Test
    public void judgeCellStatusNormal() {
        game.judgeCellStatus(5,5);
    }


    public void showCellStatus(gameDemo.CellStatus[][] statuses){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.printf("%8s",statuses[i][j]);
            }
            System.out.println();
        }
        System.out.println("***********完成***************");
    }
}