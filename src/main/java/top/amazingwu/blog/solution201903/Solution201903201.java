package top.amazingwu.blog.solution201903;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 括号生成
 *
 * @author amazingjadewu@163.com
 */
public class Solution201903201 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate("", 0, 0, list, n);
        return list;
    }

    public static void generate(String before, int c_num, int d_num, List<String> list, int n) {
        if (2 * n - c_num - d_num == 1) {
            list.add(before + ")");
        } else {
            if (c_num == n) {
                generate(before + ")", c_num, d_num + 1, list, n);
            } else {
                if (c_num == d_num) {
                    generate(before + "(", c_num + 1, d_num, list, n);
                } else {
                    generate(before + "(", c_num + 1, d_num, list, n);
                    generate(before + ")", c_num, d_num + 1, list, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        list.forEach(s -> System.out.println(s));

    }
}
