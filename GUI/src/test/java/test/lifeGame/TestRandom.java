package test.lifeGame;

import org.junit.Assert;
import org.junit.Test;
/**
 * 测试随机生成函数
 */
public class TestRandom {
    private   gameDemo game = new gameDemo(50,50);

    /**
     * 验证输入生成矩阵的参数
     * 正确范围是0-50
     */
    @Test
    public void generationRandom() {
        game.generationRandom(20,30);
        Assert.assertEquals(game.getGeneration1()[0].length,20);
        Assert.assertEquals(game.getGeneration1().length,30);
    }

    /**
     * 边界范围
     */
    @Test
    public void generationRandom2(){
        game.generationRandom(50,50);
        Assert.assertEquals(game.getGeneration1()[0].length,50);
        Assert.assertEquals(game.getGeneration1().length,50);
    }

    /**
     *越界范围小于  可能产生数组越界异常 NegativeArraySizeException
     */
    @Test(expected = NegativeArraySizeException.class)
    public void generationRandom3(){
        game.generationRandom(-1,-1);
    }

    /**
     * 越界范围大于  没有问题  被处理
     */
    @Test
    public void generationRandomOut(){
        game.generationRandom(51,51);
    }


}