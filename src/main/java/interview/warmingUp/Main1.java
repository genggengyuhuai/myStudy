package interview.warmingUp;


/**
 * warming up
 *
 * @author lihaoyu
 * @date 2020/8/26 10:37 上午
 */
public class Main1 {

    private static class MyQueue {
        int size, head, tail, capacity;
        String[] table;

        void addLast(String str) {
            if (size == capacity)
                System.out.println("扩容");
            table[tail = (tail + 1) % capacity] = str;
            size++;
        }
    }

    private static void heapSort(int[] nums) {
        buildHeap(nums);
        for (int i = 0; i < nums.length; i++) {
            swap(nums, 0, nums.length - 1 - i);
            //   减 2
            heapify(nums, 0, nums.length - 2 - i);
        }
    }

    // 建堆
    private static void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            heapify(nums, i, nums.length - 1);
        }
    }

    // 向下堆化
    private static void heapify(int[] nums, int i, int length) {
        while (true) {
            int maxIndex = i;
            if (2 * i + 1 <= length && nums[2 * i + 1] > nums[maxIndex]) maxIndex = 2 * i + 1;
            if (2 * i + 2 <= length && nums[2 * i + 2] > nums[maxIndex]) maxIndex = 2 * i + 2;
            if (i == maxIndex) return;
            swap(nums, i, maxIndex);
            i = maxIndex;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 1, 9, 2, 8, 2, 3, 7};
        heapSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
