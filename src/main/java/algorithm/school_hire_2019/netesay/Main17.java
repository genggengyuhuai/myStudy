package algorithm.school_hire_2019.netesay;


import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 塔
 * 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
 * 现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
 * 小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
 * 注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
 * 现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
 * @author lihaoyu
 * @date 2020/2/12 17:15
 */
public class Main17 {

    private static class Tower implements Comparable<Tower>{
        int height;
        int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index;
        }

        @Override
        public int compareTo(Tower o) {
            return height - o.height;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        Queue<Tower> smallHeap = new PriorityQueue<>();
        Queue<Tower> bigHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            smallHeap.add(new Tower(nums[i],i+1));
            bigHeap.add(new Tower(nums[i],i+1));
        }
        int[] x = new int[k];
        int[] y = new int[k];
        int top = 0, instability = 0;
        while((instability = bigHeap.peek().height - smallHeap.peek().height) > 1 && k > 0){
            Tower bigTemp = bigHeap.poll();
            bigTemp.height--;
            bigHeap.add(bigTemp);
            Tower smallTemp = smallHeap.poll();
            smallTemp.height++;
            smallHeap.add(smallTemp);
            k--;
            x[top] = bigTemp.index;
            y[top] = smallTemp.index;
            top++;
        }
        System.out.print(instability);
        System.out.println(" "+top);
        for (int i = 0; i < top; i++) {
            System.out.println(x[i]+" "+y[i]);
        }

    }
}
