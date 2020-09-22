package top.amazingwu.blog.solution201903;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/submissions/
 * 三数之和
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月12日22:43
 */
public class Solution201903121 {
    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static HashMap<String, Void> keys = new HashMap<>();

    public static List<List<Integer>> threeSum(int[] nums) {
        hashMap.clear();
        keys.clear();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Integer num = -(nums[i] + nums[j]);
                if (hashMap.containsKey(num) && hashMap.get(num) != i && hashMap.get(num) != j) {
                    String key = sort(nums[i], nums[j], num);
                    if (keys.containsKey(key)) {
                        continue;
                    }
                    keys.put(key, null);
                    ArrayList<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[j]);
                    item.add(num);
                    lists.add(item);
                }
            }
        }
        return lists;
    }

    private static String sort(int n1, int n2, int n3) {
        int n;
        if (n1 > n2) {
            n = n1;
            n1 = n2;
            n2 = n;
        }
        if (n2 > n3) {
            n = n2;
            n2 = n3;
            n3 = n;
        }
        if (n1 > n2) {
            n = n1;
            n1 = n2;
            n2 = n;
        }
        return String.format("%s %s %s", n1, n2, n3);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = threeSum(new int[]{-1, 0, 1});
        result.forEach(list -> {
            list.forEach(item -> System.out.print(item + ","));
            System.out.println();
        });
    }
}
