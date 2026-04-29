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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                // Both nodes are in left subtree
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                // Both nodes are in right subtree
                curr = curr.right;
            } else {
                // Split point found — this is the LCA
                // Handles 3 cases:
                // 1. p is on left, q is on right (or vice versa)
                // 2. curr == p (p is ancestor of q)
                // 3. curr == q (q is ancestor of p)
                return curr;
            }
        }
        
        return null; // Should never reach here for valid BST input
    }
}