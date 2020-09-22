package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 * 盛最多水的容器
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月09日22:21
 */
public class Solution201903091 {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int begin = 0;
        int end = height.length - 1;
        while (begin != end) {
            int area = Math.min(height[begin], height[end]) * (end - begin);
            maxArea = Math.max(maxArea, area);
            if (height[begin] < height[end]) begin++;
            else end--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

}
