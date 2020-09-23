package JiebiArray;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author magicjay
 * @version 1.0
 * @date 2020/9/22
 * @description 第三大的数
 * 方法1 遍历一次，存三个变量
 * 方法2 遍历三次，存三个变量
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3, 2, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 第三大的数是 1.
 * 示例 2:
 * <p>
 * 输入: [1, 2]
 * <p>
 * 输出: 2
 * <p>
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 * <p>
 * 输入: [2, 2, 3, 1]
 * <p>
 * 输出: 1
 * <p>
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/third-maximum-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThirdMaximumNumber_414 {
    public int thirdMax(int[] nums) {
        if (nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return nums[0] > nums[1] ? nums[0] : nums[1];
        int tmp1 = Integer.MIN_VALUE;
        int tmp2 = Integer.MIN_VALUE;
        int tmp3 = Integer.MIN_VALUE;
        int factLen = nums.length;
        boolean flag = false;
        for (int val : nums) {
            //如果第一次不跳过绝对最小值，[1, 2, -2147483648]，因为tmp三个数初始化都是绝对最小值，会被认作数组只有1，2两个元素，这样factLen为2，
            //就取最大的那个数2了。
            if (val == Integer.MIN_VALUE && !flag) {
                flag = true;
                continue;
            }
            //为了防止没有绝对最小值的重复元数组且该数组长度小于3的case出现，比如[1,1,2] 的这种情况。
            if (val == tmp1 || val == tmp2 || val == tmp3) {
                //反正我要的是前三个大的数
                factLen--;
                continue;
            }

            if (val > tmp1) {
                tmp3 = tmp2;
                tmp2 = tmp1;
                tmp1 = val;
            } else if (val < tmp1 && val > tmp2) {
                tmp3 = tmp2;
                tmp2 = val;
            } else if (val < tmp2 && val > tmp3) {
                tmp3 = val;
            }
        }
        //<3说明没有第三大的元素就返回最大的元素
        return factLen >= 3 ? tmp3 : tmp1;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber_414 tm = new ThirdMaximumNumber_414();
        int[] nums = {1, 2, -2147483648};
//        int[] nums = {1,2,2};
        System.out.println(tm.thirdMax(nums));
//        System.out.println(Integer.MIN_VALUE);
    }
}
