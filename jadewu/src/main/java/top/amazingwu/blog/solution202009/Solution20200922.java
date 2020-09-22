package top.amazingwu.blog.solution202009;

/**
 * 【数组的遍历】
 * 最大连续1的个数
 * https://leetcode-cn.com/problems/max-consecutive-ones/
 *
 * 执行用时：2 ms, 在所有 Java 提交中击败了95.01%的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了94.34%的用户
 */
public class Solution20200922 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i: nums){
            if (i == 1){
                current ++;
            }else {
                max = max > current? max:current;
                current = 0;
            }
        }
        max = max > current? max:current;
        return max;
    }

    public static void main(String[] args) {
        int[] values = new int[]{1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(values) == 3);

        int[] values1 = new int[]{1,1,0,1,1,1,1,10,1,1,1};
        System.out.println(findMaxConsecutiveOnes(values1) == 4);
    }
}
