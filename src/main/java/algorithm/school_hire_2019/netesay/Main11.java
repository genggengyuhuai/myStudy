package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * 19 网易 校招  16通过率
 * 题目描述
 * 又到了丰收的季节，恰逢小易去牛牛的果园里游玩。
 * 牛牛常说他对整个果园的每个地方都了如指掌，小易不太相信，所以他想考考牛牛。
 * 在果园里有N堆苹果，每堆苹果的数量为ai，小易希望知道从左往右数第x个苹果是属于哪一堆的。
 * 牛牛觉得这个问题太简单，所以希望你来替他回答。
 * 输入描述:
 * 第一行一个数n(1 <= n <= 105)。
 * 第二行n个数ai(1 <= ai <= 1000)，表示从左往右数第i堆有多少苹果
 * 第三行一个数m(1 <= m <= 105)，表示有m次询问。
 * 第四行m个数qi，表示小易希望知道第qi个苹果属于哪一堆。
 * 输出描述:
 * m行，第i行输出第qi个苹果属于哪一堆。
 * @author lihaoyu
 * @date 2019/9/14 23:28
 */
public class Main11 {


    /**
     *  二分查找
     *  nums是递增的从0开始，返回k落在哪两个区间，取左侧nums值
     * @author lihaoyu
     * @date 2019/9/14 23:34
     */
    private static int fun(int[] nums, int k){
        int start = 0, end = nums.length - 1;
        int middle;
        while(start <= end){
            middle = (start + end) / 2;
            if(nums[middle] == k){
                return middle;
            }
            if(nums[middle] > k){
                end = middle - 1;
            }
            else{
                start = middle + 1;
            }
        }
        // 到这肯定 start = end + 1
            return start;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        int[] startIndex = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 1; i < n; i++){
            startIndex[i] = startIndex[i-1] + nums[i-1];
        }
        int m = scanner.nextInt();
        for(int i = 0; i < m; i++){
            System.out.println(fun(startIndex, scanner.nextInt()));
        }

    }
}












