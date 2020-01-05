package algorithm.temp;

import java.util.Arrays;

/**
 * @author lihaoyu
 * @date 2020/1/3 15:20
 */
public class Main3 {
    private static class Line implements Comparable<Line>{
        int left;
        int right;

        @Override
        public int compareTo(Line o) {
            return right - o.right;
        }
    }

    public static void main(String[] args) {
        Line[] lines = new Line[3];

        Arrays.sort(lines);
        int count = 0, j = 0; // 注意 j 的作用
        for(int i = 1; i < lines.length; i++)
            if(lines[i].left >= lines[j].right) {
                count++; j = i;
            }


    }


}
