package algorithm.school_hire_2019.zhaohang;

import java.util.Scanner;

/**
 *爱吃喵粮的小招喵
 *
 * 小招喵喜欢吃喵粮。这里有 N 堆喵粮，第 i 堆中有 p[i] 粒喵粮。喵主人离开了，将在 H 小时后回来。
 *
 * 小招喵可以决定她吃喵粮的速度 K （单位：粒/小时）。每个小时，她将会选择一堆喵粮，从中吃掉 K 粒。如果这堆喵粮少于 K 粒，她将吃掉这堆的所有喵粮，然后这一小时内不会再吃更多的喵粮。
 *
 * 小招喵喜欢慢慢吃，但仍然想在喵主人回来前吃掉所有的喵粮。
 *
 * 返回她可以在 H 小时内吃掉所有喵粮的最小速度 K（K 为整数）。
 * @author lihaoyu
 * @date 2019/10/23 13:06
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] numbers = new int[split.length];
        int max = 0;
        for(int i  = 0; i < split.length; i++){
            numbers[i] = Integer.parseInt(split[i]);
            max = Math.max(numbers[i],max);
        }
        int H = scanner.nextInt();
        int K = max;
        int left = 1;
        int right = K;
        int mid;

        while(left < right){
            mid = (left + right) / 2;
            int sum = 0;
            for(int i = 0; i < numbers.length; i++){
                sum += numbers[i] % mid == 0 ? numbers[i] / mid : numbers[i] / mid + 1;
            }
            if(sum > H){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        System.out.println(left);


    }
}
