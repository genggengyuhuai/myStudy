package design_pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * 动态地给一个对象添加一些额外的职责
 *
 * 饮料   加柠檬，芒果等辅料
 *
 * Java中的 BufferedInputStream buffer = new BufferedInputStream(new FileInputStream());
 * @author lihaoyu
 * @date 2019/10/11 9:13
 */


interface Beverage{

    String getDescription();

    double cost();
}

class BlackTea implements Beverage{

    @Override
    public String getDescription() {
        return "红茶";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}


// 辅料 柠檬
class Lemon implements Beverage{

    private Beverage beverage;

    public Lemon(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,加柠檬";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

// 辅料 芒果
class Mango implements Beverage{

    private Beverage beverage;

    public Mango(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " ,加芒果";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.0;
    }
}

 class DecoratorTest{
    public static void main(String[] args) {
        // 加柠檬和芒果
        Beverage tea = new Mango(new Lemon(new BlackTea()));
        System.out.println(tea.getDescription());
        System.out.println(tea.cost());

    }
}