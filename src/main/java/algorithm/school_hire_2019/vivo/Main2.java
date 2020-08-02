package algorithm.school_hire_2019.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  有n个盒子排成了一行，每个盒子上面有一个数字a[i]，表示在该盒子上的人最多能向右移动a[i]个盒子
 *  现在小v从左边第一个盒子上开始体验游戏，请问最少需要移动几次能到最后一个盒子上？
 * @author lihaoyu
 * @date 3/5/2020 7:09 PM
 */
public class Main2 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split(" "));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] input) {
        // TODO Write your code here
        int index = 0, count = 0;
        while(index < input.length - 1){
            if(index + input[index] >= input.length - 1){
                return count+1;
            }
            int max = input[index];
            for(int i = index; i <= index + input[index];i++){
                if(max < input[i]+i-index){
                    max = input[i]+i-index;
                    index = i;
                }
            }
            count++;
        }
        return count;
    }


}
