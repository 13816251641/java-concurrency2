package classloader.chapter1;

/**
 * @Auther lujieni
 * @Date 2020/7/1
 * 从上至下
 * 先准备 再初始化
 *
 * x,y一开始都等于0(准备阶段)
 * 之后在Singleton(){}中变为1,1 (初始化阶段)
 * 随后再把50赋值给x (初始化阶段)
 */
public class Singleton {

    private Singleton(){
        x++;
        System.out.println(x);
        y++;
    }

    private static Singleton instance = new Singleton();

    static {
        /*
            static代码块的执行在初始化阶段进行
         */
        System.out.println("static块");
    }


    {
        System.out.println("代码块");
    }


    private static int x = 50;

    private static int y;


    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(x);
        System.out.println(y);
    }
}
