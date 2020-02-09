package algorithm.leetcode;

/**
 *  标准 dp
 *  给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * @author lihaoyu
 * @date 2/7/2020 11:31 AM
 */
public class Main132 {


    public static int minCut(String s) {
        boolean[][] huiwen = new boolean[s.length()][s.length()];
        for (int i = 0; i < huiwen.length; i++)   huiwen[i][i] = true;
        for(int i = 1; i < huiwen.length; i++)
            for(int j = 0; j+i < huiwen.length; j++)
                huiwen[j][j+i] = (s.charAt(j) == s.charAt(j + i) && (i < 2 || huiwen[j + 1][j + i - 1]));
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) dp[i] = i+1;
        for (int i = 1; i < dp.length; i++) {
            for(int j = i; j >= 0; j--){
                if(huiwen[j][i]) dp[i] = Math.min(dp[i], (j == 0 ? 1 : (dp[j-1] + 1)));
            }
        }
        return dp[s.length()-1]-1;
    }


    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
