/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// using Brent's algorithm
public class Solution_detectCycle_Brent {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        int power = 1, lam = 1;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(power == lam) {
                slow = fast;
                power = power*2;
                lam = 0;
            }
            if(fast == null)
                return null;
            fast = fast.next;
            lam++;
        }
        slow = head;
        fast = head;
        for(int i=0; i<lam; i++) {
            fast = fast.next;
        }
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
