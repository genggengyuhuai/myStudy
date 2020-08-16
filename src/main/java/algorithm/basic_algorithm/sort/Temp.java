package algorithm.basic_algorithm.sort;

/**
 * @author lihaoyu
 * @date 2020/8/16 5:27 下午
 */
public class Temp {

    private static class Node{
        Node next;

    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1, tempIndex = 0, left = start, right = mid + 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start+1];
        while (left <= mid && right <= end)
            temp[tempIndex++] = nums[left] <= nums[right] ? nums[left++] : nums[right++];
        while (left <= mid) temp[tempIndex++] = nums[left++];
        while (right <= end) temp[tempIndex++] = nums[right++];
        System.arraycopy(temp, 0, nums, start, end - start+1);
    }

    public static void main(String[] args) {
        int[] temp = new int[]{5, 3, 1, 8, 6, 3, 0};
        mergeSort(temp, 0, 6);
        for (int i : temp) {
            System.out.print(i + " ");
        }

    }

}
