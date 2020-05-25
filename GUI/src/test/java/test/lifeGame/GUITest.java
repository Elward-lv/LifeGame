package test.lifeGame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

/**
 * 测试运行GUI的问题
 */
public class GUITest {
    private GUI gui;

    @Before
    public void setUp() throws Exception {
        gui = new GUI();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void init() {
        gui.init();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}