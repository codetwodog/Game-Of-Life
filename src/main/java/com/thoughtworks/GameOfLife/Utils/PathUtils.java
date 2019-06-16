package com.thoughtworks.GameOfLife.Utils;

import java.util.regex.Pattern;

public class PathUtils {
    /**
    正则表达式，匹配传入的txt文件路径是否是合法的。
     */
    private final static String FilePathRegex = "^(?<path>(?:[a-zA-Z]:)" +
            "?\\\\(?:[^\\\\\\?\\/\\*\\|<>:\"]+\\\\)+)(?<filename>(?<name>" +
            "[^\\\\\\?\\/\\*\\|<>:\"]+?)\\.(?<ext>[^.\\\\\\?\\/\\*\\|<>:\"]+))$";

    /**
    根据正则表达式判断输入的txt路径是否合法。
    @param: String path, 传入的txt路径
    @return: boolean 返回传入的txt路径是否合法
    @author: zhangyi
    @data: 2019/6/16
     */
    public static boolean isPathLegal(String path) {
        return Pattern.matches(FilePathRegex, path);
    }
}
