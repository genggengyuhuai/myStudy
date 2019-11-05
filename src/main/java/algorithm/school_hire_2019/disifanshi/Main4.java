package algorithm.school_hire_2019.disifanshi;

import java.math.BigDecimal;
import java.util.Scanner;

/**给定两个数字（0-9）字符串（长度不限）求它们的乘积。
 * @author lihaoyu
 * @date 2019/11/5 13:38
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal num1 = new BigDecimal(scanner.next());
        BigDecimal num2 = new BigDecimal(scanner.next());
        BigDecimal multiply = num1.multiply(num2);
        System.out.println(multiply);
    }
}
