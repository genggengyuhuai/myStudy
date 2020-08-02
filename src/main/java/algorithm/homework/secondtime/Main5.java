package algorithm.homework.secondtime;

import java.util.Scanner;

/**
 * Description
 * 找到给定数组的给定区间内的第K小的数值。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的第一行为数组，每一个数用空格隔开；
 * 第二行是区间（第几个数到第几个数，两头均包含），两个值用空格隔开；第三行为K值。
 *
 * @author lihaoyu
 * @date 2019/10/10 9:58
 */
public class Main5 {

    public static int fun(int[] a,int start, int end, int k){
        if(start >= end){
            return a[start];
        }
        int key = a[start],left = start,right = end;
        while(start < end){
            while(start < end && a[end] >= key) end--;
            a[start] = a[end];
            while(start < end && a[start] <= key) start++;
            a[end] = a[start];
        }
        a[start] = key;
        if(start == k) return key;
        if(k < start) return fun(a,left,start-1,k);
        else return fun(a,start+1,right,k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = scanner.nextInt();
        for(int casec = 0; casec < caseCount; casec++){
            scanner.nextLine();
            String line = scanner.nextLine();
            String[] split = line.split(" ");
            int[] number = new int[split.length];
            for(int i = 0; i < split.length; i++){
                number[i] = Integer.parseInt(split[i]);
            }
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt() - 1;
            int[] newNumber = new int[end - start + 1];
            for(int i = start,j=0; i <= end; i++){
                newNumber[j++] = number[i];
            }
            int k = scanner.nextInt() - 1;
            System.out.println(fun(newNumber,0,end-start,k));

        }


    }

}
