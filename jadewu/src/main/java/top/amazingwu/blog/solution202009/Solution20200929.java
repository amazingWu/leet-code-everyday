package top.amazingwu.blog.solution202009;

import java.util.LinkedList;
import java.util.List;

/**
 * 【统计数组中的元素】
 * 数组的度
 * https://leetcode-cn.com/problems/degree-of-an-array/
 * <p>
 * 执行用时： 22 ms , 在所有 Java 提交中击败了 83.71% 的用户
 * 内存消耗： 42.3 MB , 在所有 Java 提交中击败了 76.14% 的用户
 */
public class Solution20200929 {
    public static int findShortestSubArray(int[] nums) {
        int[] counts = new int[50000];
        for (int num : nums) {
            counts[num]++;
        }
        int degree = 0;
        List<Integer> maxValues = new LinkedList<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > degree) {
                degree = counts[i];
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == degree) {
                maxValues.add(i);
            }
        }
        if (degree == 1) {
            return 1;
        }
        int result = Integer.MAX_VALUE;
        int maxLength;
        int alreadyRead;
        for (int maxValue : maxValues) {
            maxLength = 0;
            alreadyRead = 0;
            for (int num : nums) {
                if (num == maxValue) {
                    alreadyRead++;
                }
                if (alreadyRead > 0) {
                    maxLength++;
                }
                if (alreadyRead == degree) {
                    result = result < maxLength ? result : maxLength;
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(findShortestSubArray(new int[]{0}));
    }
}
