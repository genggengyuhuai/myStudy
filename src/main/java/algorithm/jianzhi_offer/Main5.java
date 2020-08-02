package algorithm.jianzhi_offer;

/**
 * 反转这些单词顺序
 * @author lihaoyu
 * @date 3/15/2020 1:07 PM
 */
public class Main5 {

    public static String ReverseSentence(String str) {
        if(str == null || str.length() == 0) return str;
        if(str.trim().equals("")) return str;
        StringBuilder sb = new StringBuilder();
        String[] s = str.split(" ");
        for (int i = s.length - 1; i >= 0; i--) {
            if(i != 0) sb.append(s[i]).append(" ");
            else sb.append(s[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am student."));
    }
}
