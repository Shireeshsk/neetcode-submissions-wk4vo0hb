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
    public TreeNode buildTree(int[] pre, int[] in) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<in.length;i++){
            map.put(in[i],i);
        }
        TreeNode root = helper(in,0,in.length-1,pre,0,pre.length-1,map);
        return root;
    }

    public TreeNode helper(int in[],int ins,int ine,int pre[],int pres,int pree,Map<Integer,Integer> map){
        if(ins>ine || pres>pree) return null;
        TreeNode root = new TreeNode(pre[pres]);
        int idx = map.get(pre[pres]);
        int len = idx-ins;
        root.left = helper(in,ins,idx-1,pre,pres+1,pres+len,map);
        root.right = helper(in,idx+1,ine,pre,pres+len+1,pree,map);
        return root;
    }
}
