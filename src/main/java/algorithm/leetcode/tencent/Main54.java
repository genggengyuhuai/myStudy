package algorithm.leetcode.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @author lihaoyu
 * @date 2019/12/18 16:17
 */
public class Main54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0){
            return res;
        }
        int rowStart = 0, rowEnd = matrix.length - 1, colStart = 0, colEnd = matrix[0].length - 1;
        while(rowStart <= rowEnd && colStart <= colEnd){
            for(int i = colStart; i <= colEnd; i++)
                res.add(matrix[rowStart][i]);
            rowStart++;
            for(int i = rowStart; i <= rowEnd && colStart <= colEnd; i++)
                res.add(matrix[i][colEnd]);
            colEnd--;
            for(int i = colEnd; i >= colStart && rowStart <= rowEnd; i--)
                res.add(matrix[rowEnd][i]);
            rowEnd--;
            for(int i = rowEnd; i >= rowStart && colStart <= colEnd; i--)
                res.add(matrix[i][colStart]);
            colStart++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));
    }
}
