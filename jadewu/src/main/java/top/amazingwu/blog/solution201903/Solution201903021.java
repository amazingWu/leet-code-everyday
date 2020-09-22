package top.amazingwu.blog.solution201903;

/**
 * @decription https://leetcode-cn.com/problems/add-two-numbers/solution/
 * @author amazingjadewu@163.com
 */
public class Solution201903021 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        ListNode current = null;
        int next = 0;
        while (l1 != null || l2 !=null || next!=0){
            while (next >= 0){
                ListNode tempAdd = new ListNode(next %10);
                if (listNode == null) {
                    current = tempAdd;
                    listNode = current;
                } else {
                    current.next = tempAdd;
                    current = current.next;
                }
                next = next /10;
                if (next == 0){
                    break;
                }
            }
            int temp =0;
            if (l1 !=null) {
                temp += l1.val;
                l1 = l1.next;
            }
            if (l2 !=null) {
                temp += l2.val;
                l2 = l2.next;
            }
            int val = current.val;
            current.val = (val + temp) % 10;
            next = (val + temp)/10;
        }
        return listNode;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);

        ListNode result =addTwoNumbers(listNode1, listNode2);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}