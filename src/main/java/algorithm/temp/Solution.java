package algorithm.temp;


import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */

class Temp{
    public int sum = 1;
    public Temp() {
        System.out.println("Temp类构造函数");
    }
}

class Lihaoyu{
    public static final int count = 2;

    public static final Temp temp = new Temp();
    static {
        System.out.println("静态的");
    }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Lihaoyu.count);
        System.out.println(Lihaoyu.temp);
//        Lihaoyu.temp.sum++;
//        System.out.println(Lihaoyu.temp.sum);
    }

}