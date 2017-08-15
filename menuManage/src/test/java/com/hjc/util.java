package com.hjc;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Bravowhale on 2017/7/19.
 */
public class util {
    public static void main(String[] args) throws IOException, URISyntaxException {
        new util().searchSpFile("D:\\");
    }
    public void searchSpFile(String path) throws URISyntaxException, IOException {
        Files.walkFileTree(Paths.get(path),new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("访问文件："+file.getFileName());
                if(file.endsWith("spring-boot-reference.pdf")){
                    return FileVisitResult.TERMINATE;
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(dir);
                System.out.println(dir.equals(Paths.get("D:","$RECYCLE.BIN")));
                if (dir.equals(Paths.get("D:","$RECYCLE.BIN"))){//dir.equals("D:\\$RECYCLE.BIN")){
                    return FileVisitResult.SKIP_SUBTREE;
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
