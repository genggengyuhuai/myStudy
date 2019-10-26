package algorithm.school_hire_2019.kuaishou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 最长递增子序列  O(n * lg(n))
 *
 * 小明有一袋子长方形的积木，如果一个积木A的长和宽都不大于另外一个积木B的长和宽，则积木A可以搭在积木B的上面。好奇的小明特别想知道这一袋子积木最多可以搭多少层，你能帮他想想办法吗？
 * 定义每一个长方形的长L和宽W都为正整数，并且1 <= W <= L <= INT_MAX, 袋子里面长方形的个数为N, 并且 1 <= N <= 1000000.
 * 假如袋子里共有5个积木分别为 (2, 2), (2, 4), (3, 3), (2, 5), (4, 5), 则不难判断这些积木最多可以搭成4层, 因为(2, 2) < (2, 4) < (2, 5) < (4, 5)。
 *
 * @author lihaoyu
 * @date 2019/10/15 13:57
 */
class Rectangle implements Comparable<Rectangle>{

    int x;
    int y;

    public Rectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Rectangle o) {
        if( x != o.x) return x - o.x;
        return y - o.y;
    }
}


public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Rectangle> list = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            int L = scanner.nextInt();
            int W = scanner.nextInt();
            if(L > W){
                list.add(new Rectangle(L, W));
            }else{
                list.add(new Rectangle(W, L));
            }
        }
        Collections.sort(list);
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = list.get(i).y;
        }

        int[] res = new int[n];
        int end = 0;
        res[end] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] >= res[end]){
                res[++end] = nums[i];
                continue;
            }
            int index = firstGreaterBinarySearch(res,0,end,nums[i]);
            res[index] = nums[i];
        }
        System.out.println(end+1);

    }

    // 寻找第一个大于目标值的index ,要求数据已经有序
    public static int firstGreaterBinarySearch(int[] a,int start, int end, int goal) {
        int mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (a[mid] > goal) {
                if (mid == 0 || a[mid - 1] <= goal)
                    return mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
