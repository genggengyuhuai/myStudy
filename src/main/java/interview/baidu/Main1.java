package interview.baidu;

import java.util.Scanner;

/**
 * 找出两个数 a,b < n， 使得 lcm(a,b) - gcd(a,b) 最大
 *  30 %
 * @author lihaoyu
 * @date 3/29/2020 6:57 PM
 */
public class Main1 {
    private static int gcd(int a, int b){
        int i = Math.min(a,b);
        while(i>=1){
            if(a % i == 0 && b % i == 0) break;
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 找最大的两个质数
        System.out.println(Math.max(n*(n-1) - gcd(n,n-1), (n-1)*(n-2) - gcd(n-1,n-2)));

    }
}
