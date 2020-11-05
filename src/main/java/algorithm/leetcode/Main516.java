package algorithm.leetcode;


/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000
 *
 * @author lihaoyu
 * @date 2020/11/5 2:17 下午
 */
public class Main516 {

    // 最长回文子序列，动归
    // s[i,j] 字符串的res    s[i] == s[j] 时 dp[i,j] = 1 + s[i+1,j-1]
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        // 先初始化
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        //
        for (int i = 1; i < s.length(); i++) {
            for (int x = 0; x < s.length() - i; x++) {
                if (s.charAt(x) == s.charAt(x + i)) dp[x][x + i] = 2 + (i > 1 ? dp[x + 1][x + i - 1] : 0);
                else dp[x][x + i] = Math.max(dp[x + 1][x + i], dp[x][x + i - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }
}
