package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * <p>
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * <p>
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 *
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */
public class Main6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) x1[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) y1[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) x2[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) y2[i] = scanner.nextInt();

        int[] X = new int[2 * n];
        int[] Y = new int[2 * n];
        for (int i = 0; i < n; i++) {
            X[i] = x1[i];
            X[i + n] = x2[i];
            Y[i] = y1[i];
            Y[i + n] = y2[i];
        }
        int cnt = 0;
        int res = 0;
        // 先找x轴
        for (int x : x1) {
            for (int y : y1) {
                // 对于每个矩形
                for (int i = 0; i < n; i++) {
                    if (x >= x1[i] && x < x2[i] && y >= y1[i] && y < y2[i]) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
                cnt = 0;
            }
        }
        System.out.println(res);
    }
}
