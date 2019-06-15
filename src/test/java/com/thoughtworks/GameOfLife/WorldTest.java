package com.thoughtworks.GameOfLife;

import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {
    int [][] matrix= {{0,0,0,1,0,0},
            {0,0,1,0,0,0},
            {1,0,0,0,1,0},
            {0,0,0,1,0,0},
            {0,1,0,0,0,0}};
    int [][] matrixNext= {{0,0,0,0,0,0},
            {0,0,0,1,0,0},
            {0,0,0,1,0,0},
            {0,0,0,0,0,0},
            {0,0,0,0,0,0}};

    @Test
    public void generation() {
           assertArrayEquals(matrixNext,new World().generation());
    }


    @Test
    public void countNeighbour() {
    }

    @Test
    public void getCellState() {


    }
}