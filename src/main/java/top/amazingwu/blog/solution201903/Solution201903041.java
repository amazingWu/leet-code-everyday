package top.amazingwu.blog.solution201903;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * @author amazingjadewu@163.com
 * @created 2019年03月04日22:37
 */
public class Solution201903041 {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
        int start = 0, end = 0;
        int length = 0;
        while (end < s.length()) {
            if (!hashMap.containsKey(s.charAt(end)) || hashMap.get(s.charAt(end)) < start) {
                length = Math.max(length, end - start + 1);
            } else {
                start = hashMap.get(s.charAt(end)) + 1;
                length = Math.max(end - start, length);
            }
            hashMap.put(s.charAt(end), end);
            end++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
