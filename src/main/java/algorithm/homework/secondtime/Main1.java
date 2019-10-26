package algorithm.homework.secondtime;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 子数组的取值范围 Description 给定数组arr和整数num，求arr的连续子数组中满足：其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。 Input
 * 输入第一行为测试用例个数。每一个用例有若干行，第一行为数组，每一个数用空格隔开，第二行为num。
 *
 * @author lihaoyu
 * @date 2019/10/11 17:25
 */
public class Main1 {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            res += arr.length - j;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for (int caseNumber = 0; caseNumber < caseCount; caseNumber++) {
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] split = line.split("( )+");
            int[] numbers = new int[split.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = Integer.parseInt(split[i]);
            }
            int num = scanner.nextInt();
            System.out.println(getNum(numbers, num));
        }
    }
}
