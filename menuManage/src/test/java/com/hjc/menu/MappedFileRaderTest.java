package com.hjc.menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 存在问题，只是字节码的读取若需要字符的话呢？且转换
 * 因分块 65536个字节问题。存在将一个字符分成2部分，导致乱码问题
 * Created by Bravowhale on 2017/7/18.
 */
public class MappedFileRaderTest {
    private FileInputStream fileIn;
    private MappedByteBuffer mappedByteBuffer;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public MappedFileRaderTest(String fileName, int arraySize) throws IOException {
        this.fileIn = new FileInputStream(fileName);
        FileChannel fileChannel = fileIn.getChannel();
        this.fileLength = fileChannel.size();
        this.mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY,0,fileLength);
        this.arraySize = arraySize;
    }

    public int read() throws IOException{
        int limit = mappedByteBuffer.limit();
        int position = mappedByteBuffer.position();
        if (position == limit){
            return -1;
        }
        if (limit - position > arraySize){
            array = new byte[arraySize];
            mappedByteBuffer.get(array);
            return arraySize;
        }else {
            array = new byte[limit - position];
            mappedByteBuffer.get(array);
            return limit - position;
        }
    }
    public void close() throws IOException{
        fileIn.close();
        array = null;
    }
    public byte[] getArray(){
        return array;
    }
    public long getFileLength(){
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        MappedFileRaderTest reader = new MappedFileRaderTest("",65536);
        long start = System.nanoTime();
        while (reader.read() != -1);
        long end = System.nanoTime();
        reader.close();
        System.out.println(""+(end-start));
    }
}
