package top.amazingwu.blog.solution202009;

/**
 * 【数组的遍历】
 * 第三大的数
 * https://leetcode-cn.com/circle/article/48kq9d/
 * <p>
 * 执行用时：1 ms, 在所有 Java 提交中击败了96.31%的用户
 * 内存消耗：39 MB, 在所有 Java 提交中击败了13.48%的用户
 */
public class Solution20200923 {

    public static int thirdMax(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if (num > first) {
                third = second;
                second = first;
                first = num;
            } else if (num > second && num < first) {
                third = second;
                second = num;
            } else if (num < second && num > third) {
                third = num;
            }
        }
        return third != Long.MIN_VALUE ? new Long(third).intValue() : new Long(first).intValue();
    }

    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}) == 1);
        System.out.println(thirdMax(new int[]{1, 2}) == 2);
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}) == 1);
    }
}
