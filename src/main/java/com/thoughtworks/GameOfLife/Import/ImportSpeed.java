package com.thoughtworks.GameOfLife.Import;

public class ImportSpeed {

    private final static int DEFAULT_TIME = 1500;

    public static int convertInttoSecond(int num) {
        int gear = DEFAULT_TIME - 50 * num;
        return gear;
    }
}
