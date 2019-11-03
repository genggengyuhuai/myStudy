package algorithm.contest.third;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/31 9:06
 */
public class Main2 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] numbers = new int[N];
            for (int i1 = 0; i1 < N; i1++) {
                numbers[i1] = scanner.nextInt();
            }
            int[] counts = new int[M];
            for (int i1 = 0; i1 < M; i1++) {
                int query = scanner.nextInt();
                for(int j = 0; j < N; j++){
                    if(numbers[j] % query == 0) {
                        counts[i1]++;
                    }
                }
            }
            for (int i1 = 0; i1 < counts.length; i1++) {
                if(i1 != counts.length - 1){
                    System.out.print(counts[i1]+" ");
                }else{
                    System.out.println(counts[i1]);
                }
            }

        }
    }
}
