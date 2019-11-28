package algorithm.jianzhi_offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 * @author lihaoyu
 * @date 2019/11/28 17:42
 */
public class Solution1 {

    // 大顶堆，个数 n 或 n+1  保存较小的
    // 小顶堆，个数 n 保存较大的
    private Queue<Integer> bigQueue = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> smallQueue = new PriorityQueue<>();

    public void Insert(Integer num) {
        if (bigQueue.isEmpty()) {
            bigQueue.add(num);
            return;
        }
        if (num <= bigQueue.peek()) {
            bigQueue.add(num);
            if (bigQueue.size() > smallQueue.size() + 1) {
                smallQueue.add(bigQueue.poll());
            }
        } else {
            smallQueue.add(num);
            if (smallQueue.size() > bigQueue.size()) {
                bigQueue.add(smallQueue.poll());
            }
        }
    }

    public Double GetMedian() {
        if (bigQueue.size() == smallQueue.size()) {
            return (bigQueue.peek() + smallQueue.peek() + 0.0) / 2;
        }
        return bigQueue.peek() + 0.0;
    }

    public static void main(String[] args) {
        Solution1 temp = new Solution1();
        temp.Insert(5);
        System.out.println(temp.GetMedian());
        temp.Insert(2);
        System.out.println(temp.GetMedian());
        temp.Insert(3);
        System.out.println(temp.GetMedian());
        temp.Insert(4);
        System.out.println(temp.GetMedian());
        temp.Insert(1);
        System.out.println(temp.GetMedian());
        temp.Insert(6);
        System.out.println(temp.GetMedian());
        temp.Insert(7);
        System.out.println(temp.GetMedian());
        temp.Insert(0);
        System.out.println(temp.GetMedian());
        temp.Insert(8);
        System.out.println(temp.GetMedian());
    }

}
