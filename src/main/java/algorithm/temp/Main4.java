package algorithm.temp;

/**
 * @author lihaoyu
 * @date 2/2/2020 5:34 PM
 */
public class Main4 {

    // 最长公共子串    求长度
    private static int lenFun(String s1, String s2){
        int[] dp = new int[s2.length()+1];
        int res = 0;
        for(int i = 1; i <= s1.length(); i++){
            int pre = 0;
            for(int j = 1; j <= s2.length(); j++){
                int temp = dp[j];
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[j] = pre+1;
                }else{
                    dp[j] = 0;
                }
                pre = temp;
                res = Math.max(res, dp[j]);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(lenFun("abcdefg","abxdefn"));
    }
}
