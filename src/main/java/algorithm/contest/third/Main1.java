package algorithm.contest.third;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/31 9:34
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String next = scanner.next();
            char[] chars = next.toCharArray();
            int[] numbers = new int[chars.length];
            for (int i1 = 0; i1 < chars.length; i1++) {
                numbers[i1] = Character.digit(chars[i1],10);
            }
            int res = 0;
            for(int i = 0; i < numbers.length; i++){
                for(int j = i+1; j + j - i <= numbers.length; j++){
                    int temp1 = 0;
                    for(int k = i; k < j; k++){
                        temp1 += numbers[k];
                        temp1 -= numbers[k+j-i];
                    }
                    if(temp1 == 0){
                        res = Math.max(res,j-i);
                    }
                }
            }
            System.out.println(res * 2);
        }
    }

}
