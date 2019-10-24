package design_pattern.singleTon;

/**
 * @author lihaoyu
 * @date 2019/9/27 8:51
 */


class SingleTon1{
    private SingleTon1(){}
    private static SingleTon1 instance = new SingleTon1();
    public static SingleTon1 getInstance(){return instance;}
}

class SingleTon2{
    private SingleTon2(){}
    private static volatile SingleTon2 instance;
    public static SingleTon2 getInstance(){
        if(instance != null){
            synchronized (SingleTon2.class){
                if(instance != null){
                    instance = new SingleTon2();
                }
            }
        }
        return instance;
    }
}

class SingleTon3{
    private SingleTon3(){}
    private static class Handler{
        private static SingleTon3 instance = new SingleTon3();
    }

    public static SingleTon3 getInstance(){
        return Handler.instance;
    }
}

enum SingleTon4{
    /***
     *
     */
    INSTANCE;
}



public class SingleTonTest {

    public static void main(String[] args) {
    }

}
