/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode currentNode = root;

        while(currentNode != null || !stack.isEmpty()){
            // Traverse down the left subtree, pushing nodes onto the stack.
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            // Pop the top node from the stack (which is the leftmost node),
            // add its value to the result, and move to its right subtree.
            currentNode = stack.pop();
            result.add(currentNode.val);
            currentNode = currentNode.right;
        }
        return result;
    }
}