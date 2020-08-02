package algorithm.contest.fifth;

import java.util.ArrayList;
import java.util.List;
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
            List<Integer> resStart = new ArrayList<>();
            List<Integer> resEnd = new ArrayList<>();
            List<Integer> resValue = new ArrayList<>();
            for (int i = 0; i < p; i++) {
                start = scanner.nextInt();
                end = scanner.nextInt();
                value = scanner.nextInt();
                out[start] = end;
                outValue[end] = value;
                in[end] = start;
            }
            // 从 in 数组中找头结点
            for (int i = 1; i < in.length; i++) {
                if (in[i] != 0) {
                    continue;
                }
                // i 是头结点
                int head = i;
                resStart.add(head);
                while(out[head] != 0){
                    head = out[head];
                }
                // head 变成尾节点
                resEnd.add(head);
                resValue.add(outValue[head]);
            }
            System.out.println(resStart.size());
            for (int i = 0; i < resStart.size(); i++) {
                System.out.print(resStart.get(i)+" ");
                System.out.print(resEnd.get(i)+" ");
                System.out.println(resValue.get(i));
            }

        }
    }
}
