package algorithm.temp;

/**
 * @author lihaoyu
 * @date 2020/9/7 9:13 上午
 */
public class Temp2 {

    // 最长公共   子串/子序列   的长度
    private static int fun(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int res = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }

    // 最长递增  子序列   的长度
    private static int fun2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++)
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(dp[i], res);
            }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fun("abcdef", "ravgorpcqdqebjgf"));
    }
}
