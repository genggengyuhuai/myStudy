package algorithm.school_hire_2019.duxiaoman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 一维最大重叠数
 * @author lihaoyu
 * @date 2/5/2020 9:10 PM
 */
public class Main3 {

    private static class Point implements Comparable<Point>{
        int index;
        boolean start;

        public Point(int index, boolean start) {
            this.index = index;
            this.start = start;
        }

        @Override
        public int compareTo(Point o) {
            return index - o.index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> pointList = new ArrayList<>();
        for (int i = 0; i < 2*N; i++) {
            if((i & 1) == 0)
            pointList.add(new Point(scanner.nextInt(),true));
            else pointList.add(new Point(scanner.nextInt(),false));
        }
        Collections.sort(pointList);
        int res = 0, temp = 0;
        for (Point point : pointList) {
            if(point.start) temp++;
            else temp--;
            res = Math.max(res,temp);
        }
        System.out.println(res);
    }
}
