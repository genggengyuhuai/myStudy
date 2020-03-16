package algorithm.jianzhi_offer;

/**
 * 字符流中第一个不重复的字符
 * @author lihaoyu
 * @date 3/16/2020 10:15 PM
 */
public class Main8 {

    int start = 0;
    int end = 0;
    StringBuilder sb = new StringBuilder();
    int[] cs = new int[256];

    public void Insert(char ch)
    {
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while(end < sb.length()){
            cs[sb.charAt(end++)]++;
            while(start < sb.length() && cs[sb.charAt(start)] > 1 ){
                start++;
            }
        }
        if(start == sb.length()) return '#';
        return sb.charAt(start);
    }

    public static void main(String[] args) {
        Main8 main8 = new Main8();
        main8.Insert('g');
        System.out.println(main8.FirstAppearingOnce());
        main8.Insert('o');
        System.out.println(main8.FirstAppearingOnce());
        main8.Insert('o');
        System.out.println(main8.FirstAppearingOnce());
        main8.Insert('g');
        System.out.println(main8.FirstAppearingOnce());
        main8.Insert('l');
        System.out.println(main8.FirstAppearingOnce());
        main8.Insert('e');
        System.out.println(main8.FirstAppearingOnce());
    }
}
