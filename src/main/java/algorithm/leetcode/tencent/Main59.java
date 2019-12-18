package algorithm.leetcode.tencent;

/**
 * 螺旋矩阵 II
 * 1 2 3
 * 8 9 4
 * 7 6 5
 * @author lihaoyu
 * @date 2019/12/18 15:06
 */
public class Main59 {



    public static int[][] generateMatrix(int n) {
        if(n <= 0) return null;
        int[][] res = new int[n][n];
        int startRow = 0, startCol = 0, endRow = n - 1, endCol = n - 1;
        int count = 1;
        while(startRow <= endRow && startCol <= endCol){
            for(int i = startCol; i <= endCol; i++){
                res[startRow][i] = count++;
            }
            startRow++;
            for(int i = startRow; i <= endRow; i++){
                res[i][endCol] = count++;
            }
            endCol--;
            for(int i = endCol; i >= startCol; i--){
                res[endRow][i] = count++;
            }
            endRow--;
            for(int i = endRow; i >= startRow; i--){
                res[i][startCol] = count++;
            }
            startCol++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
