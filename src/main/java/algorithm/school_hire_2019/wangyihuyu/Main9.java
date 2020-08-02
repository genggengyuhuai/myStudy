package algorithm.school_hire_2019.wangyihuyu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 超时未通过
 * 给你一个一维数组a，长度为n，表示了n个基站的位置高度信息。
 * 数组的第i个元素a[i]表示第i个基站的海拔高度是a[i],而下标相邻的基站才相邻并且建立链接，
 * 即x号基站与x-1号基站、x+1号基站相邻。特别的，1号基站仅与2号相邻，而n号基站仅与n-1号基站相邻
 * 当一场海拔高度为y的洪水到来时，海拔高度小于等于y的基站都会被认为需要停止发电，同时断开与相邻基站的链接。
 * @author lihaoyu
 * @date 2019/12/29 23:44
 */
public class Main9 {

    private static class Point implements Comparable<Point>{
        int value;
        int index;
        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }
        @Override
        public int compareTo(Point o) {
            return value-o.value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] nums = new int[N];
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
            list.add(new Point(nums[i],i));
        }
        Collections.sort(list);
        int qNum = scanner.nextInt();
        for (int p = 0; p < qNum; p++) {
            int q = scanner.nextInt();
            boolean[] flags = new boolean[N];
            for (Point point : list) {
                if(q >= point.value) flags[point.index] = true;
                else break;
            }
            int part = 0;
            int i = 0;
            while(i<N){
                while(i < N && flags[i]) i++;
                if(i == N) break;
                part++;
                while(i < N && !flags[i]) i++;
            }
            System.out.println(part);
        }


    }
}
