package top.amazingwu.blog.solution201903;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/submissions/
 * 电话号码的字母组合
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月15日22:09
 */
public class Solution201903151 {
    private static Character[][] map = new Character[][]{
            {'a', 'b', 'c', ' '},
            {'d', 'e', 'f', ' '},
            {'g', 'h', 'i', ' '},
            {'j', 'k', 'l', ' '},
            {'m', 'n', 'o', ' '},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v', ' '},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() > 0) {
            letterCombinations("", digits, 0, list);
        }
        return list;
    }

    public static void letterCombinations(String c, String digits, int currentIndex, List<String> list) {
        int number = digits.charAt(currentIndex) - '2';
        if (currentIndex < digits.length() - 1) {
            for (int i = 0; i < map[number].length; i++) {
                if (map[number][i] != ' ') {
                    letterCombinations(c + map[number][i], digits, currentIndex + 1, list);
                }
            }
        } else {
            for (int i = 0; i < map[number].length; i++) {
                if (map[number][i] != ' ') {
                    list.add(c + map[number][i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
