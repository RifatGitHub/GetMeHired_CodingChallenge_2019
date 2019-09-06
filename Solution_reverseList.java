/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution_reverseList {
    public ListNode reverseList(ListNode given_head) {
        ListNode result = null;
        ListNode current = given_head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = result;
            result = current;
            current = temp;
        }
        return result;
    }
}

/*
How it works:

Initially:

result = NULL
current = given_head := (1->2->3->4->5->NULL)


1st iteration:

temp = current.next := (2->3->4->5->NULL)
current.next = result := NULL
current := (1->null)
result = current := (1->null)
current = temp := (2->3->4->5->NULL)


2nd iteration:

temp = current.next := (3->4->5->NULL)
current.next = result := (1->null)
current := (2->1->null)
result = current := (2->1->null)
current = temp := (3->4->5->NULL)


...
...

*/