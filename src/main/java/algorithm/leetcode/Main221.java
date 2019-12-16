package algorithm.leetcode;

/**
 * 最大正方形  0 1 矩阵中最大的正方形， 经典dp 二维到一维 空间优化
 * @author lihaoyu
 * @date 2019/12/16 9:07
 */
public class Main221 {


    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols+1];
        int pre = 0, maxLen = 0;
        for(int i = 1; i <= rows; i++){
            pre = 0;
            for(int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if(matrix[i-1][j-1] == '1'){
                    dp[j] = Math.min(Math.min(pre,dp[j-1]),dp[j]) + 1;
                    maxLen = Math.max(maxLen,dp[j]);
                }else{
                    dp[j] = 0;
                }
                pre = temp;
            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {

    }
}
