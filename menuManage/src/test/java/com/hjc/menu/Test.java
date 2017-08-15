package com.hjc.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Bravowhale on 2017/7/18.
 */
public class Test {
    public static void test() throws IOException {
        Path path = Paths.get("D:\\迅雷下载\\FQHY_GHOST_WIN7_SP1_X64_V2017_05.iso");
        byte[] data = Files.readAllBytes(path);
    }
    public static void main(String[] args) throws IOException {
        Test.test();
    }
}

