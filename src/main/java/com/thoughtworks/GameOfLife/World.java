package  com.thoughtworks.GameOfLife;
public class World {
    //数组的宽,高，二维矩阵
    private int width;

    private int height;

    private int[][] matrix;

    public World(){
       this.width = 200;
       this.height = 100;
    }

    public World(int width, int height,int [][] matrix){
        this.width = width;
        this.height = height;
        this.matrix = matrix;
    }

    public int[][] generation(){
        int[][] temp = new int[this.width][this.height];

        for(int i=0; i<this.width; i++) {
            for(int j=0; j<this.height; j++) {
                int count = countNeighbour(i, j);
                if(count == 3) {
                    temp[i][j] = 1;
                } else if(matrix[i][j] == 1 && count == 2) {
                    temp[i][j] = 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }

        this.matrix = temp;
        return  matrix;
    }

    public int countNeighbour(int x, int y){
        int res = 0;

        res += getCellState(x-1, y-1);
        res += getCellState(x-1, y);
        res += getCellState(x-1, y+1);
        res += getCellState(x, y-1);
        res += getCellState(x, y+1);
        res += getCellState(x+1, y-1);
        res += getCellState(x+1, y);
        res += getCellState(x+1, y+1);

        return res;
    }

    public  int getCellState(int x, int y){
        if(x < 0 || x >= this.width || y < 0 || y >= this.height) {
            return 0;
        } else {
            return this.matrix[x][y];
        }
    }

}
