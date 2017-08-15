package com.hjc.menu;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by Bravowhale on 2017/7/18.
 */
public class ChannelFileReaderTest {

    private FileInputStream fileIn;
    private ByteBuffer byteBuffer;
    private long fileLength;
    private int arraySize;
    private byte[] array;

    public ChannelFileReaderTest(String fileName,int arraySize) throws IOException {
        this.fileIn = new FileInputStream(fileName);
        this.fileLength = fileIn.getChannel().size();
        this.arraySize = arraySize;
        this.byteBuffer = ByteBuffer.allocate(arraySize);
    }

    public int read() throws IOException{
        FileChannel fileChannel = fileIn.getChannel();
        int bytes = fileChannel.read(byteBuffer);
        if (bytes != -1){
            array = new byte[bytes];
            byteBuffer.flip();
            byteBuffer.get(array);
            byteBuffer.clear();
            return bytes;
        }
        return -1;
    }

    private void close() throws IOException{
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
        ChannelFileReaderTest reader = new ChannelFileReaderTest("",65535);
        long start = System.nanoTime();
        while (reader.read() != -1){

        }
        long end = System.nanoTime();
        reader.close();
        System.out.println(""+(end - start));
    }
}
