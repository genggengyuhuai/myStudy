package algorithm.school_hire_2019.disifanshi;

import java.util.Scanner;

/**
 * 给定一个二维整型矩阵，已知矩阵的每一行都按照从小到大的顺序排列，
 * 每一列也都按照从小到大的顺序排列。现在给出一个数，请写一个函数返回该数是否存在于矩阵中。
 * @author lihaoyu
 * @date 2019/11/5 13:50
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        if(m == 0 || n == 0){
            System.out.println(false);
            return;
        }
        int[][] nums = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                nums[i][j] = scanner.nextInt();
            }
        }
        int key = scanner.nextInt();
        System.out.println(fun(nums,key));

    }

    private static boolean fun(int[][] nums, int key) {
        int m = nums.length;
        int n = nums[0].length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(nums[i][j] == key){
                return true;
            }
            if(nums[i][j] > key){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
