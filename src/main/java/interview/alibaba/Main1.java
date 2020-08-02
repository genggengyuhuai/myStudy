package interview.alibaba;

import java.util.Scanner;

/**
 * 计算  kCnk 求和
 * @author lihaoyu
 * @date 3/23/2020 6:50 PM
 */
public class Main1 {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long res = 0;
            long temp = 1;
            for (int k = 1; k <= n; k++) {
                temp = temp * (n - k + 1) / k;
                temp %= 1000000007;
                res += k * temp;
                res %= 1000000007;
            }
            System.out.println(res);
        }
    }
}
