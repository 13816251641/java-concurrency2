package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/23
 */
public class Test {

    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.init();

        new MakerClientThread(activeObject,"Alice").start();
        new MakerClientThread(activeObject,"Bobby").start();

        new DisplayClientThread("Chris",activeObject).start();

    }
}


