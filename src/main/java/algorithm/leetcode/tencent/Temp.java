package algorithm.leetcode.tencent;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2019/11/4 12:00
 */

public class Temp {
    private static class Point{
        int x;
        int y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
       String str1 = new String("hello ") + new String("world");
       str1.intern();
       String str2 = "hello world";
        System.out.println(str1 == str2);
    }
}
