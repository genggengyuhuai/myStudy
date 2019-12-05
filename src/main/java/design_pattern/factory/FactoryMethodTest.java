package design_pattern.factory;

/**
 * @author lihaoyu
 * @date 2019/12/5 20:47
 */

abstract class Product{
    public abstract void Show();
}
//具体产品A类
class  ProductA extends  Product{
    @Override
    public void Show() {
        System.out.println("生产出了产品A");
    }
}

//具体产品B类
class  ProductB extends  Product{

    @Override
    public void Show() {
        System.out.println("生产出了产品B");
    }
}

abstract class Factory{
    public abstract Product Manufacture();
}

//工厂A类 - 生产A类产品
class  FactoryA extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}

//工厂B类 - 生产B类产品
class  FactoryB extends Factory{
    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
public class FactoryMethodTest {

    public static void main(String[] args) {
        Factory factory = new FactoryB();
        factory.Manufacture().Show();
    }
}
