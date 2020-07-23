package classloader.chapter4;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DecryptClassLoader extends ClassLoader{

    private final static String DEFAULT_DIR = "F:/classloader";

    private String dir = DEFAULT_DIR;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public DecryptClassLoader(){

    }

    public DecryptClassLoader(ClassLoader parent){
        super(parent);
    }

    /**
     * name就是class文件中的包名+类名,必须和class文件中的相一致这点很重要!!!
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".","/");
        File classFile = new File(dir,classPath+".class");
        if(!classFile.exists()){
            throw new ClassNotFoundException("The class not found ");
        }
        byte[] classBytes = loadClassBytes(classFile);
        if(null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException("load the class failed");
        }
        return this.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] loadClassBytes(File classFile){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile)){
           int data = -1;
           while ((data=fis.read())!=-1){
               baos.write(data ^ EncryptUtils.ENCRYPT_FACTOR);
           }
           baos.flush();
           return baos.toByteArray();
        }catch (IOException e){
           return null;
        }
    }
}