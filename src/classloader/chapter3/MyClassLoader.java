package classloader.chapter3;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 继承ClassLoader且一定要实现findClass
 */
public class MyClassLoader extends ClassLoader {

    private static final String DEFAULT_DIR = "F:\\classloader";

    private String dir = DEFAULT_DIR;

    private String classLoaderName;

    public MyClassLoader(){
        super();
    }

    public MyClassLoader(String classLoaderName){
        super();
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(String classLoaderName,ClassLoader parent){
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * 必须重写findClass
     * xxx.xxx.xxx.xxx.AAA
     * xxx/xxx/xxx/xxx/AAA.class
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".","/");
        File classFile = new File(dir,classPath+".class");
        if(!classFile.exists()){
            throw new ClassNotFoundException("The class "+name+" not found");
        }
        byte[] classBytes = loadClassBytes(classFile);
        if(null == classBytes || classBytes.length == 0){
            throw new ClassNotFoundException("load the class "+name+" failed");
        }
        return super.defineClass(name,classBytes,0,classBytes.length);
    }

    private byte[] loadClassBytes(File classFile){
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
            FileInputStream fis = new FileInputStream(classFile)) {
                byte[] buffer = new byte[1024];
                int len = 0;
                while ((len=fis.read(buffer))!=-1){
                    baos.write(buffer,0,len);
                }
                baos.flush();//好习惯
                return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}