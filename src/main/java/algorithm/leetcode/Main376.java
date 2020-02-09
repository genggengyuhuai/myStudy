package algorithm.leetcode;

import java.util.ArrayList;

/**
 * 贪心，单调栈
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * @author lihaoyu
 * @date 2/7/2020 10:08 PM
 */
public class Main376 {

    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        int first = nums[0], startIndex = 0;
        for(int i = 1; i < nums.length-1; i++){
            if(nums[i] != nums[i-1]){
                first = nums[i-1];
                startIndex = i;
                break;
            }
        }
        if(first == nums[nums.length-1]) return 1;

        boolean inc = first < nums[startIndex];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(first);
        list.add(nums[startIndex]);
        for(int i = startIndex+1; i < nums.length; i++){
            if(inc){
                if(list.get(list.size()-1) <= nums[i]){
                    list.remove(list.size()-1);
                }else{
                    inc = !inc;
                }
                list.add(nums[i]);
            }else{
                if(list.get(list.size()-1) >= nums[i]){
                    list.remove(list.size()-1);
                }else{
                    inc = !inc;
                }
                list.add(nums[i]);
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));

    }
}
