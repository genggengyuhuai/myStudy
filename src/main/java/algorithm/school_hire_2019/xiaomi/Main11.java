package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 有一只地鼠不小心跑进了一个m*n的矩形田地里，假设地鼠在这块田地的初始位置为（x,y），并且每次只能向相邻的上下左右四个方向移动一步，那么在最多移动K次的情况下，
 * 有多少条路径可以逃出这片田地（一旦出去田地的边界就不能再往回走）？
 * @author lihaoyu
 * @date 2019/11/9 21:36
 */
public class Main11 {

    private static int count = 0;

    private static boolean valid(int m, int n, int x, int y) {
        return x < m && x >= 0 && y < n && y >= 0;
    }

    private static void fun(int m, int n, int x, int y,int K){
        if(!valid(m,n,x,y) || K <= 0){
            if(!valid(m,n,x,y)){
                count++;
            }
            return;
        }
        fun(m,n,x+1,y,K-1);
        fun(m,n,x,y+1,K-1);
        fun(m,n,x-1,y,K-1);
        fun(m,n,x,y-1,K-1);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int K = scanner.nextInt();
        fun(m,n,x,y,K);
        System.out.println(count);
    }
}
