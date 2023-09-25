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
    public int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        calculatDiameter(root);
        return diameter;

    }

    public int calculatDiameter(TreeNode node){
        if(node == null){
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = calculatDiameter(node.left);
        int rightDepth = calculatDiameter(node.right);
        // Update the diameter if a longer path is found
        diameter = Math.max(diameter, leftDepth + rightDepth);
        
        // Return the depth of the current subtree
        return Math.max(leftDepth, rightDepth) + 1;
    }
}