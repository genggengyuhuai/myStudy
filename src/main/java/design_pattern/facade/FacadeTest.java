package design_pattern.facade;

/**
 * 门面模式   例如 slf4j  日志
 * @author lihaoyu
 * @date 2/9/2020 3:20 PM
 */

interface Shape{
    void draw();
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}

class ShapeFacade{
    private Circle circle;
    private Rectangle rectangle;

    public ShapeFacade() {
        this.circle = new Circle();
        this.rectangle = new Rectangle();
    }

    public void drawCircle(){
       circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
}

public class FacadeTest {

    public static void main(String[] args) {
        // 传统方法
        Shape shape = new Circle();
        shape.draw();
        Shape shape2 = new Rectangle();
        shape2.draw();

        // 门面模式
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCircle();
        shapeFacade.drawRectangle();;

    }
}
