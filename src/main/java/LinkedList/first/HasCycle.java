package LinkedList.first;

/**
 * 环形链表
 * https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author 包成
 */
public class HasCycle {

    public static boolean doHasCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return false;
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null && fast != null) {
            if (slow == fast) return true;
            slow = slow.next;
            if (fast.next == null) break;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode();
        a.val = 2;
        a.next = new ListNode(3, new ListNode(4, a));
        ListNode head = new ListNode(1, a);
        boolean result = doHasCycle(head);
        System.out.println(result);
    }

}
