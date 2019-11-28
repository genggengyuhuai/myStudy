package algorithm.contest.fifth;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/28 10:26
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int[] in = new int[n + 1];
            int[] out = new int[n + 1];
            int[] outValue = new int[n + 1];
            int start, end, value;
            for (int i = 0; i < p; i++) {
                start = scanner.nextInt();
                end = scanner.nextInt();
                value = scanner.nextInt();
                out[start] = end;
                outValue[start] = value;
                in[end] = start;
            }
            // 从 in 数组中找头结点
            for (int i = 0; i < in.length; i++) {
                if (in[i] != 0) {
                    continue;
                }
                // in[i] 是头结点
                int head = in[i];
                while(out[out[head]] != 0){
                    head = out[head];
                }


            }

        }
    }
}
