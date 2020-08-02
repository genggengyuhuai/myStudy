package algorithm.contest.first;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/26 9:22
 */
public class Main1{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 0; i < T; i++){
            int n = scanner.nextInt();
            int[] counts = new int[500];
            int[] numbers = new int[n];
            for(int j = 0; j < n; j++){
                numbers[j] = scanner.nextInt();
                counts[numbers[j]+150]++;
            }
            List<Integer> list = new ArrayList<>();
            for(int k = 0; k < 500; k++){
                int max = 0;
                int max_index = 0;
                for(int j = 0; j < 500; j++){
                    if(counts[j] > max){
                        max = counts[j];
                        max_index = j;
                    }
                }
                for(int m = 0; m < max; m++){
                    list.add(max_index-150);
                }
                counts[max_index] = 0;
            }

            //输出
            for(int j = 0; j < list.size(); j++){
                if(j != list.size() - 1){
                    System.out.print(list.get(j)+" ");
                }else{
                    System.out.println(list.get(j));
                }
            }




        }

    }


}
