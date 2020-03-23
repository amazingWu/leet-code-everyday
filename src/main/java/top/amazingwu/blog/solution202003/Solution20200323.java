package top.amazingwu.blog.solution202003;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 回溯法
 *
 * @author amazingjadewu@gmail.com
 * @created 2020年03月12日 21:01
 */
public class Solution20200323 {

  /**
   * @param candidates 候选数组
   * @param len
   * @param begin      从候选数组的 begin 位置开始搜索
   * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
   * @param path       从根结点到叶子结点的路径
   * @param res
   */
  private static void dfs(int[] candidates, int len, int begin, int residue, Deque<Integer> path, List<List<Integer>> res) {
    if (residue == 0) {
      res.add(new ArrayList<>(path));
      return;
    }
    for (int i = begin; i < len; i++) {
      // 大剪枝
      if (residue - candidates[i] < 0) {
        break;
      }

      // 小剪枝
      if (i > begin && candidates[i] == candidates[i - 1]) {
        continue;
      }

      path.addLast(candidates[i]);

      // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
      dfs(candidates, len, i + 1, residue - candidates[i], path, res);

      path.removeLast();
    }
  }

  public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
    int len = candidates.length;
    List<List<Integer>> res = new ArrayList<>();
    if (len == 0) {
      return res;
    }

    // 先将数组排序，这一步很关键
    Arrays.sort(candidates);

    Deque<Integer> path = new ArrayDeque<>(len);
    dfs(candidates, len, 0, target, path, res);
    return res;
  }

  public static void main(String[] args) {
    int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
    System.out.println(combinationSum2(candidates, 8));
  }
}
