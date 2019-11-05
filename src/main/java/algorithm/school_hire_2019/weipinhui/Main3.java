package algorithm.school_hire_2019.weipinhui;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/4 11:36
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.next(),2);
        int num2 = Integer.parseInt(scanner.next(),2);
        System.out.println(Integer.toBinaryString(num1 + num2));

    }
}
