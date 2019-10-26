package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 *
 *  快手	回文字符串	1045	25.94%
 *
 * 最大回文子串是被研究得比较多的一个经典问题。最近月神想到了一个变种，对于一个字符串，
 * 如果不要求子串连续，那么一个字符串的最大回文子串的最大长度是多少呢。
 * @author lihaoyu
 * @date 2019/10/22 10:23
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        char[] c = string.toCharArray();
        int len = string.length();
        int[][] dp = new int[len][len];

        // 对角线赋1
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        int max = 1;
        // 开始
        for(int i = len - 1; i >= 0; i--){
            for(int j = i+1; j < len; j++){
                if(c[i] == c[j]){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        System.out.println(max);
    }

}
