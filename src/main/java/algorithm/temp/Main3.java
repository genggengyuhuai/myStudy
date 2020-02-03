package algorithm.temp;

import java.util.ArrayList;
import java.util.List;

/**
 *  模仿 python 的 permutation
 *  1,2,3 的结果 [[1], [2], [3], [2, 3], [1, 2], [1, 3], [1, 2, 3]]
 * @author lihaoyu
 * @date 2020/1/3 15:20
 */
public class Main3 {
    public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        ArrayList<Integer> tempList = new ArrayList<>(subset);

        res.add(tempList);

        inOrder(nums, i + 1, tempList, res);

        tempList.add(nums[i]);

        inOrder(nums, i + 1, tempList, res);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        inOrder(new int[]{1, 2, 3, 4}, 0, new ArrayList<>(), res);
        System.out.println(res);
    }


}
