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
        // 有可优化的空间，如果左边小数组的最大值小于右边大数组的最小值，则不用下面的流程。
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

    // 交换数组中下标 i 和 j 的元素
    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 对第i个元素   堆化（自上而下）  len属性是必要的
    private static void heapify(int[] a, int i, int len){
        // maxIndex 比较自身和左右子节点的大小，最大的Index
        int maxIndex;
        while(true){
            maxIndex = i;
            if(2*i+1 < len && a[maxIndex] < a[2*i+1]) maxIndex = 2 * i + 1;
            if(2*i+2 < len && a[maxIndex] < a[2*i+2]) maxIndex = 2 * i + 2;
            if(maxIndex == i) break;
            swap(a,i,maxIndex);
            i = maxIndex;
        }
    }

    private static void buildHeap(int[] a){
        // 从第一个非叶子节点开始，向上循环
        for(int i = (a.length - 1) / 2; i >= 0; i--){
            heapify(a,i,a.length);
        }
    }

    // 堆排 不稳定   https://time.geekbang.org/column/article/69913
    // 访问数据的方式不是顺序的，而是像树一样跳跃式的，没有局部顺序访问，对CPU不友好
    public static void heapSort(int[] a) {
        // 建堆
        buildHeap(a);
        int n = a.length - 1;
        while(n > 0){
            swap(a,0,n);
            n--;
            heapify(a,0,n);
        }
    }

    // 非递归的快排
    private static int partition(int[] a, int start, int end) {
        int key = a[start];
        while (start <= end) {
            while (start <= end && a[end] >= key) end--;
            a[end] = a[start];
            while (start <= end && a[start] <= key) start++;
            a[start] = a[end];
        }
        a[start] = key;
        return start;
    }

    private static void inRecursiveQuickSort(int[] a, int start, int end) {
        if(start >= end) return;
        int[] stack = new int[a.length];
        int top = 0;
        // 初始化入栈
        stack[top++] = start;
        stack[top++] = end;
        // 栈不空
        while(top != 0){
            int right = stack[--top];
            int left = stack[--top];
            int partition = partition(a, left, right);
            // 左区间入栈
            stack[top++] = left;
            stack[top++] = partition;
            // 右区间入栈
            stack[top++] = partition+1;
            stack[top++] = right;
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
        heapSort(a3);
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
