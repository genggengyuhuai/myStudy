package algorithm.contest.first;


import java.util.Arrays;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/26 10:22
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            int[] copies = new int[n];
            for(int i = 0; i < n; i++){
                numbers[i] = scanner.nextInt();
                copies[i] = numbers[i];
            }
            Arrays.sort(copies);
            int count = 0;
            for(int i = 0; i < n; i++){
                if(copies[i] != numbers[i]){
                    int index = 0;
                        count++;
                    for(int k = 0; k < n; k++){
                        if(numbers[k] == copies[i]){
                            index = k;
                            break;
                        }
                    }
                    // 交换
                    int temp = numbers[index];
                    numbers[index] = numbers[i];
                    numbers[i] = temp;
                }
            }

            System.out.println(count);

        }
    }
}
