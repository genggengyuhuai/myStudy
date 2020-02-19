package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * 分苹果 18校招
 * n 只奶牛坐在一排，每个奶牛拥有 ai 个苹果，现在你要在它们之间转移苹果，使得最后所有奶牛拥有的苹果数都相同，每一次，
 * 你只能从一只奶牛身上拿走恰好两个苹果到另一个奶牛上，问最少需要移动多少次可以平分苹果，如果方案不存在输出 -1。
 * @author lihaoyu
 * @date 2/17/2020 6:06 PM
 */
public class Main19 {


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] nums = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
        nums[i] = scanner.nextInt();
        sum += nums[i];
    }
    if(sum % n != 0){
        System.out.println(-1);
        return;
    }
    int avg = sum / n, res = 0;
    for (int i = 0; i < nums.length; i++) {
        if((Math.abs(nums[i] - avg) & 1) == 1){
            System.out.println(-1);
            return;
        }
    }
    for (int i = 0; i < nums.length; i++) {
        if(nums[i] > avg) res += (nums[i] - avg);
    }
    System.out.println(res/2);

}

}
