package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/submissions/
 * 两数相除
 *
 * @author amazingjadewu@163.com
 */
public class Solution201903251 {

    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == 0) return 0;
        long dividendAbs = Math.abs((long) dividend);
        long sum = 0;
        int num = 0;
        long temp = sum;
        long temp1 = num;
        while (sum < dividendAbs) {
            if (sum <= dividendAbs - sum) {
                if (sum == 0) {
                    sum = Math.abs((long) divisor);
                    if (sum <= dividendAbs) num = 1;
                    continue;
                }
                num = num << 1;
                sum = sum << 1;
                temp = sum;
                temp1 = num;
            } else {
                temp = temp >> 1;
                temp1 = temp1 >> 1;
                if (temp == 0) break;
                if (sum <= dividendAbs - temp) {
                    sum += temp;
                    num += temp1;
                }
            }
        }
        if ((dividend ^ divisor) >= 0) return num;
        else return -num;
    }

    public static void main(String[] args) {
        System.out.println(divide(
                -2147483648, -3));
    }
}
