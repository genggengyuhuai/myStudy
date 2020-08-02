package algorithm.school_hire_2019.zhaohang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/28 11:17
 */
public class Main14 {

    private static class Line implements  Comparable<Line>{
        int x;
        int y;

        public Line(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Line o) {
            if(x != o.x) return x - o.x;
            return y - o.y;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Line> list = new ArrayList<>(N);
        for(int i = 0; i < N; i++){
            list.add(new Line(scanner.nextInt(), scanner.nextInt()));
        }
        Collections.sort(list);
        int p1 = -1, p2 = -1, res = 0;
        for(int i = 0; i < N; i++){
            Line line = list.get(i);
            if(line.x > p1){
                res++;
                p1 = line.y;
            }
        }

    }
}
