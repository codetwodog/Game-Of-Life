package com.thoughtworks.GameOfLife;


public class World {
    private final static String DEFAULT_TXT_PATH = "src/Resource/default.txt";


    private int width;

    private int height;

    private int[][] matrix;


    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }


    public World() {
        this.width = 200;//列数
        this.height = 100;//行数
    }

    public World(int[][] matrix) {
        this.width = matrix[0].length;
        this.height = matrix.length;
        this.matrix = matrix;
    }

    public World(int height, int width, int[][] matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public World generation() {
        int[][] temp = new int[this.height][this.width];

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                int count = countNeighbour(i, j);
                if (count == 3) {
                    temp[i][j] = 1;
                } else if (matrix[i][j] == 1 && count == 2) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        this.matrix = temp;
        this.height=height;
        this.width=width;
        return  this;

    }

    public int countNeighbour(int x, int y) {
        int res = 0;

        res += getCellState(x - 1, y - 1);
        res += getCellState(x - 1, y);
        res += getCellState(x - 1, y + 1);
        res += getCellState(x, y - 1);
        res += getCellState(x, y + 1);
        res += getCellState(x + 1, y - 1);
        res += getCellState(x + 1, y);
        res += getCellState(x + 1, y + 1);

        return res;
    }

    public int getCellState(int x, int y) {
        if (x < 0 || x >= this.height || y < 0 || y >= this.width) {
            return 0;
        } else {
            return this.matrix[x][y];
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Please Input Your Init Txt Path And Speed in Two Lines:");



    }

}
