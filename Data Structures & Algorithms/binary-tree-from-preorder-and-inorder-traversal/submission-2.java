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
        int n=preorder.length;
        HashMap <Integer,Integer> inOrderMap =new HashMap <>();
        for(int i=0;i<n;i++){
            inOrderMap.put(inorder[i],i);
        }

        return build(preorder,inOrderMap,0,0,n-1);
        
    }
    
    private TreeNode build(int[] preorder,HashMap <Integer,Integer> inOrderMap,
        int preindex,int left,int right){
            if(left > right) return null;
            TreeNode root=new TreeNode(preorder[preindex]);
            int mid= inOrderMap.get(preorder[preindex]);
            int leftdist=mid-left;

            root.left=build(preorder,inOrderMap,preindex+1,left,mid-1);
            root.right=build(preorder,inOrderMap,preindex+leftdist+1,mid+1,right);
            return root;
    }
}
