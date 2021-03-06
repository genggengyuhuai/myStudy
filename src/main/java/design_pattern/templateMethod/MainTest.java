package design_pattern.templateMethod;

/**
 * 子类来决定如何实现算法的某些步骤
 *
 *
 * 模板方法和策略模式的不同。模板是多个算法组成的流程，强调骨架。
 * 策略模式是具体的完整算法。
 *
 * 场景: 制作咖啡有四个步骤，1,2,3,4
 *      制作茶也有四个步骤  1,a,3,b
 * 有两个相同的方法和不同的，可以抽象出来。
 *
 * @author lihaoyu
 * @date 2019/10/25 10:36
 */

abstract class Beverage{

    public void makeBeverage(){
        System.out.println("开始制作饮料");
        p1();
        p2();
        p3();
        p4();
    }

    private void p1(){
        System.out.println("倒水");
    }

    private void p3(){
        System.out.println("加热");
    }

    abstract public void p2();

    abstract public void p4();
}

class Coffee extends Beverage{

    @Override
    public void p2() {
        System.out.println("加咖啡");
    }
    @Override
    public void p4() {
        System.out.println("准备咖啡杯");
    }
}

class Tea extends Beverage{
    @Override
    public void p2() {
        System.out.println("加茶叶");
    }
    @Override
    public void p4() {
        System.out.println("准备茶具");
    }
}



public class MainTest {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        coffee.makeBeverage();
        System.out.println("------");
        Beverage tea = new Tea();
        tea.makeBeverage();
    }
}
