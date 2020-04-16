package chapter7;

/**
 * @Auther lujieni
 * @Date 2020/4/16
 */
public class StringTest {
    /*
        String是不可变对象
     */
    public static void main(String[] args) {
        String s="Hello";
        String s2=s.replace("l","k");
        System.out.println(s.hashCode()+"-"+s2.hashCode());
    }
}
