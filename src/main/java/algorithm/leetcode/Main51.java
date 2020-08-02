package algorithm.leetcode;

import java.util.List;

/**
 * N 皇后
 * @author lihaoyu
 * @date 2/27/2020 12:06 PM
 */
public class Main51 {

    // 不需要二维 map
    static int[] visited;

    private static boolean validate(int row, int col){
        for(int i = 0; i < row; i++){
            // 检查竖着
            if(visited[i] == col) return false;
            // 检查斜着
            if(Math.abs(i-row) == Math.abs(visited[i] - col)) return false;
        }
        return true;
    }

    static void print(){
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited.length; j++) {
                if(visited[i] == j) System.out.print("Q");
                else System.out.print(".");
            }
            System.out.println();
        }
    }

    static void fun(int row){
        if(row == visited.length){
             print();
            return;
        }
        for(int col = 0; col < visited.length; col++){
            if(validate(row,col)){
                visited[row] = col;
                fun(row+1);
                // 不需要回溯，因为每次只检查当前行上面的部分
            }
        }

    }

    public static List<List<String>> solveNQueens(int n) {
        visited = new int[n];
        fun(0);
        return null;
    }

    public static void main(String[] args) {
        solveNQueens(4);
    }

}
