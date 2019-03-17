package top.amazingwu.blog.solution201903;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 删除链表的倒数第N个节点
 *
 * @author amazingjadewu@163.com
 * @created 2019年03月17日22:31
 */
public class Solution201903171 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nEnd = head, nStart = head;
        ListNode nStartBefore = null;
        for (int i = 0; i < n - 1; i++) {
            nEnd = nEnd.next;
        }
        while (nEnd.next != null) {
            nStartBefore = nStart;
            nStart = nStart.next;
            nEnd = nEnd.next;
        }
        if (nStartBefore != null) {
            nStartBefore.next = nStart.next;
            nStart.next = null;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ite = head;
        for (int i = 1; i < 2; i++) {
            ite.next = new ListNode(i + 1);
            ite = ite.next;
        }
        ite = removeNthFromEnd(head, 2);
        while (ite != null) {
            System.out.println(ite.val);
            ite = ite.next;
        }
    }
}
