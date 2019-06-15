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
        World  world = new World(matrix.length, matrix[0].length, matrix);
        world.generation();
        assertArrayEquals(matrixNext,world.getMatrix());
    }


    @Test
    public void countNeighbour() {
    }

    @Test
    public void getCellState() {


    }
}