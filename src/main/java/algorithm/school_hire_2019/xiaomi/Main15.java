package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 *  小米	旋转数组中的最小元素	604	19.34%
 * @author lihaoyu
 * @date 2019/11/12 12:34
 */
public class Main15{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = new int[1000000];
        int n = 0;
        while(scanner.hasNext()){
            nums[n++] = scanner.nextInt();
        }
        int left = 0, right = n - 1;
        int mid;
        while(left < right){
            mid = (left + right) >> 1;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right = right - 1;
            }
        }
        System.out.println(nums[left]);
    }
}
