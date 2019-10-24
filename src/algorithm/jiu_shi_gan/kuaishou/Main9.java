package algorithm.jiu_shi_gan.kuaishou;


import java.util.Scanner;

/**
 *  latex爱好者
 * 在DIY这个阅读软件的过程中，月神碰到一个问题，已知iPhone屏幕的高为H，宽为W，若字体大小为S(假设为方形），则一行可放W / S(取整数部分）个文字，一屏最多可放H / S （取整数部分）行文字。
 * 已知一篇paper有N个段落，每个段落的文字数目由a1, a2, a3,...., an表示，月神希望排版的页数不多于P页（一屏显示一页），那么月神最多可使用多大的字体呢？
 * @author lihaoyu
 * @date 2019/10/22 18:25
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int P = scanner.nextInt();
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        int[] a = new int[N];
        int S = 1;
        for(int i = 0; i < N; i++){
            a[i] = scanner.nextInt();
        }
        int right = W > H ? H : W;
        int left = 0;
        int perLine = 0;
        int perPage = 0;
        while(left < right){
            int lineCount = 0;
            int pageCount = 0;
            int mid = (right + left) / 2 + 1;
            // 每行字数
            perLine = W / mid;
            // 每页行数
            perPage = H / mid;
            // 计算行数
            for(int i = 0; i < N; i++){
                lineCount += ( a[i] % perLine == 0) ? a[i] / perLine : (a[i] / perLine + 1);
            }
            // 计算页数
            pageCount = (lineCount % perPage == 0) ? (lineCount/perPage) :(lineCount/perPage + 1);
            // 页数小与给定的页，说明字体可以大些
            if(pageCount > P){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        System.out.println(left);

    }
}
