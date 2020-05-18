/**
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.
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
    public int maxDepth(TreeNode root) {
        return checkHeight(root);
    }
    
    public int checkHeight(TreeNode root){
        if(root != null){
            return Math.max(checkHeight(root.left), checkHeight(root.right)) + 1;
        }
        else{ //So if it is null means the previous node has no child so return 0
            return 0;
        }
    }
}
