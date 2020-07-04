package algorithm.leetcode.bytedance.array_sort;

import org.apache.commons.math3.analysis.function.Max;

/**
 * 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 *
 * @author lihaoyu
 * @date 2020/7/3 12:33 下午
 */
public class Main2 {

    private boolean[][] visited;
    int res;
    int curRes;

    private void fun(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;
        curRes++;
        res = Math.max(curRes, res);
        visited[i][j] = true;
        fun(grid, i + 1, j);
        fun(grid, i, j + 1);
        fun(grid, i - 1, j);
        fun(grid, i, j - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        res = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++){
                curRes = 0;
                fun(grid, i, j);
            }
        return res;
    }

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        int[][] test = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        System.out.println(main2.maxAreaOfIsland(test));
    }
}
