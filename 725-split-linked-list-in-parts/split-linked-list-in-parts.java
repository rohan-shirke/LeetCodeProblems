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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Find the length of the linked list.
        int length = 0;

        ListNode curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }

        // Step 2: Calculate the size of each part and the number of extra nodes.
        int partSize = length/k;
        int extraNodes = length%k;

        // Step 3: Create an array of ListNode arrays.
        ListNode[] result = new ListNode[k];
        curr = head;

        // Step 4 and 5: Iterate through the linked list and split it into k parts.
        for(int i=0; i<k; i++){
            result[i] = curr;
            int currentPartSize = partSize + (i<extraNodes ? 1 : 0);// Distribute extra nodes.
            // Move current to the end of the current part.
            for(int j=1; j<currentPartSize; j++){
                curr = curr.next;
            }

            if(curr != null){
                ListNode next = curr.next;
                curr.next = null;// Disconnect the current part.
                curr = next;

            }
        }
        // Step 6: Return the array of ListNode arrays.
        return result;
    }
}