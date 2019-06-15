package com.thoughtworks.GameOfLife.Import;

public class ImportSpeed {

    private final static float DEFAULT_TIME = 0.05F;

    public static int convertInttoSecond(int num) {
        num = Math.max(1, num);
        int actualMillSeconds = num * (int) (DEFAULT_TIME * 1000);
        return actualMillSeconds;
    }
}
