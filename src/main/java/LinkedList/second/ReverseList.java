package LinkedList.second;

import LinkedList.first.ListNode;

/**
 * @author 包成
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        // 储存轮询的上一个节点
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            // 下一个节点指向上一个节点
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        // 反转前的最后一个节点当做头结点了
        return prev;
    }

}
