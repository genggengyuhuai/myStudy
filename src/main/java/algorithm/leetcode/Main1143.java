package algorithm.leetcode;

/**
 * 最长公共子序列
 * @author lihaoyu
 * @date 2021/4/3 12:56
 */
public class Main1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        if(text1 ==null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        if(text1 ==null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int[] dp = new int[text2.length()+1];
        for (int i = 1; i <= text1.length(); i++) {
            int prev = dp[0];
            for (int j = 1; j <= text2.length(); j++) {
              int temp = dp[j];
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[j] = prev + 1;
                }else{
                    dp[j] = Math.max(dp[j],dp[j-1]);
                }
                prev = temp;
            }
        }
        return dp[text2.length()];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence2("bsbininm"
               , "jmjkbkjkv"));
    }
}
