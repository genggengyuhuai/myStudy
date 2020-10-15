package algorithm.temp;

/**
 * @author lihaoyu
 * @date 2020/10/14 4:22 下午
 */
public class Temp3 {

    private static void heapSort(int[] a) {
        // jiandui
        buildHeap(a);
        // tiaozhengdui
        for (int i = 0; i < a.length; i++) {
            swap(a,0,a.length-i-1);
            heapfy(a,0,a.length-i-2);
        }
    }

    private static void buildHeap(int[] a) {
        for(int i = a.length / 2 - 1; i >=0; i--){
            heapfy(a,i,a.length);
        }
    }

    // duihua
    private static void heapfy(int[] a, int i, int len) {
        int maxIndex = i;
        while (true) {
            if (2 * i + 1 < len && a[2 * i + 1] > a[maxIndex]) maxIndex = 2 * i + 1;
            if (2 * i + 2 < len && a[2 * i + 2] > a[maxIndex]) maxIndex = 2 * i + 2;
            if (maxIndex == i) return;
            swap(a, i, maxIndex);
            i = maxIndex;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = new int[]{5,1,8,2,7,3,1};
        heapSort(a);
        for (int i : a) {
            System.out.print(i+" ");
        }
    }
}
