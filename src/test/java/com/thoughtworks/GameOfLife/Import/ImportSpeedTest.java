package com.thoughtworks.GameOfLife.Import;

import org.junit.Test;

import static org.junit.Assert.*;

public class ImportSpeedTest {

    @Test
    public void convertInttoSecond() {
        assertEquals(1000,ImportSpeed.convertInttoSecond(20));
        assertEquals(500,ImportSpeed.convertInttoSecond(10));
        assertEquals(50,ImportSpeed.convertInttoSecond(1));
        assertEquals(50,ImportSpeed.convertInttoSecond(0));
    }
}