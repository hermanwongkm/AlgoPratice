/**
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return helperFunction(p,q);
    }
    
    public boolean helperFunction(TreeNode p, TreeNode q){
        if(p == null & q == null){
            return true;
        }
        //Have to check if one of it is null anot
        else if(p == null || q == null){ 
            return false;
        }        
        else if(p.val != q.val){ 
            return false;
        }
        else{
            return helperFunction(p.left, q.left) && helperFunction(p.right, q.right);
        }
    }
}
