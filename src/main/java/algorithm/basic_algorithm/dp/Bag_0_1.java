package algorithm.basic_algorithm.dp;

/**
 * 第i个物品，背包容量j, 所能得到的最大价值
 * dp[i][j] = max(dp[i-1][j], v[i] + dp[i-1][j-w[i]])
 * 简化为 dp[j] 一维，从后往前迭代。若为完全背包，则从前往后
 *
 *
 * @author lihaoyu
 * @date 2019/10/24 15:24
 */
class Bag_0_1 {
    private boolean knapSack(int[] nums, int sum) {
        int size = nums.length;

        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[i] = i == nums[0];
        }

        for (int i = 1; i < size; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }

    private boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        // 如果数组元素和不是2的倍数，直接返回false
        if (sum % 2 != 0)
            return false;
        return knapSack(nums, sum / 2);
    }



    public static void main(String[] args) {
        Bag_0_1 solution = new Bag_0_1();
        System.out.println(solution.canPartition(new int[]{1, 200, 3, 4, 8, 6}));
    }
}
