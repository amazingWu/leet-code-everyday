package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/next-permutation/
 * 下一个排列(即字典序算法)
 *
 * @author amazingjadewu@163.com
 */
public class Solution201903271 {

    public static void nextPermutation(int[] nums) {
        if (nums.length == 1) return;
        boolean max = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = false;
                break;
            }
        }
        int temp;
        if (!max) {
            int before = 0, end = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] < nums[i + 1]) {
                    before = i;
                    break;
                }
            }
            for (int i = nums.length - 1; i > before; i--) {
                if (nums[i] > nums[before]) {
                    end = i;
                    break;
                }
            }
            temp = nums[before];
            nums[before] = nums[end];
            nums[end] = temp;
            for (int i = before + 1, j = nums.length - 1; j >= i; i++, j--) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        } else {
            for (int i = 0, j = nums.length - 1; j >= i; i++, j--) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] list = new int[]{1, 3, 2};
        nextPermutation(list);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
