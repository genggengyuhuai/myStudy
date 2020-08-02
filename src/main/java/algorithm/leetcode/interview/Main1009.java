package algorithm.leetcode.interview;

/**
 * 排序矩阵查找
 * @author lihaoyu
 * @date 3/4/2020 8:34 AM
 */
public class Main1009 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int lenX = matrix.length, lenY = matrix[0].length, i = lenX - 1,  j = 0;
        while(i >= 0 && j < lenY){
            if(matrix[i][j] == target) return true;
            while(j < lenY && matrix[i][j] < target) j++;
            while(i >= 0 && j < lenY && matrix[i][j] > target) i--;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
