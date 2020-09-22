package top.amazingwu.blog.solution201903;

/**
 * 给定两个大小为 m 和 n 的从小到大排序的数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * @author
 * @created 2019年03月03日20:33
 */
public class Solution201903031 {
    public static void main(String[] args) {
        int[] num1 = new int[]{3};
        int[] num2 = new int[]{1, 3, 4, 4, 5};
        System.out.println(findMedianSortedArrays(num1, num2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays2(
                nums1, 0, (nums1 == null) ? -1 : nums1.length - 1,
                nums2, 0, (nums2 == null) ? -1 : nums2.length - 1);
    }

    private static double findMedianSortedArrays2(int[] nums1, int startN, int endN, int[] nums2, int startM, int endM) {
        System.out.println(startN + " " + endN + " " + startM + " " + endM);
        if (startN > endN) {
            int temp = (endM - startM) / 2;
            if ((endM - startM) % 2 == 0) {
                return nums2[temp];
            } else {
                return (double) (nums2[temp] + nums2[Math.min(temp + 1, endM)]) / 2;
            }
        }
        if (startM > endM) {
            int temp = (endN - startN) / 2;
            if ((endN - startN) % 2 == 0) {
                return nums1[temp];
            } else {
                return (double) (nums1[temp] + nums1[Math.min(temp + 1, endN)]) / 2;
            }
        }
        if (startM == endM && startN == endN) {
            return (double) (nums1[startN] + nums2[startM]) / 2;
        }
        int indexMedianN = (startN + endN) / 2;
        int indexMedianM = (startM + endM + 1) / 2;

        int medianN = endN - startN == 1 ? (nums1[endN] + nums1[startN]) / 2 : nums1[indexMedianN];
        int medianM = endM - startM == 1 ? (nums2[endM] + nums2[endM]) / 2 : nums2[indexMedianM];
        if (medianN == medianM) {
            return medianN;
        }
        if (medianN > medianM) {
            if (endN - startN < endM - startM) {
                return findMedianSortedArrays2(nums1, startN, indexMedianN - 1, nums2, startM + (endN - (indexMedianN - 1)), endM);
            } else {
                return findMedianSortedArrays2(nums1, startN, endN - ((indexMedianM + 1) - startM), nums2, (indexMedianM + 1), endM);
            }
        } else {
            if (endN - startN < endM - startM) {
                return findMedianSortedArrays2(nums1, (indexMedianN + 1), endN, nums2, startM, endM - ((indexMedianN + 1) - startN));
            } else {
                return findMedianSortedArrays2(nums1, startN + (endM - (indexMedianM - 1)), endN, nums2, startM, (indexMedianM - 1));
            }
        }
    }
}
