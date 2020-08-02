package design_pattern.factory;

/** 抽象工厂模式
 * 工厂方法也就是实例工厂，只有一类产品和对应的一个工厂
 * @author lihaoyu
 * @date 2019/9/20 9:16
 */

interface Mouse{
    void click();
}

interface KeyBoard{
    void input();
}

class XiaoMiMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("XiaoMi mouse");
    }
}

class XiaomiKeyBoard implements KeyBoard{
    @Override
    public void input() {
        System.out.println("XiaoMi keyboard");
    }
}

class AppleMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Apple mouse");
    }
}

class AppleKeyBoard implements KeyBoard{
    @Override
    public void input() {
        System.out.println("Apple keyboard");
    }
}

interface AbstractFactory{

     KeyBoard createKeyBoard();

     Mouse createMouse();
}

class AppleFactory implements AbstractFactory{
    private AppleFactory(){}

    private static class Handler{
        private static AppleFactory instance = new AppleFactory();
    }

    public static AppleFactory getInstance(){
        return Handler.instance;
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new AppleKeyBoard();
    }

    @Override
    public Mouse createMouse() {
        return new AppleMouse();
    }
}

class XiaoMiFactory implements AbstractFactory{

    private static volatile XiaoMiFactory instance;

    private XiaoMiFactory(){}

    public static XiaoMiFactory getInstance(){
        if(instance == null){
            synchronized (XiaoMiFactory.class){
                if(instance == null){
                    return new XiaoMiFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public KeyBoard createKeyBoard() {
        return new XiaomiKeyBoard();
    }

    @Override
    public Mouse createMouse() {
        return new XiaoMiMouse();
    }
}

public class FactoryTest {

    private static FactoryTest instance = new FactoryTest();

    private FactoryTest(){}

    public static FactoryTest getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        AbstractFactory factory = AppleFactory.getInstance();
        factory.createKeyBoard().input();
    }
}



