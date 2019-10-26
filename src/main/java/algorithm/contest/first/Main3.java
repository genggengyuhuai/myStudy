package algorithm.contest.first;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/26 9:44
 */
public class Main3 {
        public static int count = 0;

    public static void merge_solve(int[] A, int start, int end){
        if(start >= end) return;
        int s = start;
        int e = end;
        int mid = (start + end) / 2;
        merge_solve(A, s, mid);
        merge_solve(A, mid + 1, e);
        int[] tmp = new int[end - start + 1];
        int j = 0;
        int s2 = mid + 1;

        while(s <= mid && s2 <= e){
            if(A[s] <= A[s2])
                tmp[j++] = A[s++];
            else{
                count += (mid - s + 1);
                tmp[j++] = A[s2++];
            }
        }
        while(s <= mid)
            tmp[j++] = A[s++];
        while(s2 <= e)
            tmp[j++] = A[s2++];

        //复制数据
        s = start;
        while(s <= e){
            A[s] = tmp[s - start];
            s++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = scanner.nextInt();
            }
            merge_solve(a,0,n-1);
            System.out.println(count);
            count = 0;
        }


    }


}
