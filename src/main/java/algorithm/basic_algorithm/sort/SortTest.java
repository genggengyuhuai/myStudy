package algorithm.basic_algorithm.sort;

/**
 * @author lihaoyu
 * @date 2019/9/11 20:55
 */
public class SortTest {

    // 希尔排序  分组插排
    private static void shellSort(int[] a) {
        int gap, i, j, temp;
        for (gap = a.length / 2; gap > 0; gap /= 2) {
            for (i = gap; i < a.length; i++) {
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap) {
                    temp = a[j];
                    a[j] = a[j + gap];
                    a[j + gap] = temp;
                }
            }
        }
    }


    // 稳定 归排
    public static void mergeSort(int[] a, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int start1 = start, start2 = mid + 1, index = 0;
        while (start1 <= mid && start2 <= end) {
            if (a[start1] <= a[start2]) temp[index++] = a[start1++];
            else temp[index++] = a[start2++];
        }
        while (start1 <= mid) temp[index++] = a[start1++];
        while (start2 <= end) temp[index++] = a[start2++];
        System.arraycopy(temp, 0, a, start, end - start + 1);
    }

    // 不稳定 快排
    public static void quickSort(int[] a, int start, int end) {
        if (start >= end) return;
        int key = a[start], left = start, right = end;
        while (start < end) {
            while (start < end && a[start] >= key) end--;
            a[end] = a[start];
            while (start < end && a[start] <= key) start++;
            a[start] = a[end];
        }
        a[end] = key;
        quickSort(a, left, end - 1);
        quickSort(a, end + 1, right);
    }

    // 不稳定 选择排序
    public static void selectionSort(int[] a) {
        int len = a.length, min = Integer.MAX_VALUE, index = 0, temp = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (a[j] < min) {
                    min = a[j];
                    index = j;
                }
            }
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
            min = Integer.MAX_VALUE;
        }
    }

    // 稳定 插排
    public static void insertSort(int[] a) {
        int len = a.length;
        int temp = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 1; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }else{
                    break;
                }
            }
        }
    }

    // 稳定 冒泡
    public static void bubbleSort(int[] a) {
        int len = a.length, temp;
        boolean flag;
        for (int i = 0; i < len; i++) {
            flag = false;
            for (int j = 0; j < len - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    flag = true;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if(!flag){
                // 本次冒泡没有值交换，结束程序
                return;
            }
        }
    }

    public static void heapSort(int[] a) {
        //
        int n = a.length - 1;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            while (true) {
                if ((i + 1) * 2 - 1 > n) break;
                if ((i + 1) * 2 == n) break;

            }
        }

    }


    public static void main(String[] args) {
        int[] a1 = {1, 5, 8, 3, 4, 0};
        mergeSort(a1, 0, a1.length - 1);
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a2 = {1, 5, 8, 3, 4, 0};
        quickSort(a1, 0, a1.length - 1);
        for (int i : a1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a3 = {1, 5, 8, 3, 4, 0};
        selectionSort(a3);
        for (int i : a3) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a4 = {1, 5, 8, 3, 4, 0};
        insertSort(a4);
        for (int i : a4) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] a5 = {1, 5, 8, 3, 4, 0};
        bubbleSort(a5);
        for (int i : a5) {
            System.out.print(i + " ");
        }


    }


}
