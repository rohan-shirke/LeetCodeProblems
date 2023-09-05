/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        // Step 1: Create a copy of each node and insert it after the original node
        Node curr = head;
        while(curr != null){
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        // Step 2: Update the random pointers of the copied nodes
        curr = head;
        while(curr != null){
            if(curr.random != null){
                curr.next.random  = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Step 3: Separate the original and copied linked lists
        curr = head;
        Node copiedHead = head.next;
        Node copiedCurr = copiedHead;


        while(curr != null){
            curr.next = curr.next.next;
            if(copiedCurr.next != null){
                copiedCurr.next = copiedCurr.next.next;
            }
            curr = curr.next;
            copiedCurr = copiedCurr.next;
        }
        return copiedHead;

    }
}