package interview.tecent;

import java.util.Scanner;

/**
 * 腾讯秋招机试 9.6 号晚8点
 * 两个降序子序列，求公共子序列
 * 6
 * 6 5 4 3 2 1
 * 5
 * 6 5 3 2 1
 * 输出  6 5 3 2 1
 *
 * @author lihaoyu
 * @date 2020/9/6 7:55 下午
 */
public class Main11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int aLength = in.nextInt();
        int[] aNums = new int[aLength];
        for (int i = 0; i < aLength; i++) {
            aNums[i] = in.nextInt();
        }
        int bLength = in.nextInt();
        int[] bNums = new int[bLength];
        for (int i = 0; i < bLength; i++) {
            bNums[i] = in.nextInt();
        }
        int[] res = new int[Math.max(aLength, bLength)];
        int resIndex = 0;
        // 因为已经是降序了，所以双指针走起
        int aIndex = 0, bIndex = 0;
        while (aIndex < aLength && bIndex < bLength) {
            if (aNums[aIndex] == bNums[bIndex]) {
                res[resIndex++] = aNums[aIndex];
                aIndex++;
                bIndex++;
            } else if (aNums[aIndex] > bNums[bIndex]) {
                aIndex++;
            }else{
                bIndex++;
            }
        }
        for (int i = 0; i < resIndex; i++) {
            System.out.print(res[i]+" ");
        }
    }
}
