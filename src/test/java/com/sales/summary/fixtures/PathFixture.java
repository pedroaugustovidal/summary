package com.sales.summary.fixtures;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathFixture {

    static final String path = "src/test/resources/";
    static final String input = "file.dat";
    static final String output = "file.done.dat";

    public static Path gimmeInputPath() {
        return Paths.get(path + input);
    }

    public static Path gimmeOutputPath() {
        return Paths.get(path + output);
    }

}
