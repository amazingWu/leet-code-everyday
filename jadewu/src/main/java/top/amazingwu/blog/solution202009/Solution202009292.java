package top.amazingwu.blog.solution202009;

/**
 * 【统计数组中的元素】
 * 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive/
 *
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 88.04% 的用户
 * 内存消耗： 37 MB , 在所有 Java 提交中击败了 13.27% 的用户
 */
public class Solution202009292 {
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || (nums[i] > nums.length)) {
                nums[i] = -1;
            }
        }
        int currentIndex = 0;
        int nextIndex;
        int tmp;
        while (currentIndex < nums.length) {
            nextIndex = nums[currentIndex] - 1;
            if (nums[currentIndex] <= 0 || currentIndex == nextIndex) {
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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}) == 3);
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}) == 2);
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}) == 1);
        System.out.println(firstMissingPositive(new int[]{}) == 1);
        System.out.println(firstMissingPositive(new int[]{1}) == 2);
        System.out.println(firstMissingPositive(new int[]{1, 1}) == 2);
        System.out.println(firstMissingPositive(new int[]{2, 2, 2}) == 1);
        System.out.println(firstMissingPositive(new int[]{2, 1}) == 3);
    }
}
