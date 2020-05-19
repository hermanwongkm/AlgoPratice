/**
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9

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
//This is a bottom up approach 
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}

//This is a top down approach

public void invertHelper(TreeNode root)
    {
        if(root==null)
            return;
// swap the left right nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
      // once done at root level, keep doing it at child nodes
        invertHelper(root.left);
        invertHelper(root.right);
        
    }
