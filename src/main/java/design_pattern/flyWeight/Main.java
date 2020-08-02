package design_pattern.flyWeight;

import java.util.HashMap;

/**
 * 享元模式   共享对象  例如 JDK 中的字符串，例如连接池    注意划分外部状态和内部状态
 * 这里的例子是，
 * @author lihaoyu
 * @date 2019/12/5 17:49
 */

class Port{
    int portNumber;

    public Port(int portNumber) {
        this.portNumber = portNumber;
    }
    public int getPortNumber() {
        return portNumber;
    }
    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }
}

interface NetworkDevice{
    String getType();
    void getUse(Port port);

}

class Switch implements NetworkDevice{
    String type;
    @Override
    public String getType() {
        System.out.println(type);
        return type;
    }
    @Override
    public void getUse(Port port) {
        System.out.println("使用的端口号是 "+port.portNumber);
    }
}

class Hub implements NetworkDevice{
    String type;
    @Override
    public String getType() {
        System.out.println(type);
        return type;
    }
    @Override
    public void getUse(Port port) {
        System.out.println("使用的端口号是 "+port.portNumber);
    }
}


// 生产享元类的工厂(单例模式)
class FlyWeightFactory{
    private static final HashMap<String, NetworkDevice> circleMap = new HashMap<>();
    private static FlyWeightFactory instance = new FlyWeightFactory();
    private FlyWeightFactory() {
    }
    public static FlyWeightFactory getInstance(){
        return instance;
    }

    NetworkDevice getDevice(String type){
        NetworkDevice device = circleMap.get(type);
        if(device != null){
            System.out.println("取出对象 "+ device);
        }else{
            System.out.println("创建对象 ");
            if("hub".equals(type)){
                device = new Hub();
                circleMap.put(type, device);
            }else{
                device = new Switch();
                circleMap.put(type, device);
            }
        }
        return device;
    }

}




public class Main {


    public static void main(String[] args) {
        FlyWeightFactory factory = FlyWeightFactory.getInstance();
        NetworkDevice hub = factory.getDevice("hub");
        hub.getUse(new Port(20));
        NetworkDevice hub2 = factory.getDevice("hub");
        hub2.getUse(new Port(20));
    }
}
