package com.thoughtworks.GameOfLife.Utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class isPathLegalTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void isPathLegal() {
        String right = "C:\\Users\\TWODOG\\Desktop\\test.txt";
        String wrong = "46";
        assertTrue(PathUtils.isPathLegal(right) == true);
        assertTrue(PathUtils.isPathLegal(wrong) == false);

    }
}