package algorithm.school_hire_2019.bytedance;

import java.util.Scanner;

/**
 * 	万万没想到之抓捕孔连顺
 * 	1. 我们在字节跳动大街的N个建筑中选定3个埋伏地点。
 * 2. 为了相互照应，我们决定相距最远的两名特工间的距离不超过D。
 * 计算在这次行动中，大锤的小队有多少种埋伏选择。
 * @author lihaoyu
 * @date 2019/12/24 13:20
 */
public class Main2 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int dis = scanner.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = scanner.nextInt();
        }
        int left = 0, right = 0, res = 0;
        while(left < N){
            while(right < N && nums[right] - nums[left] <= dis)
                    right++;
            if(right - left >= 3){
                res += right - left - 2;
            }
            left++;
        }
    }
}
