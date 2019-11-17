package algorithm.school_hire_2019.xiaomi;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 小米	求整数的阶乘	706	18.78%
 * @author lihaoyu
 * @date 2019/11/16 9:48
 */
public class Main28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nextInt = scanner.nextInt();
        BigInteger res = new BigInteger("1");
        for (int i = 2; i <= nextInt; i++) {
            res = res.multiply(new BigInteger(i+""));
        }
        System.out.println(res);
    }
}
