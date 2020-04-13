package chapter5;

/**
 * @Auther lujieni
 * @Date 2020/4/13
 */
public class Gate {
    private int counter=0;
    private String name="Nobody";
    private String address="Nowhere";

    /**
     * pass方法将变量赋值到了成员变量
     * @param name
     * @param address
     */
    public synchronized void pass(String name,String address){
        this.counter++;
        this.name=name;
        this.address=address;
        vertify();
    }

    private void vertify(){
        if(this.name.charAt(0)!=this.address.charAt(0)){
            System.out.println("*****BROKEN*****"+toString());
        }
    }

    @Override
    public String toString(){
        return "No."+counter+":"+name+","+address;
    }

}
