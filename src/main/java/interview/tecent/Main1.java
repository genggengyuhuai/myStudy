package interview.tecent;

import java.util.Arrays;

/**
 * 已知数组A中有且只有唯一两个值的和等于B，求这两个值在数组中的位置
 *
 * 玛德，垃圾啊， 用 hash 就 O(n) 了
 * @author Lihaoyu
 * @date 3/13/2020 8:38 PM
 */
public class Main1 {

    private static class Node implements Comparable<Node>{
        private int value;
        private int index;

        public Node(int value, int index){
            this.value = value;
            this.index = index;
        }

        public int compareTo(Node other){
            return this.value - other.value;
        }
    }

    private static void fun(int[] nums, int target){
        Node[] nodes = new Node[nums.length];
        for(int i = 0; i < nums.length; i++)
            nodes[i] = new Node(nums[i], i);
        Arrays.sort(nodes);

        int left = 0, right = nums.length - 1;
        // 一定存在
        while(true){
            if(nodes[left].value + nodes[right].value == target){
                System.out.print("两个位置是 "+ nodes[left].index + ","+ nodes[right].index);
                break;
            }
            else if(nodes[left].value + nodes[right].value < target) left++;
            else right--;
        }
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        fun(new int[]{3,1,2,5,7},10);
    }
}