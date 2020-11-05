package algorithm.basic_algorithm.search;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2019/10/3 22:51
 */
public class SearchTest{

    // 简单二分查找
    public static int simpleBinarySearch(int[] a, int goal) {
        int begin = 0;
        int end = a.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (a[mid] == goal) {
                return mid;
            }
            else if (mid > goal) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }

        return -1;
    }

    // 寻找第一个等于goal值的下标
    public static int firstBinarySearch(int[] a, int goal) {
        int begin = 0;
        int end = a.length - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (a[mid] == goal) {
                if (mid == 0 || a[mid - 1] != goal)
                    return mid;
                end = mid - 1;
            }
            else if (a[mid] > goal) {
                end = mid - 1;
            }
            else {
                begin = mid + 1;
            }
        }
        return -1;
    }

    // 寻找第一个大于等于目标值的index，要求先要有序
    public static int firstGreaterBinarySearch(int[] a, int goal) {
        int start = 0;
        int end = a.length - 1;
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] >= goal) {
                if (mid == 0 || a[mid - 1] < goal)
                    return mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>(16);
        int[] a = new int[]{1, 1, 3, 3, 3, 5, 7, 9, 11, 11};
        System.out.println(simpleBinarySearch(a, 9));
        System.out.println(firstBinarySearch(a, 3));
        System.out.println(firstGreaterBinarySearch(a, 12));
    }


}
