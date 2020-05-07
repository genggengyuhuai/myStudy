package algorithm.leetcode;


/**
 * @author lihaoyu
 * @date 2020/5/6 23:42
 */
public class Main983 {

    public static int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        int[] flag = new int[days.length];
        dp[0] = costs[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + costs[0];
        }
        for (int i = 0; i < dp.length; i++) {
            // 是买7天，还是30天，还是不动
            int index7 = getIndex(days, days[i] - 7 + 1);
            int seven = dp[index7] - costs[flag[index7]] + costs[1];
            int index30 = getIndex(days, days[i] - 30 + 1);
            int thirty = dp[index30] - costs[flag[index30]] + costs[2];
            // 不动
            if (dp[i] < seven && dp[i] < thirty){
                if(i == 0) continue;
                dp[i] = dp[i-1] + costs[0];
            }
            // 7天
            else if (seven <= dp[i] && seven < thirty) {
                flag[i] = 1;
                for (int j = 0; j < dp.length; j++) {
                    if (days[index7] + 7 <= days[j]) break;
                    dp[j] = Math.min(dp[j],seven);
                }
            } else {
                flag[i] = 2;
                for (int j = 0; j < dp.length; j++) {
                    if (days[index7] + 30 <= days[j]) break;
                    dp[j] = Math.min(dp[j],thirty);
                }
            }
        }
        return dp[dp.length-1];
    }
/*
[1,4,6,7,8,20]
[2,7,15]

[1,2,3,4,5,6,7,8,9,10,30,31]
[2,7,15]
*/
    private static int getIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) return i;
        }
        // 不存在
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}
        ,new int[]{2,7,15}));
    }
}









