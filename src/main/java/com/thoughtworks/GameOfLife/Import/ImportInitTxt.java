package com.thoughtworks.GameOfLife.Import;

import java.io.*;

public class ImportInitTxt {

    public static int[][] convertTxttoMatrix(String txtPath) {
        int width = 0, height = 0;
        int[][] res = null;

        try {
            File txt = new File(txtPath);
            InputStreamReader reader = new InputStreamReader((new FileInputStream(txt)));
            BufferedReader bf = new BufferedReader(reader);
            String str;

            int temp = -1;

            while ((str = bf.readLine()) != null) {
                String[] nums = str.split("\\D+");
                if (temp == -1) {
                    width = Integer.valueOf(nums[0]);
                    height = Integer.valueOf(nums[1]);
                    res = new int[width][height];
                } else {
                    for (int i = 0; i < nums.length; i++) {
                        res[temp][i] = Integer.valueOf(nums[i]);
                    }
                }
                temp++;
            }

        } catch (IOException e) {
            System.out.println("Error! No Such Path txt Found!");
        }

        return res;
    }
}
