package test.lifeGame;

import org.junit.After;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class TestThreadRun {
    private gameDemo game = new gameDemo(10,10);
    Thread thread;

    @After
    public void tearDown() throws Exception{
        thread.stop();
    }

    /**
     * 测试根据规则改变矩阵线程的函数
     */
    @Test
    public void run() {
        thread = new Thread(game);
        thread.start();
    }
}