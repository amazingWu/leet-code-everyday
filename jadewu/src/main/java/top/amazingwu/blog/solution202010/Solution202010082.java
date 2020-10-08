package top.amazingwu.blog.solution202010;

/**
 * 【数组的改变、移动】
 * 非递减数列
 * https://leetcode-cn.com/problems/non-decreasing-array/
 *
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 40.1 MB , 在所有 Java 提交中击败了 43.49% 的用户
 */
public class Solution202010082 {
    public static boolean checkPossibility(int[] nums) {
        int errorNum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i > 0) {
                    if (nums[i + 1] >= nums[i - 1]) {
                        nums[i] = nums[i + 1];
                    } else {
                        nums[i + 1] = nums[i];
                    }
                } else {
                    nums[i] = nums[i + 1];
                }
                errorNum++;
                if (errorNum > 1) {
                    return false;
                }
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{4, 2, 3}) == true);
        System.out.println(checkPossibility(new int[]{2, 4, 3}) == true);
        System.out.println(checkPossibility(new int[]{2, 6, 5, 4}) == false);
        System.out.println(checkPossibility(new int[]{1, 6, 6, 4, 4, 5}) == false);
        System.out.println(checkPossibility(new int[]{2}) == true);
        System.out.println(checkPossibility(new int[]{5, 7, 1, 8}) == true);
    }
}
