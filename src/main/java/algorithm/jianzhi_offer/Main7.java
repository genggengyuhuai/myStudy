package algorithm.jianzhi_offer;

/**
 *  使用位运算做加法
 * @author lihaoyu
 * @date 3/15/2020 1:19 PM
 */
public class Main7 {

    public static int Add(int num1,int num2) {
        int temp;
        // 当没有进位了
        while(num1 != 0){
            // 先单独计算不带进位的
            temp = num1 ^ num2;
            // 再单独计算带进位的
            num1 = (num1 & num2) << 1;
            // 此时 num1 和 num2 是新的两个数
            num2 = temp;
        }
        return num2;
    }

}
