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
    public int goodNodes(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,root.val));
        int c = 0;
        while(!q.isEmpty()){
            Pair sk = q.remove();
            if(sk.node.val>=sk.max) c++;
            if(sk.node.left!=null){
                q.add(new Pair(sk.node.left,Math.max(sk.node.left.val,sk.max)));
            }
            if(sk.node.right!=null){
                q.add(new Pair(sk.node.right,Math.max(sk.node.right.val,sk.max)));
            }
        }
        return c;
    }
    class Pair{
        TreeNode node;
        int max;
        Pair(TreeNode node,int max){
            this.max = max;
            this.node = node;
        }
    }
}
