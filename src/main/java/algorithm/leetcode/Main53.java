package algorithm.leetcode;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author lihaoyu
 * @date 2020/5/19 8:56 下午
 */
public class Main53 {

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0], tempSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempSum = Math.max(tempSum, 0);
            tempSum += nums[i];
            res = Math.max(res, tempSum);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
