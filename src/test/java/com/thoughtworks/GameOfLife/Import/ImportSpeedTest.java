package com.thoughtworks.GameOfLife.Import;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImportSpeedTest {

    @Test
    public void convertInttoSecond() {
        int num=20;
        assertEquals(1000,ImportSpeed.convertInttoSecond(num));
    }
}