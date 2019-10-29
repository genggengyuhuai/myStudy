package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 * 快手	最小代价爬楼梯	920	22.99%
 * 你需要爬上一个N层的楼梯，在爬楼梯过程中， 每阶楼梯需花费非负代价，第i阶楼梯花费代价表示为cost[i]， 一旦你付出了代价，你可以在该阶基础上往上爬一阶或两阶。
 * 你可以从第 0 阶或者 第 1 阶开始，请找到到达顶层的最小的代价是多少。
 *
 * @author lihaoyu
 * @date 2019/10/27 10:32
 */
public class Main23 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int[] costs = new int[split.length];
        for (int i = 0; i < costs.length; i++) {
            costs[i] = Integer.parseInt(split[i]);
        }
        int len = split.length;
        if (len == 1) {
            System.out.println(costs[0]);
            return;
        }
        int a = 0;
        int b = 0;
        int temp;
        for (int i = 2; i <= len; i++) {
            temp = b;
            b = Math.min(a + costs[i-2], b+costs[i-1]);
            a = temp;
        }
        System.out.println(b);


    }

}
