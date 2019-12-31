package algorithm.school_hire_2019.kuaishou;

/**
 * 最大 m 字段和
 *
 * @author lihaoyu
 * @date 2019/12/31 12:56
 */
public class Main29 {

    private static void fun(int N, int M, int[] nums){
        int[][] dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j <= N; j++) {
                max = Math.max(max,dp[i-1][j-1]);
                dp[i][j] = Math.max(j == i ? Integer.MIN_VALUE:dp[i][j-1],max) + nums[j-1];
            }
        }
        for (int i = 0; i <= M ; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }



    }



    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
//        int M = scanner.nextInt();
//        int[] nums = new int[N];
//        for (int i = 0; i < N; i++) {
//            nums[i] = scanner.nextInt();
//        }
        fun(7,7,new int[]{-2,11,-4,13,-5,6,-2});


    }

}
