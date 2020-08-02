package algorithm.contest.temp;

import java.util.Scanner;

/**
 * 最大子数组的和，可以最多删除一个字符
 * @author lihaoyu
 * @date 2019/12/4 18:40
 */
public class Main2 {

    private static int fun(int[] nums){
        int res = nums[0], dp1 = nums[0],dp2 = 0;
        for (int i = 1; i < nums.length; i++) {
            dp2 = Math.max(dp1,nums[i] + Math.max(0,dp2));
            dp1 = nums[i] + Math.max(dp1, 0);
            res = Math.max(Math.max(dp1,dp2),res);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] numbers = new int[N];
            for (int i = 0; i < N; i++) {
                numbers[i] = scanner.nextInt();
            }
            System.out.println(fun(numbers));
        }
    }

}
