/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode t = head;
        while (head!=null){
            head = head.next;
            t.next = reverseHead;
            reverseHead = t;
            t=head;
        }
        return reverseHead;
    }
}