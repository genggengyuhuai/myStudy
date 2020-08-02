package algorithm.leetcode.bytedance.array_sort;

/**
 * 最长递增子串
 * @author lihaoyu
 * @date 2020/7/4 7:56 下午
 */
public class Main4 {

    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // 记录以当前位置为结束的res
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] <= nums[i-1]){
                dp[i] = 1;
                continue;
            }
            dp[i] = dp[i-1]+1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
