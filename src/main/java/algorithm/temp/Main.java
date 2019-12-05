package algorithm.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author lihaoyu
 * @date 2019/11/16 22:39
 */
public class Main{

    private static class Point implements Comparable<Point> {
        boolean start;
        int index;
        int id;
        int radix;

        public Point(boolean start, int index, int id, int radix) {
            this.start = start;
            this.index = index;
            this.id = id;
            this.radix = radix;
        }

        @Override
        public int compareTo(Point o) {
            if (index != o.index) return index - o.index;
            return radix - o.radix;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
        int N = scanner.nextInt();
        List<Point> list = new ArrayList<>(N);
        for (int i = 0; i < N/2; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            list.add(new Point(true, start, i,end - start));
            list.add(new Point(false, end, i,end - start));
        }
        Collections.sort(list);
        Stack<Point> stack = new Stack<>();
        int flag = 0;
        for (Point point : list) {
            if (point.start) {
                stack.push(point);
                continue;
            }
            if (stack.peek().id == point.id) {
                stack.pop();
            } else {
               flag = 1;
                break;
            }
        }
        if(flag == 1){
            System.out.println("Y");
        }else{
            System.out.println("n");
        }
        }
    }
}
