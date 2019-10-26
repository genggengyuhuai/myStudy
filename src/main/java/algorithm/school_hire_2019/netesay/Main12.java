package algorithm.school_hire_2019.netesay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 网易校招
 * 又到了周末，小易的房间乱得一团糟。
 * 他希望将地上的杂物稍微整理下，使每团杂物看起来都紧凑一些，没有那么乱。
 * 地上一共有n团杂物，每团杂物都包含4个物品。第i物品的坐标用(ai,bi)表示，小易每次都可以将它绕着(xi,yi)逆时针旋转90^ \circ90
 * ∘
 *  ，这将消耗他的一次移动次数。如果一团杂物的4个点构成了一个面积不为0的正方形，我们说它是紧凑的。
 * 因为小易很懒，所以他希望你帮助他计算一下每团杂物最少需要多少步移动能使它变得紧凑。
 * 输入描述:
 * 第一行一个数n(1 <= n <= 100)，表示杂物的团数。
 * 接下来4n行，每4行表示一团杂物，每行4个数ai, bi，xi, yi, (-104 <= xi, yi, ai, bi <= 104)，表示第i个物品旋转的它本身的坐标和中心点坐标。
 *
 * @author lihaoyu
 * @date 2019/10/9 10:23
 */

class Point implements Comparable<Point>, Cloneable{
    public int x;
    public int y;

    public int rotate_x;
    public int rotate_y;

    public void rotate() {
        int dx = x - rotate_x;
        int dy = y - rotate_y;
        x = rotate_x + dy;
        y = rotate_y - dx;
    }

    public void antiRotate(){
        int dx = x - rotate_x;
        int dy = y - rotate_y;
        y = rotate_y + dx;
        x = rotate_x - dy;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + ", rotate_x=" + rotate_x + ", rotate_y=" + rotate_y + '}';
    }

    public Point(int x, int y, int rotate_x, int rotate_y) {
        this.x = x;
        this.y = y;
        this.rotate_x = rotate_x;
        this.rotate_y = rotate_y;
    }

    @Override
    public int compareTo(Point o) {
        if (x != o.x) {
            return x - o.x;
        }
        return y - o.y;
    }
}

public class Main12 {

    public static List<Integer> resList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        for (int k = 0; k < number; k++) {
            Point[] points = new Point[4];
            for (int i = 0; i < 4; i++) {
                points[i] = new Point(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            }
            recursiveFun(points,0,0);
//            System.out.println(resList);
            int min = Integer.MAX_VALUE;
            for (Integer integer : resList) {
                if(integer < min) {
                    min = integer;
                }
            }
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
            resList.clear();
        }
    }

    private static void recursiveFun(Point[] points, int k, int count) {
        if (k == 4) {
            if (isSquare(points)) {
                if(count == 4){
                    System.out.println();
                }
                resList.add(count);
            }
            return;
        }
        for (int i = 0; i <= 3; i++) {
            points[k].antiRotate();
            recursiveFun(points, k + 1, (i + 1) % 4 + count);
        }
    }

    private static boolean isSquare(Point[] temp) {
        // 巨坑  排序改变了本身
        Point[] points = new Point[4];
        for(int i = 0; i < 4; i++){
            points[i] = new Point(temp[i].x,temp[i].y,temp[i].rotate_x,temp[i].rotate_y);
        }
        Arrays.sort(points);
        if (points[0].x == points[1].x && points[2].x == points[3].x && points[0].y == points[2].y
                && points[1].y == points[3].y && (points[1].y - points[0].y == points[2].x - points[0].x)  &&
                points[0].x != points[2].x && points[0].y != points[1].y) {
            return true;
        }
        return false;
    }
}
