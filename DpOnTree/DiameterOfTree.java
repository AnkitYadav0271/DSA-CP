/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    int res = Integer.MIN_VALUE;
    public int diameter(Node root) {
        // code here
        solve(root);
        return res;
    }
    
    
    public int solve(Node root){
        //base case
        if(root == null){
            return -1;
        }
        
        //hypothesis part 
        int left = solve(root.left);
        int right = solve(root.right);
        
        //inductive part (if you are from future and do not understand what is hypothesis and induction refer the notebook or DSA-CP)
        int temp = Math.max(left,right) + 1;
        int ans = Math.max(temp,left+right + 2);
        res = Math.max(ans,res);
        return temp;
    }
}