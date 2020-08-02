package algorithm.leetcode;

/**
 * 编辑距离，二维空间到一维的优化，重点是把 dp[i-1][j-1] 记录成 prev
 * @author lihaoyu
 * @date 2019/12/16 9:29
 */
public class Main72 {

    public static int minDistance(String word1, String word2) {
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dp = new int[len1 + 1];
        // 初始化 dp
        for (int i = 0; i <= len1; i++) {
            dp[i] = i;
        }
        int pre;
        for (int i = 1; i <= len2; i++) {
            pre = i - 1;
            for (int j = 1; j <= len1; j++) {
                if (j == 1) dp[0] = i;
                int temp = dp[j];
                dp[j] = Math.min(Math.min(dp[j - 1], dp[j]) + 1, pre + (word1.charAt(j - 1) == word2.charAt(i - 1) ? 0 : 1));
                pre = temp;
            }
        }
        return dp[len1];
    }


    public static void main(String[] args) {
        System.out.println(minDistance("intention", "execution"));

    }
}
