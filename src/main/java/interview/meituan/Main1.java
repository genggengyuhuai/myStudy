package interview.meituan;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 3/12/2020 7:03 PM
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[][] dp = new long[2][n];
        boolean[][] src = new boolean[2][n];
        String firstLine = scanner.next();
        String secondLine = scanner.next();
        for (int i = 0; i < n; i++) {
            if(firstLine.charAt(i) == '.') src[0][i] = true;
            if(secondLine.charAt(i) == '.') src[1][i] = true;
        }
        dp[0][0] = src[0][0] ? 1 : 0; dp[1][0] = 0;
        for(int i = 1; i < n; i++){
            if(src[0][i]){
                dp[0][i] = dp[0][i-1] + dp[1][i-1];
            }
            if(src[1][i]){
                dp[1][i] = dp[1][i-1] + dp[0][i-1];
            }
        }
        System.out.println(dp[1][n-1] == 0 ? -1 : dp[1][n-1]);

    }



}
