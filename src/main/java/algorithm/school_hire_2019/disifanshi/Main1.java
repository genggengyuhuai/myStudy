package algorithm.school_hire_2019.disifanshi;

/**
 * @author lihaoyu
 * @date 2019/11/3 9:14
 */
public class Main1 {
    public static void main(String[] args) {
        int m = 4,n = 4;
        int[][] a = new int[n][m];
        int count = 1;
        for(int col = 0; col < m;col++){
            for(int row = 0; row < n && col - row >= 0; row++){
                a[row][col-row] = count++;
            }
        }
        for(int row = 1; row < n; row++){
            for(int temp = 0;row + temp < n && m - temp  >= 1; temp++){
                a[row + temp][m - temp - 1] = count++;
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(j != m-1) {
                    System.out.print(a[i][j]+" ");
                }else{
                    System.out.print(a[i][j]);
                }
            }
            System.out.println();
        }


    }
}
