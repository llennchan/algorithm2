package LinkedList.first;

/**
 * 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author 包成
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (slow != ptr) {
                    slow = slow.next;
                    ptr = ptr.next;
                }
                return slow;
            }
        }
        return null;
    }

}
