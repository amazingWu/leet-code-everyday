package top.amazingwu.blog.solution202009;

/**
 * 【数组的遍历】
 * 提莫攻击
 * https://leetcode-cn.com/problems/teemo-attacking/
 * <p>
 * 执行用时：2 ms, 在所有 Java 提交中击败了99.35%的用户
 * 内存消耗：41.5 MB, 在所有 Java 提交中击败了55.60%的用户
 */
public class Solution202009221 {
    public static int findPoisonedDuration(int[] timeSeries, int duration) {
        int pre = -1;
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (pre != -1) {
                if (timeSeries[i] - pre >= duration) {
                    total += duration;
                } else {
                    total += timeSeries[i] - pre;
                }
            }
            pre = timeSeries[i];
        }
        if (timeSeries.length > 0) {
            total += duration;
        }
        return total;
    }


    public static void main(String[] args) {
        System.out.println(findPoisonedDuration(new int[]{1, 4}, 2) == 4);
        System.out.println(findPoisonedDuration(new int[]{1, 2}, 2) == 3);
        System.out.println(findPoisonedDuration(new int[]{}, 10000) == 0);
    }
}
