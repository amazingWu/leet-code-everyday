package top.amazingwu.blog.solution201903;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/submissions/
 * 正则实现，因为正则匹配效率的问题，效率上降低了很多
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月08日21:01
 */
public class Solution201903081 {
    static Pattern pattern = Pattern.compile("[\\s]*([-+])?([0-9]+).*");

    public static int myAtoi(String str) {
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            try {
                Long result = Long.valueOf(matcher.group(1) == null ? matcher.group(2) : matcher.group(1) + matcher.group(2));
                if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                return result.intValue();
            } catch (Exception e) {
                if ("-".equals(matcher.group(1))) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-9223372036854775809"));
    }
}
