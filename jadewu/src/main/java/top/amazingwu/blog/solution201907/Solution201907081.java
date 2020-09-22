package top.amazingwu.blog.solution201907;

/**
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
 * <p>
 * 查找最大值和最小值均采用二分法
 *
 * @author
 * @created 2019年07月08日21:55
 */
public class Solution201907081 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target)
            return new int[]{-1, -1};
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    public static int searchLeft(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[(i + j) / 2] > target) {
                j = (i + j) / 2 - 1;
            } else if (nums[(i + j) / 2] < target) {
                i = (i + j) / 2 + 1;
            } else {
                j = (i + j) / 2;
            }
        }
        if (nums[i] == target) return i;
        return -1;
    }

    public static int searchRight(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[(i + 1 + j) / 2] > target) {
                j = (i + 1 + j) / 2 - 1;
            } else if (nums[(i + 1 + j) / 2] < target) {
                i = (i + 1 + j) / 2 + 1;
            } else {
                i = (i + 1 + j) / 2;
            }
        }
        if (nums[i] == target) return i;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = searchRange(new int[]{2, 4}, 3);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
