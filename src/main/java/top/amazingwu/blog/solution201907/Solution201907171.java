package top.amazingwu.blog.solution201907;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/submissions/
 * 组合总和 -> 回溯法
 *
 * @author amazingjadewu@gmail.com
 * @created 2019年07月17日 22:28
 */
public class Solution201907171 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        LinkedList<Integer> indexStack = new LinkedList<>();
        indexStack.push(-1);
        LinkedList<Integer> value = new LinkedList<>();
        int sum = 0;
        while (!indexStack.isEmpty()) {
            Integer index = indexStack.pop();
            if (index != -1) {
                sum -= candidates[index];
                value.removeLast();
            }
            if (index < candidates.length - 1) {
                while (sum <= target) {
                    value.addLast(candidates[index + 1]);
                    indexStack.push(index + 1);
                    if (candidates[index + 1] + sum == target) {
                        result.add(value);
                        value = new LinkedList<>();
                        value.addAll(result.peekLast());
                        sum += candidates[index + 1];
                        break;
                    } else {
                        sum += candidates[index + 1];
                    }
                }
                sum -= candidates[index + 1];
                indexStack.pop();
                value.removeLast();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        System.out.println(combinationSum(candidates, 7));
    }
}
