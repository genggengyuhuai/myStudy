package algorithm.school_hire_2019.wangyihuyu;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/29 23:14
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] counts = new int[33];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int count;
            for (int i = 0; i < n; i++) {
                count = 0;
                while(nums[i] != 0){
                    if((nums[i] & 1) == 1)
                    count++;
                    nums[i] >>= 1;
                }
                counts[count] = 1;
            }
            count = 0;
            for (int i = 0; i < counts.length; i++) {
                count += (counts[i] == 0 ? 0 : 1);
            }
            System.out.println(count);

        }
    }

}
