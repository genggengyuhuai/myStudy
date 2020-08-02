package algorithm.contest.fourth;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/21 10:39
 */
public class Main1 {

    public static int maximumSum(int[] arr) {
        int ans = arr[0];
        int len = arr.length;
        int[][] dp = new int[len][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(arr[i], arr[i] + dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            ans = Math.max(ans, dp[i][0]);
            ans = Math.max(ans, dp[i][1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(maximumSum(nums));
        }
    }
}
