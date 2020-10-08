package top.amazingwu.blog.solution202010;

import java.util.Arrays;

/**
 * 【统计数组中的元素】
 * H 指数
 * https://leetcode-cn.com/problems/h-index/
 *
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 86.72% 的用户
 * 内存消耗： 36.7 MB , 在所有 Java 提交中击败了 73.55% 的用户
 */
public class Solution20201008 {
    public static int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - i >= citations[i]) {
                return Math.max(citations[i], citations.length - i - 1);
            } else if (citations.length - i < citations[i]) {
                continue;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}) == 3);
        System.out.println(hIndex(new int[]{1, 3, 0, 6, 6, 6, 6, 6, 6, 7, 8, 1, 5}) == 6);
        System.out.println(hIndex(new int[]{100}) == 1);
        System.out.println(hIndex(new int[]{}) == 0);
        System.out.println(hIndex(new int[]{0}) == 0);
        System.out.println(hIndex(new int[]{2}) == 1);
        System.out.println(hIndex(new int[]{3}) == 1);
        System.out.println(hIndex(new int[]{3, 2}) == 2);
        System.out.println(hIndex(new int[]{3, 2, 1}) == 2);
        System.out.println(hIndex(new int[]{3, 2, 2}) == 2);
        System.out.println(hIndex(new int[]{3, 3, 3}) == 3);
        System.out.println(hIndex(new int[]{11, 15}) == 2);
        System.out.println(hIndex(new int[]{4, 4, 0, 0}) == 2);
    }
}
