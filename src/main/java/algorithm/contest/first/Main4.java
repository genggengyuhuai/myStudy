package algorithm.contest.first;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/26 10:34
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            int len1 = scanner.nextInt();
            int len2 = scanner.nextInt();
            Integer[] numbers1 = new Integer[len1];
            Integer[] numbers2 = new Integer[len2];
            for(int i = 0; i < len1; i++){
                numbers1[i] = scanner.nextInt();
            }
            for(int i = 0; i < len2; i++){
                numbers2[i] = scanner.nextInt();
            }
            List<Integer> list2 = new ArrayList<>(Arrays.asList(numbers2));
            int[] count = new int[len2];
            List<Integer> readyToSort = new ArrayList<>();
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < len1; i++){
                if(list2.contains(numbers1[i])){
                        count[list2.indexOf(numbers1[i])]++;
                }else{
                    readyToSort.add(numbers1[i]);
                }
            }
            for(int i = 0; i < len2; i++){
                for(int j = 0; j < count[i]; j++){
                    res.add(list2.get(i));
                }
            }
            Collections.sort(readyToSort);
            res.addAll(readyToSort);
            //输出
            for(int j = 0; j < res.size(); j++){
                if(j != res.size() - 1){
                    System.out.print(res.get(j)+" ");
                }else{
                    System.out.println(res.get(j));
                }
            }

        }
    }
}
