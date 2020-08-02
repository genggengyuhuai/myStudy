package algorithm.leetcode;


/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 *
 * 火车票有三种不同的销售方式：
 *
 * 一张为期一天的通行证售价为 costs[0] 美元；
 * 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 *
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费
 * @author lihaoyu
 * @date 2020/5/6 23:42
 */
public class Main983 {

    public static int mincostTickets(int[] days, int[] costs) {

        // 分为出门和不出门
        int dp[] = new int[days[days.length - 1] + 1];
        int currentIndex = 0;
        // 注意 i 的 范围， 有点意思
        for (int i = 1; i <= days[days.length - 1]; i++) {
            // 出门
            if (i == days[currentIndex]) {
                dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0], Math.min(dp[Math.max(0, i - 7)] + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
                currentIndex++;
            } else {
                // 不出门
                dp[i] = dp[i - 1];
            }

        }
        return dp[dp.length - 1];
    }
/*
[1,4,6,7,8,20]
[2,7,15]

[1,2,3,4,5,6,7,8,9,10,30,31]
[2,7,15]
*/



    public static void main(String[] args) {
        System.out.println(mincostTickets(new int[]{1,2,3,4,5,6,7,8,9,10,30,31}
        ,new int[]{2,7,15}));
    }
}









