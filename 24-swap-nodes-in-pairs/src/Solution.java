// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * @ClassName Solution
 * @Author lenovo
 * @Date 2020/1/9 3:06
 * @Description
 * @Version 1.0
 **/
public class Solution {
    /**
     * 解法一：DF 递归
     * @param head 头结点
     * @return 翻转后的头结点
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode tail = head.next;
        if (tail == null) {
            return head;
        }
        head.next = swapPairs(tail.next);
        tail.next = head;
        return tail;
    }

    /**
     * 解法一：迭代
     * @param head 头结点
     * @return 翻转后的头结点
     */
    public ListNode swapPairsTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = new ListNode(-1);
        ListNode res = node;

        while (head != null && head.next != null) {
            node.next = head.next;
            head.next = head.next.next;
            node.next.next = head;

            node = node.next.next;
            head = head.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        s.swapPairsTwo(a);
    }
}