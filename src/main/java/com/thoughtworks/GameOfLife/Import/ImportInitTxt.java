package com.thoughtworks.GameOfLife.Import;

import com.thoughtworks.GameOfLife.World;

import java.io.*;
//（1） 导入初始化
public class ImportInitTxt {
    /**
    读取txt文件，并返回对应int二维数组大小的World。
    @params: String txtPath 传入的txt文件路径
    @return: World 返回txtPath内数组大小对应的World对象
    @author: zhangyi
    @data: 2019/6/16
     */
    public static World convertTxttoMatrix(String txtPath) {
        int width = 0, height = 0;
        World world=null;
        int[][] res = null;
        BufferedReader bf=null;

        try {
            File txt = new File(txtPath);
            InputStreamReader reader = new InputStreamReader((new FileInputStream(txt)));
             bf = new BufferedReader(reader);
            String str;

            int temp = -1;

            while ((str = bf.readLine()) != null) {
                String[] nums = str.split("\\D+");
                if (temp == -1) {
                   height=  Integer.valueOf(nums[0]);
                    width=Integer.valueOf(nums[1]);
                    res = new int[height][width];
                } else {
                    for (int i = 0; i < nums.length; i++) {
                        res[temp][i] = Integer.valueOf(nums[i]);
                    }
                }
                temp++;
            }
            world=new World(height,width,res);

        } catch (IOException e) {
            System.out.println("Error! No Such Path txt Found!");
        }

        return world;
    }

    /**
    随机初始化
    @param:
    @return:
    @author:
    @data:2019/6/16
     */
    public static World randomInitWorld(){
        int random_height = (int)(Math.random()*100);//高是行数
        //int random_width = (int)(Math.random()*40);
        int random_width=random_height;

        int[][] world_random = new int[random_height][random_width];
        for(int i=0; i<random_height; i++){
            for(int j=0; j<random_width; j++){
                world_random[i][j] = Math.random()>0.85?1:0;
            }
        }

        World world = new World(random_height, random_width, world_random);
        return world;
    }
}
