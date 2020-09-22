package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/submissions/
 * 采用的是中心法
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月05日22:27
 */
public class Solution201903051 {
    public static String longestPalindrome(String s) {
        String maxString1 = oddKernel(s);
        String maxString2 = evenKernel(s);
        return maxString1.length() > maxString2.length() ? maxString1 : maxString2;
    }

    private static String oddKernel(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j) && j * 2 + 1 > maxString.length()) {
                    maxString = s.substring(i - j, i + j + 1);
                } else if (s.charAt(i - j) != s.charAt(i + j)) {
                    break;
                }
            }
        }
        return maxString;
    }

    private static String evenKernel(String s) {
        String maxString = "";
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                for (int j = 0; i - j >= 0 && i + 1 + j < s.length(); j++) {
                    if (s.charAt(i - j) == s.charAt(i + 1 + j) && (j + 1) * 2 > maxString.length()) {
                        maxString = s.substring(i - j, i + 1 + j + 1);
                    } else if (s.charAt(i - j) != s.charAt(i + 1 + j)) {
                        break;
                    }
                }
            } else {
                continue;
            }
        }
        return maxString;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("1221"));
    }

}
