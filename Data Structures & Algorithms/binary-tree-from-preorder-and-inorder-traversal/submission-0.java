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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return build(preorder, inOrderMap, 0, 0, n - 1);
    }

    private TreeNode build(int[] preorder, HashMap<Integer, Integer> inOrderMap,
                           int preIndex, int left, int right) {

        // Base case
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex]);

        int mid = inOrderMap.get(preorder[preIndex]);

        // Number of nodes in left subtree
        int leftSize = mid - left;

        // Build left subtree
        root.left = build(preorder, inOrderMap, preIndex + 1, left, mid - 1);

        // Build right subtree
        root.right = build(preorder, inOrderMap,
                           preIndex + leftSize + 1, mid + 1, right);

        return root;
    }
}