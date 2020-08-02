package algorithm.contest.fifth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/28 9:36
 */
public class Main2 {

    private static class Point{
        int index;
        boolean start;

        public Point(int index, boolean start) {
            this.index = index;
            this.start = start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            List<Point> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Point(scanner.nextInt(),true));
            }
            for (int i = 0; i < N; i++) {
                list.add(new Point(scanner.nextInt(),false));
            }
            list.sort(Comparator.comparingInt(o -> o.index));
            int count = 0, temp = 0;
            for (Point point : list) {
                if(point.start){
                    temp++;
                }else{
                    temp--;
                }
                count = Math.max(count,temp);
            }
            System.out.println(count);
        }
    }


}
