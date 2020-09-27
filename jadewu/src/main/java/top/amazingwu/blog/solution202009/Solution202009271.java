package top.amazingwu.blog.solution202009;

/**
 * 【统计数组中的元素】
 * 错误的集合
 * https://leetcode-cn.com/problems/set-mismatch/
 *
 * 执行用时：3 ms, 在所有 Java 提交中击败了73.35%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了60.67%的用户
 */
public class Solution202009271 {
    public static int[] findErrorNums(int[] nums) {
        int duplicateIndex = -1;
        int currentIndex = 0;
        int nextIndex;
        int tmp;
        while (currentIndex < nums.length) {
            nextIndex = nums[currentIndex] - 1;
            if (nums[currentIndex] == 0 || currentIndex == nextIndex) {
                currentIndex++;
            } else if ((nextIndex + 1) == nums[nextIndex]) {
                nums[currentIndex] = 0;
                duplicateIndex = nextIndex;
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
            if (nums[i] == 0) {
                return new int[]{nums[duplicateIndex], i + 1};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findErrorNums(new int[]{1, 2, 2, 4})[0] + " " + findErrorNums(new int[]{1, 2, 2, 4})[1]);
        System.out.println(findErrorNums(new int[]{1, 2, 3, 5, 5})[0] + " " + findErrorNums(new int[]{1, 2, 3, 5, 5})[1]);
    }
}
