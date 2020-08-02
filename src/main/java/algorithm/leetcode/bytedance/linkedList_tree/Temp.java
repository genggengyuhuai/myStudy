package algorithm.leetcode.bytedance.linkedList_tree;

/**
 * 手搓堆排
 * @author lihaoyu
 * @date 2020/8/1 7:01 上午
 */
public class Temp {

    // 向下堆化
    private static void heapify(int[] nums, int i, int len){
        while(true){
            int minIndex = i;
            if(2 * i + 1 < len && nums[minIndex] > nums[2*i+1])  minIndex = 2 * i + 1;
            if(2 * i + 2 < len && nums[minIndex] > nums[2 * i + 2]) minIndex = 2 * i + 2;
            if(minIndex == i) break;
            swap(nums, i, minIndex);
            // 继续往下走
            i = minIndex;
        }
    }

    // 建堆
    private static void buildHeap(int[] nums){
        for(int i = nums.length / 2; i >= 0; i--){
            heapify(nums, i, nums.length);
        }
    }

    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    private static void heapSort(int[] a){
        if(a == null || a.length == 0) return;
        // 建堆
        buildHeap(a);
        // 调整堆
        for(int i = 0; i < a.length; i++){
            swap(a, 0, a.length - i - 1);
            heapify(a, 0, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{7,1,4,2,6,0};
        heapSort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
