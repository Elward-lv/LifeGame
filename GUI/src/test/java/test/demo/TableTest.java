package test.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TableTest {
    private static Table  table= new Table();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void initUI() {
        System.out.println("开始测试init方法");
        table.initUI();
        table.setVisible(true);
    }

    @Test
    public void main() {
    }
}