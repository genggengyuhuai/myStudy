package algorithm.contest.review;

import java.util.Scanner;

/**
 * 和最大的连续降序字符
 * @author lihaoyu
 * @date 2019/12/2 15:18
 */
public class Main2 {

    private static int fun(char[] cs, int i, int j){
        int sum = 0;
        for(;i<j;i++){
            sum += cs[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        for (int n = 0; n < N; n++) {
            char[] chars = scanner.next().toCharArray();
            int[] gaps = new int[chars.length];
            gaps[0] = -1;
            for (int i = 1; i < chars.length; i++) {
                gaps[i] = chars[i] - chars[i-1];
            }
            int i = 0, j;
            int minLen = Integer.MIN_VALUE;
            while(i < gaps.length){
                if(gaps[i] <= 0){
                    i++;
                    continue;
                }
                j = i + 1;
                while(j < gaps.length && gaps[j] == gaps[j-1]){
                    j++;
                }
                minLen = Math.max(minLen, j - i);
                i = j;
            }
            int sum = 0;
            String res = "";
            i = 0;
            while(i < gaps.length){
                if(gaps[i] <= 0){
                    i++;
                    continue;
                }
                j = i + 1;
                while(j < gaps.length && gaps[j] == gaps[j-1]){
                    j++;
                }
                if(j - i == minLen && fun(chars,i,j) > sum){
                    res = String.copyValueOf(chars,i-1,minLen+1);
                }
                i = j;
            }
            if(res.length() >= 3)
            System.out.println(new StringBuilder(res).reverse());

        }
    }
}
