package algorithm.jiu_shi_gan.kuaishou;

import java.util.Scanner;

/**
 * 快手	求连续子数组的最大和	1030	31.09%
 * 一个非空整数数组，选择其中的两个位置，使得两个位置之间的数和最大。
 * 如果最大的和为正数，则输出这个数；如果最大的和为负数或0，则输出0
 *
 * @author lihaoyu
 * @date 2019/10/24 20:00
 */
public class Main17 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String[] split = next.split(",");
        int[] nums = new int[split.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int len = split.length;


        int res = nums[0], count = nums[0];
        for (int i = 1; i < len; i++) {
            // 临时求和比0小，直接舍弃之前的
            if (count <= 0) {
                count = nums[i];
            } else {
                count += nums[i];
            }
            res = Math.max(res, count);
        }
        System.out.println(res > 0 ? res : 0);
    }

}
