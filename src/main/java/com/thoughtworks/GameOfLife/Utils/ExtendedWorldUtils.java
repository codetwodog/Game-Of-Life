package com.thoughtworks.GameOfLife.Utils;

import com.thoughtworks.GameOfLife.World;

public class ExtendedWorldUtils {
    public static World extendedworld(World world) {
        int rows = world.getHeight();
        int cols = world.getWidth();
        int[][] matrix = world.getMatrix();
        int extendValue = (int) (Math.random() * 25);
        int[][] matrixExtend = new int[rows + 2*extendValue][cols + 2*extendValue];
        for (int i = 0; i < matrixExtend.length; i++)
            for (int j = 0; i < matrixExtend[0].length; i++) {
                     matrixExtend[i][j]=0;
            }
        for(int i=0;i<matrix.length;i++)
            for (int j = 0; j <matrix[0].length ; j++) {
            matrixExtend[extendValue+i][extendValue+j]=matrix[i][j];
            }
        return  new World(rows+2*extendValue,cols+2*extendValue,matrixExtend);

    }


}
