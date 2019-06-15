package com.thoughtworks.GameOfLife.Utils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ImportInitTxtTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void convertTxttoMatrix() {
        int[][] matrix = {
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {1, 0, 1, 0, 1, 0}};
        int width = 8, height = 6;
        String s = "C:\\Users\\TWODOG\\Desktop\\test.txt";
        //Scanner sc = new Scanner(System.in);
        //s = sc.nextLine();


        //前两个数字判断，
        assertArrayEquals(matrix, new ImportInitTxt().convertTxttoMatrix(s));


    }
}