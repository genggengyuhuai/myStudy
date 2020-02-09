package algorithm.leetcode;

/**
 * 贪心，重点在答案唯一。
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * 说明: 
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * @author lihaoyu
 * @date 2/7/2020 5:38 PM
 */
public class Main134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gas_sum = 0, cost_sum = 0, tempSum = 0,
                tempMin = gas[0] - cost[0], minIndex = 0;
        for (int i : gas) gas_sum += i;
        for(int i : cost) cost_sum += i;
        if(cost_sum > gas_sum) return -1;
        for(int i = 0; i < gas.length; i++){
            tempSum += (gas[i] - cost[i]);
            if(tempMin >= tempSum){
                tempMin = tempSum;
                minIndex = i;
            }
        }
        return (minIndex+1) >= gas.length ? 0 : (minIndex+1);
    }

    public static void main(String[] args) {

    }
}
