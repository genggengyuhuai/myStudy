package algorithm.school_hire_2019.zhaohang;

import java.util.Scanner;

/**
 *
 * 比特币最佳买卖时机
 * 给定一个正整数数组，它的第 i 个元素是比特币第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入比特币前卖出。
 *
 * @author lihaoyu
 * @date 2019/10/23 10:57
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] numbers = new int[split.length];
        for(int i  = 0; i < split.length; i++){
            numbers[i] = Integer.parseInt(split[i]);
        }
        int min = numbers[0];
        int res = 0;
        for(int i = 1; i <numbers.length;i++){
            res = Math.max(numbers[i] - min, res);
            min = Math.min(min,numbers[i]);
        }
        System.out.println(res);

    }

}
