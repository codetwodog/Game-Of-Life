package com.thoughtworks.GameOfLife;


public class World {
    private final static String DEFAULT_TXT_PATH = "src/Resource/default.txt";
    /*
    二维数组的宽
     */
    private int width;
    /*
    二维数组的高
     */
    private int height;
    /*
    二维数组
     */
    private int[][] matrix;
    /*
    获取二维数组的宽
    @param:
    @return: int 返回二维数组的宽
     */
    public int getWidth() {
        return width;
    }
    /*
    设置二维数组的宽
    @param：int width 二维数组的宽
    @return：void
     */
    public void setWidth(int width) {
        this.width = width;
    }
    /*
    获取二维数组的高
    @param：
    @return： int 返回二维数组的高
     */
    public int getHeight() {
        return height;
    }
    /*
    设置二维数组的高
    @param：int width 二维数组的高
    @return：void
     */
    public void setHeight(int height) {
        this.height = height;
    }
    /*
    获取二维数组
    @param
    @return： int[][] 返回二维数组
     */
    public int[][] getMatrix() {
        return matrix;
    }
    /*
    设置二维数组
    @param：int[][] matrix
    @return：
     */
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    /*
    无参构造函数
     */
    public World() {
        this.width = 200;//列数
        this.height = 100;//行数
    }
    /*
    根据传入的二维数组构造
     */
    public World(int[][] matrix) {
        this.width = matrix[0].length;
        this.height = matrix.length;
        this.matrix = matrix;
    }
    /*
    根据传入的二维数组与指定的宽和高构造
     */
    public World(int height, int width, int[][] matrix) {
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    /*
    根据Game Of Life 的规则，计算下一代二维数组中cell的存货状态
     */
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

    /*
    获取某个cell的周围细胞的存货数量
    @param: int x, cell 的横坐标
    @param: int y, cell 的纵坐标
    @return:int res, cell 周围8个位子其他cell存活的数量
    @author: zhangyi
    @data: 2019/6/16
     */
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

    /*
    根据cell的x、y坐标，获取cell的存货状态
    @param: int x, cell 的横坐标
    @param: int y, cell 的纵坐标
    @return： int 细胞的存活状态，0：死亡；1：存活
    @author: zhangyi
    @data: 2019/6/16
     */
    public int getCellState(int x, int y) {
        if (x < 0 || x >= this.height || y < 0 || y >= this.width) {
            return 0;
        } else {
            return this.matrix[x][y];
        }
    }

    /*
    打印二维数组matrix
    @param： int[][] 需要打印的matrix
    @return: void
    @author: zhangyi
    @data: 2019/6/16
     */
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println();
    }

    /*
    Game of Cell V1.0 控制台版本
     */
    public static void main(String[] args) {
        System.out.println("Please Input Your Init Txt Path And Speed in Two Lines:");



    }

}
