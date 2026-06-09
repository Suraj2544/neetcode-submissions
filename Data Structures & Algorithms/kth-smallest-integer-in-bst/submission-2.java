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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList <Integer> result =new ArrayList <>();
        inOrder(root,result);
        return result.get(k-1);
        
    }
    private void inOrder(TreeNode root, ArrayList <Integer> result){
        if(root==null){
            return ;
        }

        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right,result);
    }
}
