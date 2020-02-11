package algorithm.temp;


/**
 * @author lihaoyu
 * @date 2019/11/11 19:22
 */
public class SingleTonDemo {

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // 堆化， 向下堆化, 要建立大顶堆
    private static void heapify(int[] a, int i, int len){
        int maxIndex;
        while(true){
            maxIndex = i;
            if(2*i+1 < len && a[maxIndex] <= a[2*i+1]) maxIndex = 2 * i + 1;
            if(2*i+2 < len && a[maxIndex] <= a[2*i+2]) maxIndex = 2 * i + 2;
            if(maxIndex == i) return;
            swap(a, i, maxIndex);
            i = maxIndex;
        }
    }

    private static void buildHeap(int[] a){
        // 第一个非叶子节点
        int firstIndex = a.length / 2 - 1;
        for(int i = firstIndex; i >= 0; i--){
            heapify(a,i,a.length);
        }
    }

    private static void heapSort(int[] a){
        buildHeap(a);
        for (int i = 0; i < a.length-1; i++) {
            swap(a,i,a.length-1-i);
            heapify(a,i,a.length-i-2);
        }

    }

    public static void main(String[] args) {

    }


}
