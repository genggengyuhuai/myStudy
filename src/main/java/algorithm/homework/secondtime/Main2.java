package algorithm.homework.secondtime;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用单调栈解决
 *  给定一个矩形区域，每一个位置上都是1或0，求该矩阵中每一个位置上都是1的最大子矩形区域中的1的个数。
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * @author lihaoyu
 * @date 2019/10/11 21:52
 */
public class Main2 {

    public static int getMaxRecSize(int[][] map) {
        if (map == null || map.length == 0 || map[0].length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int[] height = new int[map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                height[j] = map[i][j] > 0 ? height[j] + 1 : 0;
            }
            max = Math.max(max, getMaxRexSizeFromBottom(height));
        }
        return max;
    }

    private static int getMaxRexSizeFromBottom(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                int current = s.pop();
                // 这里需要思考一下
                int top = s.isEmpty() ? -1 : s.peek();
                max = Math.max(max, (i - top - 1) * height[current]);
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int current = s.pop();
            int top = s.isEmpty() ? -1 : s.peek();
            max = Math.max(max, (height.length - top - 1) * height[current]);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();

        for(int mm = 0; mm < caseCount; mm++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] map = new int[n][m];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    map[i][j] = scanner.nextInt();
            System.out.println(getMaxRecSize(map));
        }

    }
}
