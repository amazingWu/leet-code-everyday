package top.amazingwu.blog.solution202010;

/**
 * 【数组的改变、移动】
 * 最小移动次数使数组元素相等
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * 执行用时： 1 ms , 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗： 39.5 MB , 在所有 Java 提交中击败了 32.18% 的用户
 *
 */
public class Solution202010081 {
    public static int minMoves(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        for (int i : nums) {
            if (i < minValue) {
                minValue = i;
            }
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += nums[i] - minValue;
        }
        return result;
    }

    public static void main(String[] args) {
        // [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
        // [1,3,3]  =>  [2,4,3]  =>  [3,4,4]  =>  [4,5,4]  =>  [5,5,5]
        System.out.println(minMoves(new int[]{1, 2, 3}) == 3);
        System.out.println(minMoves(new int[]{1, 3, 3}) == 4);
        System.out.println(minMoves(new int[]{3, 4, 4}) == 2);
        System.out.println(minMoves(new int[]{4, 5, 4}) == 1);
        System.out.println(minMoves(new int[]{5, 5, 5}) == 0);
        System.out.println(minMoves(new int[]{2, 3, 3}) == 2);
        System.out.println(minMoves(new int[]{2147483647}) == 0);
        System.out.println(minMoves(new int[]{2147483647, 2147483646}) == 1);
        // [5,6,8,8,5] => [6,7,9,8,6] => [7,8,9,9,7] => [8,9,9,10,8] => [9,10,10,10,9] => [10,10,11,10,10] => [11,11,11,11,11]
        System.out.println(minMoves(new int[]{5, 6, 8, 8, 5}) == 7);

    }
}
