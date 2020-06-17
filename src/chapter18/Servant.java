package chapter18;

/**
 * @Auther lujieni
 * @Date 2020/6/16
 */
public class Servant implements ActiveObject {

    @Override
    public Result makeString(int count, char fillChar) {
        char [] buf = new char[count];
        for(int i = 0; i < count;i++){
            buf[i] = fillChar;
            try{
                Thread.sleep(10);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {
        try{
            System.out.println("Display:"+text);
            Thread.sleep(10);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
