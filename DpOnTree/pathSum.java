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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        solve(root);
        return res;
        
    }

    public int solve(TreeNode root){
        //base case
        if(root == null) return 0;

        //Hypothesis part

        int left = Math.max(solve(root.left),0);
        int right = Math.max(solve(root.right),0);

        //Inductive part

        int temp = Math.max(left,right) + root.val;
        int ans = Math.max(temp,left + right + root.val);
        res = Math.max(res,ans);
        return temp;
    }
}