package algorithm.homework.secondtime;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 固定和的元素对
 * Description
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入第一行是数组，每一个数用空格隔开；第二行是数字和。
 *
 * @author lihaoyu
 * @date 2019/10/10 11:09
 */
public class Main6 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for(int caseNumber = 0; caseNumber < caseCount; caseNumber++){
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int[] numbers = new int[split.length];
            for(int i = 0; i <numbers.length; i++){
                numbers[i] = Integer.parseInt(split[i]);
            }
            int sum = scanner.nextInt();
            Arrays.sort(numbers);
            int left = 0, right = numbers.length - 1;
            int count = 0;
            while(left < right){
                int temp_sum = numbers[left] + numbers[right];
                if(temp_sum == sum){
                    left++;
                    right--;
                    count++;
                }
                else if(temp_sum > sum){
                    right--;
                }
                else{
                    left++;
                }

            }
            System.out.println(count);


        }
    }
}
