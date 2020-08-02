package algorithm.school_hire_2019.netesay;


import java.util.Scanner;

/**
 *  19 网易校招  	被三整除
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 *
 *  @author lihaoyu
 * @date 2019/8/29 12:24
 */
public class Main2 {

    private static int fun(int start, int end){
        int count = 0;
        int num_start = (start - 1) / 3;
        int num_end = (end - 1) / 3;
        if(num_end == num_start) {
            return start % 3 == 0 ? (end - start) : end - start + 1;
        }
        count = 2 * (num_end - num_start - 1);
        if((start - 1) % 3 != 0){
            count += 3 - (start - 1) % 3;
        }
        if((end - 1) % 3 != 0){
            count += (end - 1) % 3;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(fun(l, r));
        }
    }
}
