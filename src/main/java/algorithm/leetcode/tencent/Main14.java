package algorithm.leetcode.tencent;

/**
 * 14. 最长公共前缀
 * @author lihaoyu
 * @date 2019/12/18 14:52
 */
public class Main14 {

    public static String longestCommonPrefix(String[] strs) {
        if(strs== null || strs.length == 0 || strs[0].length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char temp;
        while(true){
            if(index >= strs[0].length()){
                break;
            }
            temp = strs[0].charAt(index);
            for (String str : strs) {
                if (index >= str.length() || str.charAt(index) != temp) {
                    return sb.toString();
                }
            }
            sb.append(temp);
            index++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","abdg","abs"}));
    }
}
