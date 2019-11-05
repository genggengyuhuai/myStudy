package algorithm.school_hire_2019.zhaohang;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/28 9:27
 */
public class Main12 {
        public static int count = 0;

    public static void fun(int[] a, int start, int end){
        int mid = (start + end) / 2;
        if(start < end){
            fun(a,start,mid);
            fun(a,mid+1,end);
        }
        int[] temp = new int[end - start + 1];
        int i = 0,left = start,right = mid+1;
            while(left <= mid && right <= end){
                if(a[left] <= a[right]){
                    temp[i++] = a[left++];
                }else{
                    count += (mid - left + 1);
                    temp[i++] = a[right++];
                }
            }
            while(left <= mid){
                temp[i++] = a[left++];
            }
            while(right <= end){
            temp[i++] = a[right++];
        }
        System.arraycopy(temp,0,a,start,end - start + 1);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = scanner.nextInt();
        }
        fun(a,0,N-1);
        System.out.println(count);
    }
}
