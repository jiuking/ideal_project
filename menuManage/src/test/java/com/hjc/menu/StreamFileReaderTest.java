package com.hjc.menu;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Bravowhale on 2017/7/18.
 */
public class StreamFileReaderTest {
    private BufferedInputStream fileIn;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public StreamFileReaderTest(String fileName, int arraySize) throws IOException {
        this.fileIn = new BufferedInputStream(new FileInputStream(fileName),arraySize);
        this.fileLength = fileIn.available();
        this.arraySize = arraySize;
    }

    public int read() throws IOException{
        byte[] tempArray = new byte[arraySize];
        int bytes = fileIn.read(tempArray);
        if(bytes != -1){
            array = new byte[bytes];
//            System.out.println(new String(array));
            System.arraycopy(tempArray,0,array,0,bytes);
            return bytes;
        }
        return -1;
    }

    public byte[] getBody(){
        return array;
    }

    public void close() throws IOException{
        fileIn.close();;
        array = null;
    }
    public long getFileLength(){
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        StreamFileReaderTest reader = new StreamFileReaderTest("D:\\武极巅峰.txt",65535);
        long start = System.nanoTime();
        while (reader.read() != -1){
            System.out.println(new String(reader.getBody(),"gbk"));
        }
        long end = System.nanoTime();
        reader.close();
        System.out.println("use time "+(end - start));
    }
}
