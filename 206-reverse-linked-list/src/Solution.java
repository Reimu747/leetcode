// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/10 2:11
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：迭代
     * @param head 链表头指针
     * @return 反转后的链表头指针
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 解法二：递归
     * @param head 链表头指针
     * @return 反转后的链表头指针
     */
    public ListNode reverseListDf(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode res = reverseListDf(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}
