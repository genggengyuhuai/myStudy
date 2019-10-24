package algorithm.jiu_shi_gan.kuaishou;

import java.util.Arrays;
import java.util.Scanner;

/**
 *快手	字符串排序	1990	29.92%
 * 月神拿到一个新的数据集，其中每个样本都是一个字符串（长度小于100），
 * 样本的的后六位是纯数字，月神需要将所有样本的后六位数字提出来，转换成数字，并排序输出。
 *
 * @author lihaoyu
 * @date 2019/10/21 10:00
 */
public class Main7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            String temp = scanner.next();
            numbers[i] = Integer.parseInt(temp.substring(temp.length() - 6));
        }
        Arrays.sort(numbers);
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
