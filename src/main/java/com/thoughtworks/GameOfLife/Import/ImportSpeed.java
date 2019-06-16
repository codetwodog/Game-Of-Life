package com.thoughtworks.GameOfLife.Import;

public class ImportSpeed {

    private final static int DEFAULT_TIME = 1500;

    /**
    读取输入的speed档位，转化为系统对应的毫秒数
    @param: int num, 输入的速度档位
    @return: int actualMillSeconds: 档位对应的系统毫秒数
    @author: zhangyi
    @data: 2019/6/16
     */
    public static int convertInttoSecond(int num) {
        int gear = DEFAULT_TIME - 50 * num;
        return gear;
    }
}
