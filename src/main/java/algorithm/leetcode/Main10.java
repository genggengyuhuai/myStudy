package algorithm.leetcode;

/**10. 正则表达式匹配
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * @author lihaoyu
 * @date 2020/1/1 15:01
 */
public class Main10 {



    public static boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int temp = 1; temp < p.length() && p.charAt(temp)=='*'; temp+=2){
            dp[0][temp+1] = true;
        }
//        if(p.length() > 1 && p.charAt(1)=='*') dp[0][2] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                    continue;
                }
                if(p.charAt(j-1) !='.' && p.charAt(j-1) != '*' && s.charAt(i-1) != p.charAt(j-1)){
                    continue;
                }
                // 下面是 * 的情况
                //  baaa
                //  baa*
                if(s.charAt(i-1) != p.charAt(j-2) && p.charAt(j-2) != '.'){
                    dp[i][j] = dp[i][j-2];
                    continue;
                }
                dp[i][j] =  dp[i][j-2] || dp[i-1][j];
            }
        }
//        for (int i = 0; i <= s.length(); i++) {
//            for (int j = 0; j <= p.length(); j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
  System.out.println(isMatch("aab","c*a*b"));
    }
}
