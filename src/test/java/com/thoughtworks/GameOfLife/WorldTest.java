package com.thoughtworks.GameOfLife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorldTest {

    private World world;

    int[][] matrix = {
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0}};
    int[][] matrixNext = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};

    @Before
    public void init() {
        this.world = new World(matrix.length, matrix[0].length, matrix);
    }

    @Test
    public void generation() {
        this.world.generation();
        assertArrayEquals(matrixNext, world.getMatrix());
    }


    @Test
    public void countNeighbour() {
        assertEquals(3, this.world.countNeighbour(2, 3));
    }

    @Test
    public void getCellState() {
        //边界
        assertEquals(0, this.world.getCellState(-1, 0));
        assertEquals(1, this.world.getCellState(0, 3));
        assertEquals(0, this.world.getCellState(0, 0));
    }
}