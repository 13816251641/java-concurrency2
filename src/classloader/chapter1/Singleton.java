package classloader.chapter1;

/**
 * @Auther lujieni
 * @Date 2020/7/1
 *
 * 加载->链接(校验,准备,解析)->初始化
 *
 * 从上至下
 * 先链接(准备) 再初始化
 *
 * Singleton instance = null (准备阶段)
 * x=0(准备阶段)
 * y=0(准备阶段)
 *
 * Singleton instance = new Singleton() (初始化阶段)
 * 执行代码块(初始化阶段)
 * 执行Singleton(){}构造函数,x和y变为1,1 (初始化阶段)
 * 随后在静态代码块中把300赋值给x (初始化阶段)
 *
 */
public class Singleton {

    private Singleton(){
        x++;//0->1
        y++;//0->1
    }

    private static Singleton instance = new Singleton();

    static {
        /*
           static代码块的执行是在初始化阶段进行的
         */
        System.out.println("static块");
        /*
            因为static在x之前,所以不能读取x!!!,但能进行赋值
            System.out.println(x);
         */
        x = 300;
    }

    private static int x = 50;

    {
        System.out.println("代码块");
    }




    private static int y;


    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(y);
    }
}
