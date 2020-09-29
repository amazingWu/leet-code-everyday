package top.amazingwu.blog.solution202009;

import java.util.LinkedList;
import java.util.List;

/**
 * 【统计数组中的元素】
 * 找到所有数组中消失的数字
 * https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 *
 * 执行用时： 8 ms , 在所有 Java 提交中击败了 41.54% 的用户
 * 内存消耗： 46.9 MB , 在所有 Java 提交中击败了 91.47% 的用户
 */
public class Solution202009291 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int currentIndex = 0;
        int nextIndex;
        int tmp;
        while (currentIndex < nums.length) {
            nextIndex = nums[currentIndex] - 1;
            if (nums[currentIndex] == 0 || currentIndex == nextIndex) {
                currentIndex++;
            } else if ((nextIndex + 1) == nums[nextIndex]) {
                nums[currentIndex] = 0;
                currentIndex++;
            } else {
                tmp = nums[nextIndex];
                nums[nextIndex] = nextIndex + 1;
                nums[currentIndex] = tmp;
                // 交换后，如果正好当前位置满足，则从下一个位置开始
                if (nums[currentIndex] == currentIndex + 1) {
                    currentIndex++;
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}).forEach(System.out::println);
        findDisappearedNumbers(new int[]{3, 3, 3}).forEach(System.out::println);
    }
}
