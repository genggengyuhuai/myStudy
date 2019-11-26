package algorithm.temp;

public class Solution {
    private static int[] cs = new int[256];
    private static int index;
    static{
        for (int i = 0; i < cs.length; i++) {
            cs[i] = -1;
        }
    }

    public void Insert(char ch) {
        if(cs[ch] >= 0){
            // 已经出现过
            cs[ch] = -2;
        }else if(cs[ch] == -1){
            // 没出现过
            cs[ch] = index;
        }
        index++;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        int min = Integer.MAX_VALUE;
        char res = '#';
        for (int i = 0; i < cs.length; i++) {
            if(min > cs[i] && cs[i] >= 0){
                res = (char)i;
                min = cs[i];
            }
        }
        if(min != Integer.MAX_VALUE) {
            return res;
        }
        return '#';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.Insert('h');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('e');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('l');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('l');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('o');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('w');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('o');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('r');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('l');
        System.out.println(solution.FirstAppearingOnce());
        solution.Insert('d');
        System.out.println(solution.FirstAppearingOnce());
    }
}