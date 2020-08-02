package algorithm.contest.fourth;

import java.util.Scanner;

/**
 * 如何花最少的钱购买蔬菜
 * Rahul wanted to purchase vegetables mainly brinjal, carrot and tomato. There are N different vegetable sellers in a line. Each vegetable seller sells all three vegetable items, but at different prices.
 * Rahul, obsessed by his nature to spend optimally, decided not to purchase same vegetable from adjacent shops. Also, Rahul will purchase exactly one type of vegetable item (only 1 kg) from one shop.
 * Rahul wishes to spend minimum money buying vegetables using this strategy. Help Rahul determine the minimum money he will spend.
 * @author lihaoyu
 * @date 2019/11/21 10:13
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] nums = new int[N][3];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < 3; j++){
                    nums[i][j] = scanner.nextInt();
                }
            }
            int[][] dp = new int[N][3];
            dp[0][1] = nums[0][1];
            dp[0][2] = nums[0][2];
            dp[0][0] = nums[0][0];
            for(int i = 1; i < N; i++){
                for(int j = 0; j < 3; j++){
                    dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+nums[i][j];
                }
            }
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < 3; j++){
                min = Math.min(dp[N-1][j],min);
            }
            System.out.println(min);
        }
    }
}
