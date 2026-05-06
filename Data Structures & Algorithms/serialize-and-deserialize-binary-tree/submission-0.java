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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "N";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode sk = q.remove();
            if(sk==null){
                sb.append("N,");
            }
            else{
                sb.append(sk.val).append(",");
                q.add(sk.left);
                q.add(sk.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String arr[] = data.split(",");
        if(arr[0].equals("N")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int idx = 1;
        while(!q.isEmpty()){
            TreeNode sk = q.remove();
            if(!arr[idx].equals("N")){
                sk.left = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(sk.left);
            }
            idx++;
            if(!arr[idx].equals("N")){
                sk.right = new TreeNode(Integer.parseInt(arr[idx]));
                q.add(sk.right);
            }
            idx++;
        }
        return root;
    }
}
