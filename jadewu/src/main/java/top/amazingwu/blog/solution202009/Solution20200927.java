package top.amazingwu.blog.solution202009;

/**
 * 【数组的遍历】
 * 三个数的最大乘积
 * https://leetcode-cn.com/problems/maximum-product-of-three-numbers/
 *
 * 执行用时： 3 ms , 在所有 Java 提交中击败了 83.06% 的用户
 * 内存消耗： 40.8 MB , 在所有 Java 提交中击败了 36.30% 的用户
 */
public class Solution20200927 {

    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int small1 = Integer.MAX_VALUE;
        int small2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] > max2 && nums[i] <= max1) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] > max3) {
                max3 = nums[i];
            }

            if (nums[i] < small1) {
                small2 = small1;
                small1 = nums[i];
            } else if (nums[i] >= small1 && nums[i] < small2) {
                small2 = nums[i];
            }
        }
        int result1 = max1 * max2 * max3;
        int result2 = max1 * small1 * small2;
        return result1 > result2 ? result1 : result2;
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{1, 2, 3}) == 6);
        System.out.println(maximumProduct(new int[]{1, 2, 3, 4}) == 24);
        System.out.println(maximumProduct(new int[]{-5, -4, 1, 2, 3, 4}) == 80);
        System.out.println(maximumProduct(new int[]{-5, 0, 1, 2, 3, 4}) == 24);
    }

}
