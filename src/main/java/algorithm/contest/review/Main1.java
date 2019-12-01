package algorithm.contest.review;

import java.util.Scanner;

/**
 * 硬币最小数量 http://172.19.241.251/problem/Gre-4
 * @author lihaoyu
 * @date 2019/11/30 15:41
 */
public class Main1 {

    private static long fun(long number){
        if(number <= 10) return number;
        long temp = 11;
        while(2*temp+1 < number){
            temp = 2* temp + 1;
        }
        return number - temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long l = scanner.nextLong();
            long temp = (l - 1) % 12;
            if(temp >= 0 && temp <= 4){
                System.out.println(temp+1);
            }else if(temp == 5 || temp == 11){
                System.out.println("$");
            }else{
                System.out.println(11 - temp);
            }
        }

    }
}
