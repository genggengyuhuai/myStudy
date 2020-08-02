package algorithm.leetcode;

/**
 * 最长严格递增子序列的个数
 * @author lihaoyu
 * @date 2019/12/9 20:34
 */
public class Main673 {


    public static void find(int[] nums){
        int len = nums.length;
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++)
            // 初始化
            dp[i][i] = 1;

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){


            }
        }
    }


    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
    return 0;
    }


    public static void main(String[] args) {

    }
}
