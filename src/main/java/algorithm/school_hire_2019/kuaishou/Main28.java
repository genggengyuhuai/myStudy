package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？@author lihaoyu
 * @date 2019/12/28 15:39
 */
public class Main28 {
    private static boolean[][] map;
    private static int k;

    private static boolean valid(int i, int j){
        int count = 0;
        while(i > 0){
            count += i%10;
            i /= 10;
        }
        while(j > 0){
            count += j%10;
            j /= 10;
        }
        return count <= k && i >= 0 && i < map.length && j >= 0 && j < map[0].length;
    }

    private static void fun(int i, int j){
        if(!valid(i,j) || !(i >= 0 && i < map.length && j >= 0 && j < map[0].length)||map[i][j]) return;
        map[i][j] = true;
        fun(i+1,j);
        fun(i,j+1);
        fun(i-1,j);
        fun(i,j-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        map = new boolean[m][n];
        k = scanner.nextInt();
        fun(0,0);
        int count = 0;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                count += (map[i][j] ? 1 : 0);
        System.out.println(count);
    }
}
