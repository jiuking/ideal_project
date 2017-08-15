package com.hjc.menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Bravowhale on 2017/7/18.
 */
public class MappedBiggerFileReaderTest {
    private MappedByteBuffer[] mappedByteBuffers;
    private int count = 0;
    private int number;
    private FileInputStream fileIn;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public MappedBiggerFileReaderTest(String fileName,int arraySize) throws IOException {
        this.fileIn = new FileInputStream(fileName);
        FileChannel fileChannel = fileIn.getChannel();
        this.fileLength = fileChannel.size();
        this.number = (int) Math.ceil((double)fileLength/Integer.MAX_VALUE);
        this.mappedByteBuffers = new MappedByteBuffer[number];
        long preLength = 0;
        long regionSize = (long)Integer.MAX_VALUE;
        for (int i = 0; i < number; i++) {
            if (fileLength - preLength < Integer.MAX_VALUE){
                regionSize = fileLength - preLength;
            }
            mappedByteBuffers[i] = fileChannel.map(FileChannel.MapMode.READ_ONLY,preLength,regionSize);
            preLength += regionSize;
        }
        this.arraySize = arraySize;
    }

    public int read() throws IOException{
        if (count >= number){
            return -1;
        }
        int limit = mappedByteBuffers[count].limit();
        int position = mappedByteBuffers[count].position();
        if(limit - position > arraySize){
            array = new byte[arraySize];
            mappedByteBuffers[count].get(array);
            return arraySize;
        }else {
            array = new byte[limit - position];
            mappedByteBuffers[count].get(array);
            if (count < number){
                count++;
            }
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
        /*MappedBiggerFileReaderTest reader = new MappedBiggerFileReaderTest("/home/zfh/movie.mkv", 65536);
        long start = System.nanoTime();
        while (reader.read() != -1) ;
        long end = System.nanoTime();
        reader.close();
        System.out.println("MappedBiggerFileReader: " + (end - start));*/

       File file = new File("D://");
        String[] fileList = file.list((dir, name) -> name.endsWith(".txt")||new File(name).isDirectory());
        for (String fileName : fileList) {
            System.out.println(fileName);
        }
//        File file1 = new File("D:\\360Downloads");
        //System.out.println(file1.isDirectory());
    }
}
