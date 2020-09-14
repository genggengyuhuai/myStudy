package algorithm.leetcode;

/**
 *  0 1 岛屿
 * @author lihaoyu
 * @date 2020/9/6 11:16 下午
 */
public class Main200 {
    // 1 是 陆地
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] flags = new boolean[grid.length][grid[0].length];
        int res = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(!flags[i][j] && grid[i][j] == '1') {
                    res++;
                    fun(grid,i,j,flags);
                }
        return res;
    }

    // 把周围的染色
    public static void fun(char[][] grid, int i, int j, boolean[][] flags){
        if(i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || flags[i][j] || grid[i][j] == '0') return;
        flags[i][j] = true;
        fun(grid,i+1,j,flags);
        fun(grid,i-1,j,flags);
        fun(grid,i,j+1,flags);
        fun(grid,i,j-1,flags);
    }

    public static void main(String[] args) {

    }
}
