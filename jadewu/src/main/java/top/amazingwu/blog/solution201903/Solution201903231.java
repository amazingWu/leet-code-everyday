package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 两两交换链表中的节点
 *
 * @author amazingjadewu@163.com
 */
public class Solution201903231 {
    public static ListNode swapPairs(ListNode head) {
        ListNode headCopy = head;
        ListNode nodeBefore = null;
        ListNode nodeCurrent = head;
        if (head != null && head.next != null) {
            headCopy = head.next;
        }
        while (nodeCurrent != null && nodeCurrent.next != null) {
            if (nodeBefore != null) {
                nodeBefore.next = nodeCurrent.next;
            }
            nodeBefore = nodeCurrent.next;
            nodeCurrent.next = nodeCurrent.next.next;
            nodeBefore.next = nodeCurrent;
            nodeBefore = nodeCurrent;
            nodeCurrent = nodeCurrent.next;
        }
        return headCopy;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i <= 10; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
        System.out.println("-------------");
        ListNode headNew = swapPairs(head);
        current = headNew;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
