package algorithm.leetcode;

import java.util.Arrays;

/**
 * 数组中只有两个数字出现了奇数次，其他都出现了偶数次
 * @author lihaoyu
 * @date 2020/5/17 12:09 上午
 */
public class Main260 {

    private static int fun(int[] nums, int len){
        int temp = nums[0];
        for (int i = 1; i < len; i++) {
            temp ^= nums[i];
        }
        return temp;
    }


    public int[] singleNumber(int[] nums) {
        int[] res = new int[2], s1 = new int[nums.length], s2 = new int[nums.length];
        int top1 = 0, top2 = 0;
        int fun = fun(nums, nums.length);
        // temp 是区分的那一位
        int temp = 1;
        while((fun & temp) == 0){
            temp <<= 1;
        }
        for (int num : nums) {
            if((num & temp) != 0) s1[top1++] = num;
            else s2[top2++] = num;
        }
        res[0] = fun(s1, top1);
        res[1] = fun(s2, top2);
        return res ;
    }

    public static void main(String[] args) {
        Main260 main260 = new Main260();
        System.out.println(Arrays.toString(main260.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
