package algorithm.school_hire_2019.netesay;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 你有3个需要完成的任务，完成这3个任务是需要付出代价的。
 * 首先，你可以不花任何代价的完成一个任务；然后，在完成了第i个任务之后，你可以花费|Ai - Aj|的代价完成第j个任务。|x|代表x的绝对值。
 * 计算出完成所有任务的最小代价。
 * @author lihaoyu
 * @date 2020/1/4 15:56
 */
public class Main16 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[3];
        for (int i = 0; i < 3; i++) {
            nums[i] = scanner.nextInt();
        }
        Arrays.sort(nums);
        int count = Math.abs(nums[1]-nums[0]);
        count += Math.min(nums[2] - nums[0], nums[2] - nums[1]);
        System.out.println(count);

    }

}
