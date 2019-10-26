package algorithm.school_hire_2019.netesay;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 表达式求值
 * @author lihaoyu
 * @date 2019/9/18 13:47
 */
public class Main13 {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     int[] num = new int[3];
     num[0] = scanner.nextInt();
     num[1] = scanner.nextInt();
     num[2] = scanner.nextInt();
        Arrays.sort(num);
        if(num[2] == 1){
            System.out.println(3);
        }
        else{
            int a = num[0] + num[1];
            int b = num[0] * num[1];
            int res = num[2] * (a > b ? a : b );
            System.out.println(res);
        }

    }

}
