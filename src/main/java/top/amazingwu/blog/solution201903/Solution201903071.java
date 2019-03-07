package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月07日21:22
 */
public class Solution201903071 {

    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder stringBuilder = new StringBuilder();
        for (int q = 1; q <= numRows; q++) {
            int n = 0;
            int next = q;
            int pre = 0;
            while (next <= s.length()) {
                if (pre != next) {
                    stringBuilder.append(s.charAt(next - 1));
                }
                pre = next;
                if (n % 2 == 0) {
                    next = (numRows - q) * 2 + next;
                } else {
                    next = (q - 1) * 2 + next;
                }
                n++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("AB", 1));
        System.out.println(convert("123456789", 5));
    }
}
