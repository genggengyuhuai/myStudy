package algorithm.leetcode;

/**
 * 排序矩阵 找第K小
 * @author lihaoyu
 * @date 3/4/2020 9:02 AM
 */
public class Main378 {

    private int fun(int[][] matrix, int target){
		// 比 target 小的个数
		int count = 0, i = matrix.length - 1, j = 0;
        while(i >=0 && j < matrix[0].length){
            if(matrix[i][j] <= target){
                count += (i+1);
				j++;
            }else{
                i--;
            }
        }
        return count;
    }


    public int kthSmallest(int[][] matrix, int k) {
        int lenX = matrix.length, lenY = matrix[0].length, mid;
        int left = matrix[0][0], right = matrix[lenX-1][lenY-1];
        while(left < right){
            mid = (left + right) >> 1;
            // 小于等于 mid 的有 count 个
            int count = fun(matrix, mid);
            if(count < k){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {

    }
}
