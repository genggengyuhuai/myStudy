package algorithm.leetcode.bytedance.array_sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数组中的第K个最大元素
 * @author lihaoyu
 * @date 2020/7/4 7:56 下午
 */
public class Main5 {


    public int findKthLargest(int[] nums, int k) {
        // 默认是小顶堆
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k){
                queue.add(nums[i]);
            }else if(nums[i] >= queue.peek()){
                queue.poll();
                queue.add(nums[i]);
            }
            // 小于堆顶，什么都不做
        }
        return queue.peek();
    }


    public static void main(String[] args) {

    }
}
