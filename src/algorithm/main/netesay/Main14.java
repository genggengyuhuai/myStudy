package algorithm.main.netesay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/10 9:03
 */
public class Main14 {

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        List<Integer> fromList = new ArrayList<>();
        List<Integer> toList = new ArrayList<>();
        int[] numbers = new int[n];
        int count = 0;
        int unStable = 0;
        for(int i = 0; i < n; i++){
            numbers[i] = scanner.nextInt();
        }
        if(n == 1) {
            System.out.println(0+" "+0);
            System.exit(0);
        }
        if(k == 0){
            int minIndex = 0, maxIndex = 0;
                for (int i = 0; i < n; i++) {
                    if (numbers[i] > numbers[maxIndex]) {
                        maxIndex = i;
                    }
                    if (numbers[i] < numbers[minIndex]) {
                        minIndex = i;
                    }
                }
            unStable =   numbers[maxIndex] - numbers[minIndex];
        }


        int minIndex = 0, maxIndex = 0;
        for(int j = 0; j < k; j++){
            for (int i = 0; i < n; i++) {
                if (numbers[i] > numbers[maxIndex]) {
                    maxIndex = i;
                }
                if (numbers[i] < numbers[minIndex]) {
                    minIndex = i;
                }
            }
            if(numbers[maxIndex] - numbers[minIndex] <= 1)
            {
                unStable = numbers[maxIndex] - numbers[minIndex];
                break;
            }
            fromList.add(maxIndex+1);
            toList.add(minIndex+1);
            numbers[maxIndex]--;
            numbers[minIndex]++;
            unStable = numbers[maxIndex] - numbers[minIndex];
            minIndex = 0;
            maxIndex = 0;
            count++;
        }
        System.out.println(unStable +" "+ count);
        for(int i = 0; i < fromList.size(); i++){
            System.out.println(fromList.get(i)+" "+toList.get(i));
        }
    }


}
