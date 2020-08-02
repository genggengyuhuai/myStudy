package algorithm.jianzhi_offer;

import java.util.Arrays;

/**
 * 扑克牌伍连顺问题
 * @author lihaoyu
 * @date 3/15/2020 1:11 PM
 */
public class Main6 {

    public boolean isContinuous(int [] numbers) {
        if(numbers == null || numbers.length == 0) return false;
        Arrays.sort(numbers);
        int zeroCount = 0, diff = 0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] == 0){
                zeroCount++;
                continue;
            }
            if(i == 0 || numbers[i-1] == 0) continue;
            if(numbers[i] == numbers[i-1]) return false;
            diff += numbers[i] - numbers[i-1] - 1;
        }
        return zeroCount >= diff;
    }


    public static void main(String[] args) {

    }
}
