/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    static final String SPLITER = ",";
    static final String NN = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return NN;
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        return sb.toString();
    }
    public void buildString(StringBuilder sb, TreeNode node){
        if(node == null)
            return;
        sb.append(node.val).append(SPLITER);
        buildString(sb, node.left);
        buildString(sb, node.right);
    }

    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NN))
            return null;
        Queue<String> q = new LinkedList();
        q.addAll(Arrays.asList(data.split(SPLITER)));
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<String> q){
        if(q.isEmpty())
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(q.poll()));
        Queue<String> smallQ = new LinkedList();
        while(!q.isEmpty() && Integer.parseInt(q.peek()) < root.val){
            smallQ.offer(q.poll());
        }
        root.left = buildTree(smallQ);
        root.right = buildTree(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
