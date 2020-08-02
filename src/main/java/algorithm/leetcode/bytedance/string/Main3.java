package algorithm.leetcode.bytedance.string;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列
 *
 * @author lihaoyu
 * @date 2020/6/28 9:17 下午
 */
public class Main3 {

    private static boolean same(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != nums2[i]) return false;
        }
        return true;
    }

    private static boolean fun(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0 || s1.length() > s2.length()) return false;
        // 滑动窗口
        int[] nums1 = new int[26], nums2 = new int[26];
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            nums1[s1.charAt(i) - 'a']++;
            // 初始化第二个窗口
            nums2[s2.charAt(i) - 'a']++;
        }
        if (same(nums1, nums2)) return true;
        for (int i = 0; i < s2.length() - len; i++) {
            nums2[s2.charAt(i) - 'a']--;
            nums2[s2.charAt(i + len) - 'a']++;
            if (same(nums1, nums2)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fun("ab", "eidbaooo"));
    }
}
