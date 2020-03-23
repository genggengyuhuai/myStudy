package algorithm.newcoderOJ;

import java.util.HashMap;
import java.util.Map;

/**
 * 你有一个长度为 n 的队伍，从左到右依次为 1~n，有 m 次插队行为，
 * 用数组 cutIn 进行表示，cutIn 的元素依次代表想要插队的人的编号，
 * 每次插队，这个人都会直接移动到队伍的最前方。你需要返回一个整数，
 * 代表这 m 次插队行为之后，有多少个人已经不在原来队伍的位置了。
 * @author lihaoyu
 * @date 3/21/2020 1:11 PM
 */
public class Main5 {

    /**
     * 计算有多少个人最终不在自己原来的位置上
     * @param n int整型 队伍总长    n < 1e9
     * @param cutIn int整型一维数组 依次会插队到最前方的人的编号
     * @return int整型
     */
    public static int countDislocation (int n, int[] cutIn) {
        // write code here
        Map<Integer,Integer> map = new HashMap<>();
        int index = 1;
        for(int i = cutIn.length - 1; i >= 0; i--){
            if(map.containsKey(cutIn[i])){
                continue;
            }
            map.put(cutIn[i],index++);
        }
        int max = 0;
        for (int i : cutIn) {
            max = Math.max(i,max);
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            Integer orDefault = map.getOrDefault(i,  i + map.size());
            if(orDefault != i && i <= max) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countDislocation(10000, new int[]{5241,339,155,1514,6887,6769,7763,8997,6435,8930}));
    }
}
