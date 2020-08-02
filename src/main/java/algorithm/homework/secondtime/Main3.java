package algorithm.homework.secondtime;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 数组和窗口
 * Description
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个元素使用空格隔开；第二行为窗口大小。
 *
 * Output
 * 输出每个测试用例结果。
 *
 * @author lihaoyu
 * @date 2019/10/10 10:27
 */
public class Main3 {

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
            int w = scanner.nextInt();
            int res = 0;
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < numbers.length; i++){
                while(!list.isEmpty() && numbers[list.peekLast()] < numbers[i]){
                    list.pollLast();
                }
                list.addLast(i);
                if( i - w >= list.peekFirst()){
                    list.pollFirst();
                }
                if(i + 2 > w){
                    res += numbers[list.peekFirst()];
                }
            }
            System.out.println(res);
        }
    }
}
