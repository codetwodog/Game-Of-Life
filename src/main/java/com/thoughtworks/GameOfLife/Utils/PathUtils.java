package com.thoughtworks.GameOfLife.Utils;

import java.util.regex.Pattern;

public class PathUtils {
    private final static String FilePathRegex = "^(?<path>(?:[a-zA-Z]:)" +
            "?\\\\(?:[^\\\\\\?\\/\\*\\|<>:\"]+\\\\)+)(?<filename>(?<name>" +
            "[^\\\\\\?\\/\\*\\|<>:\"]+?)\\.(?<ext>[^.\\\\\\?\\/\\*\\|<>:\"]+))$";

    public static boolean isPathLegal(String path) {
        return Pattern.matches(FilePathRegex, path);
    }
}
