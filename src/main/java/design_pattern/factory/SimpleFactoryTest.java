package design_pattern.factory;


interface Fruit{
    void print();
}

class Apple implements Fruit{
    @Override
    public void print() {
        System.out.println("我是苹果");
    }
}

class Banana implements Fruit{

    @Override
    public void print() {
        System.out.println("我是香蕉");
    }
}

enum FruitFactory{
    INSTANCE;

    public Fruit createFruitByName(String fruitName){
        if(fruitName == null) return null;
        else if (fruitName.equalsIgnoreCase("apple")){
            return new Apple();
        }
        else if(fruitName.equalsIgnoreCase("banana")){
            return new Banana();
        }
        return null;
    }
}


public class SimpleFactoryTest {

    public static void main(String[] args) {
    FruitFactory factory = FruitFactory.INSTANCE;
        Fruit fruit = factory.createFruitByName("apple");
        fruit.print();
    }



}
