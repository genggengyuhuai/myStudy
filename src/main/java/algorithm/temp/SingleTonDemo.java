package algorithm.temp;


/**
 * @author lihaoyu
 * @date 2019/11/11 19:22
 */
public class SingleTonDemo {
    // 构造函数私有化
    private SingleTonDemo(){}
    // 静态内部类被调用时才加载
    private static class Handler{
        private static SingleTonDemo instance = new SingleTonDemo();
    }
    public static SingleTonDemo getInstance(){
        return Handler.instance;
    }
    public static void main(String[] args) {
        SingleTonDemo instance = getInstance();
    }
}
