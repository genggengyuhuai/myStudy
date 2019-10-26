package algorithm.temp;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */

public class Solution {

    private int count;

    private PriorityQueue<Integer> maxQueue = new PriorityQueue<>(100, Collections.reverseOrder());
    private PriorityQueue<Integer> minQueue = new PriorityQueue<>(100);

    public void Insert(Integer num) {
        if(maxQueue.isEmpty()){
            maxQueue.add(num);
            count++;
        }
        else if(num > maxQueue.peek()){
            minQueue.add(num);


        }

    }

    public Double GetMedian() {
        if((count & 1) == 0){
            return (maxQueue.peek() + minQueue.peek()) / 2.0;
        }
        else {
            return maxQueue.peek()+0.0;
        }
    }


}