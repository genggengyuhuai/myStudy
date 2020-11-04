package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 要一维空间做
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * @author lihaoyu
 * @date 2/6/2020 9:35 PM
 */
public class Main120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0)  return 0;
        int[] tempSum = new int[triangle.get(triangle.size()-1).size()];
        tempSum[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = triangle.get(i).size()-1; j >= 0; j--) {
                if(j == 0) tempSum[j] = tempSum[0] + triangle.get(i).get(j);
                else if(j == triangle.get(i).size() - 1)
                    tempSum[j] = tempSum[j-1] +  triangle.get(i).get(j);
                else  tempSum[j] = triangle.get(i).get(j) + Math.min(tempSum[j],tempSum[j-1]);
            }
        }
        int min = tempSum[0];
        for (int i : tempSum) {
           min = Math.min(min,i);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer>temp1 = new ArrayList<>();
        List<Integer>temp2 = new ArrayList<>();
        List<Integer>temp3 = new ArrayList<>();
        List<Integer>temp4 = new ArrayList<>();
        temp1.add(2);
        temp2.add(3);temp2.add(4);
        temp3.add(6);temp3.add(5);temp3.add(7);
        temp4.add(4);temp4.add(1);temp4.add(8);temp4.add(3);
        list.add(temp1);
        list.add(temp2);
        list.add(temp3);
        list.add(temp4);
        System.out.println(minimumTotal(list));
    }
}
