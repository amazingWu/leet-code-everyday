package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 整数转罗马数字
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月10日19:25
 */
public class Solution201903101 {
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int num1 = num / 1000;
        for (int i = 0; i < num1; i++)
            sb.append("M");
        num = num % 1000;
        sb.append(getNumberString(num / 100, 'M', 'D', 'C'));
        num = num % 100;
        sb.append(getNumberString(num / 10, 'C', 'L', 'X'));
        num = num % 10;
        sb.append(getNumberString(num, 'X', 'V', 'I'));
        return sb.toString();
    }

    public static String getNumberString(int number, Character high, Character middle, Character min) {
        StringBuilder sb = new StringBuilder();
        if (number == 9) sb.append(min).append(high);
        else if (number >= 5) {
            sb.append(middle);
            for (int i = 5; i < number; i++)
                sb.append(min);
        } else if (number == 4) {
            sb.append(min).append(middle);
        } else {
            for (int i = 0; i < number; i++)
                sb.append(min);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(5));
        System.out.println(intToRoman(6));

        System.out.println(intToRoman(40));
        System.out.println(intToRoman(50));
        System.out.println(intToRoman(60));
        System.out.println(intToRoman(63));
        System.out.println(intToRoman(64));
        System.out.println(intToRoman(65));
        System.out.println(intToRoman(66));

        System.out.println(intToRoman(300));
        System.out.println(intToRoman(400));
        System.out.println(intToRoman(500));
        System.out.println(intToRoman(600));
        System.out.println(intToRoman(660));
        System.out.println(intToRoman(666));
    }
}
