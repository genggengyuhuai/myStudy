package algorithm.newcoderOJ;

/**
 * @author lihaoyu
 * @date 3/8/2020 6:15 PM
 */
public class Main4 {

    public int attackMonster (int monsterLength, int[] monsterPoint) {
        // write code here
        int[] nums = new int[monsterPoint.length+1];
        nums[0] = monsterPoint[0];
        for (int i = 1; i < monsterPoint.length; i++) {
            nums[i] = monsterPoint[i] - monsterPoint[i-1];
        }
        nums[monsterPoint.length] = monsterLength - monsterPoint[monsterPoint.length-1];
        int[][] dp = new int[nums.length][nums.length];



        return 0;
    }


    public static void main(String[] args) {

    }

}
