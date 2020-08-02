package algorithm.school_hire_2019.pinduoduo;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author lihaoyu
 * @date 2019/11/8 20:20
 */
public class Main1 {
    private static int resCount;
    private static String resString;

    private static void fun(String string, int k) {
        char[] chars = string.toCharArray();
        int[] counts = new int[10];
        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - '0'] += 1;
        }
        int cost = Integer.MAX_VALUE;
        for (int t = 0; t < 10; t++) {
            int tempK = k - counts[t];
            if(tempK <= 0){
                resCount = 0;
                resString = string;
                return;
            }
            int gap = 1;
            int tempCost = 0;
            int[] tempCounts = Arrays.copyOf(counts, 10);
            while (tempK != 0 && (t + gap < 10 || t - gap >= 0)) {
                while (tempK != 0 && t - gap >= 0 && tempCounts[t - gap] != 0) {
                    tempK--;
                    tempCounts[t - gap]--;
                    tempCost += gap;
                }
                while (tempK != 0 && t + gap < 10 && tempCounts[t + gap] != 0) {
                    tempK--;
                    tempCounts[t + gap]--;
                    tempCost += gap;
                }
                gap++;
            }
            cost = Math.min(cost, tempCost);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int N = scanner.nextInt();
        int K = scanner.nextInt();
        String next = scanner.next();
        fun(next, K);
    }
}
