package LinkedList.first;

/**
 * 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 1 -> 2 -> 3 -> 4 -> null
 * null <- 1 <- 2 <- 3 <- 4
 *
 * @author 包成
 */
public class ReverseList {

    public static ListNode doReverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = doReverseList(head);
        while (result!= null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
