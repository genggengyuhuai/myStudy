package design_pattern.strategy;

/**
 *  封装可呼唤的行为，并使用委托决定使用哪一个
 *
 * @author Lihaoyu
 * @date 2019/11/8 11:28
 */

class Computer{
    private Algorithm algorithm;

    public Computer(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public void setAlgorithm(Algorithm algorithm){
        this.algorithm = algorithm;
    }

    public Computer(){
    }

    public int calculate(int num1, int num2){
        return algorithm.operate(num1, num2);
    }
}

interface Algorithm{
 int operate(int num1, int num2);
}

class AddOperation implements Algorithm{

    @Override
    public int operate(int num1, int num2) {
        return num1 + num2;
    }
}

class MultipleOperation implements Algorithm{

    @Override
    public int operate(int num1, int num2) {
        return num1 * num2;
    }
}


/**
 * @author lihaoyu
 * @date 2019/9/20 11:28
 */
public class Main {
    public static void main(String[] args) {
        Computer computer = new Computer(new AddOperation());
        System.out.println(computer.calculate(1,2));
    }
}
