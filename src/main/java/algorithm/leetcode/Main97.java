package algorithm.leetcode;

/**
 * 给定三个字符串 s1, s2, s3, 验证 s3 是否是由 s1 和 s2 交错组成的。
 * @author lihaoyu
 * @date 2/6/2020 8:03 PM
 */
public class Main97 {

    public static boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        // 初始化
        dp[0][0] = true;
        for(int i = 1; i <= s1.length(); i++) if(s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = true; else break;
        for(int i = 1; i <= s2.length(); i++) if(s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = true;else break;
        for(int i = 1; i <= s1.length(); i++){
            for(int j = 1; j <= s2.length(); j++){
                if(dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1)) dp[i][j] = true;
                if(dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1)) dp[i][j] = true;
            }
        }
        return dp[s1.length()][s2.length()];
    }


    public static void main(String[] args) {
        System.out.println(isInterleave("db","b","cbb"));
    }
}
