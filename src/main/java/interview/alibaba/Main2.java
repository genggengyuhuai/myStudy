package interview.alibaba;

import algorithm.basic_algorithm.search.SearchTest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 迷宫深搜
 * 4 4
 * #S..
 * E#..
 * #...
 * ....
 *
 * 4
 * @author lihaoyu
 * @date 3/23/2020 7:48 PM
 */
public class Main2 {

    static int minRes = Integer.MAX_VALUE;
    static char[][] map;
    static int m = 0, n =0;
    static boolean[][] visited;

    // 当前位置，当前步数，以及还能飞的次数
    private static void dfs(int i, int j, int count, int leftFly){
        if(map[i][j] == 'E'){
            minRes = Math.min(minRes, count);
            return;
        }
        if(i < n - 1 && i >= 0 && j < m && j >= 0){
            dfs(i+1,j,count+1,leftFly);
        }
        if(i < n  && i >= 0 && j < m - 1 && j >= 0){
            dfs(i,j+1,count+1,leftFly);
        }
        if(i < n && i >= 1 && j < m && j >= 0){
            dfs(i-1,j,count+1,leftFly);
        }
        if(i < n  && i >= 0 && j < m && j >= 1){
            dfs(i,j-1,count+1,leftFly);
        }
        if(leftFly > 0){
            dfs(n+1-i,m+1-j,count+1,leftFly-1);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        set.add(2);
        System.out.println(set.add(2));

    }
}
