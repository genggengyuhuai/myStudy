package algorithm.school_hire_2019.shopee;

import java.util.Scanner;

/**
 * 给定一个字符串，输出所有指定长度为n的子串，没有则输出-1
 * @author lihaoyu
 * @date 2/2/2020 1:11 PM
 */
public class Temp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int m = scanner.nextInt();
        if(m > next.length() || m <= 0){
            System.out.println(-1);
            return;
        }
        for(int i = 0; i <= next.length() - m; i++){
            if(i==0)
            System.out.print(next.substring(i,i+m));
            else System.out.print(" "+next.substring(i,i+m));
        }
    }
}
