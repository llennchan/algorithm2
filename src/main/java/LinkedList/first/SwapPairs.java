package LinkedList.first;

/**
 * 两两交换链表中的节点
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author 包成
 */
public class SwapPairs {

    public static ListNode doSwapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode n1 = temp.next;
            ListNode n2 = n1.next;
            temp.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            temp = n1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode result = doSwapPairs(head);
        do {
            System.out.println(result.val);
            result = result.next;
        } while (result != null);
    }

}
