package algorithm.leetcode;

/**
 * 最大乘积子串
 * @author lihaoyu
 * @date 2/8/2020 9:58 AM
 */
public class Main152 {

    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dpCurMax = new int[nums.length];
        int[] dpCurMin = new int[nums.length];
        int res = nums[0];
        dpCurMax[0] = dpCurMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpCurMax[i] = Math.max(nums[i],Math.max(nums[i] * dpCurMax[i-1], nums[i] * dpCurMin[i-1]));
            dpCurMin[i] = Math.min(nums[i],Math.min(nums[i] * dpCurMax[i-1], nums[i] * dpCurMin[i-1]));
            res = Math.max(res, dpCurMax[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
