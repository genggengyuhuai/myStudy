package algorithm.newcoderOJ;

/**
 * 每步只能向下走一步或者向右走一步或者向右下走一步
 * 每次走过一个格子，拿起（并且必须拿上）这个格子上的礼物。
 * 牛妹想知道，她能走到最后拿起的所有礼物体积最小和是多少？
 * @author lihaoyu
 * @date 3/7/2020 10:09 PM
 */
public class Main2 {

    public int selectPresent (int[][] presentVolumn) {
        if(presentVolumn == null || presentVolumn.length == 0 || presentVolumn[0].length == 0) return 0;
        // write code here
        int[][] dp = new int[presentVolumn.length][presentVolumn[0].length];
        // 初始化 dp
        dp[0][0] = presentVolumn[0][0];
        for (int i = 1; i < dp.length; i++) dp[i][0] = dp[i-1][0] + presentVolumn[i][0];
        for (int i = 1; i < dp[0].length; i++) dp[0][i] = dp[0][i-1] + presentVolumn[0][i];
        for(int i = 1; i < dp.length; i++)
            for(int j = 1; j < dp[0].length; j++)
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + presentVolumn[i][j];
        return dp[dp.length-1][dp[0].length-1];
    }



}
