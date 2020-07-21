package classloader.chapter4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class EncryptUtils {
    private static final byte ENCRYPT_FACTOR = (byte) 0xff;
    private EncryptUtils(){

    }

    public static void doEncrypt(String source,String target){
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(target)){
            int content=-1;
            while ((content=fis.read()) != -1){
                fos.write(content ^ ENCRYPT_FACTOR);

            }
        }catch (FileNotFoundException e){

        }catch (IOException e){

        }

    }

    public static void main(String[] args) {
        doEncrypt("f:/a.txt","f:/b.txt");
    }



}