package top.amazingwu.blog.solution201903;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/submissions/
 * 最接近的三数之和
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月14日22:28
 */
public class Solution201903141 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int targetClosest = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int head = i + 1;
            int tail = nums.length - 1;
            while (head != tail && targetClosest != target) {
                int sum = nums[i] + nums[head] + nums[tail];
                if (Math.abs(sum - target) < Math.abs(target - targetClosest)) {
                    targetClosest = sum;
                }
                if (targetClosest == target) {
                    return targetClosest;
                } else if (sum < target) {
                    head++;
                } else {
                    tail--;
                }
            }
        }
        return targetClosest;
    }

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{0, 1, 2}, 0));
    }
}
