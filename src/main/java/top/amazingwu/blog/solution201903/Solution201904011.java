package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 * 搜索旋转排序数组
 *
 * @author amazingjadewu@163.com
 */
public class Solution201904011 {
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums[0] > target && nums[nums.length - 1] < target) return -1;
        int i = 0, j = nums.length - 1;
        int middle = 0;
        while (i < j) {
            middle = (i + j) / 2;
            if (nums[middle] > nums[j]) {
                if (i == middle) {
                    break;
                }
                i = middle;
            } else {
                j = middle;
            }
        }
        if (middle == 0 && nums.length > 1 && nums[0] <= nums[1]) middle = nums.length - 1;
        if (target > nums[middle]) return -1;
        if (middle < nums.length - 1 && target < nums[middle + 1]) return -1;
        Integer index = null;
        if (nums[0] <= target) {
            index = find(nums, target, 0, middle);
        } else if (middle < nums.length - 1) {
            index = find(nums, target, middle + 1, nums.length - 1);
        }
        return index == null ? -1 : index;
    }

    public static Integer find(int[] nums, int target, int start, int end) {
        int i = start, j = end;
        int middle;
        while (i <= j) {
            middle = (i + j) / 2;
            if (nums[middle] < target) {
                i = middle + 1;
            } else if (nums[middle] > target) {
                j = middle - 1;
            } else {
                return middle;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 1));
    }
}
