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
    public static final String spliter = ",";
    public static final String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return NULL;
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            sb.append(node.val).append(spliter);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL))
            return null;
        String[] strs = data.split(spliter);
        Queue<Integer> q = new LinkedList<>();
        for(String str : strs){
            q.offer(Integer.parseInt(str));
        }
        // q.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(q);
    }
    public TreeNode buildTree(Queue<Integer> q){
        if(q.isEmpty())
            return null;
        TreeNode node = new TreeNode(q.poll());
        Queue<Integer> smallQueue = new LinkedList<>();
        while(!q.isEmpty() && q.peek() < node.val){
            smallQueue.offer(q.poll());
        }
        node.left = buildTree(smallQueue);
        node.right = buildTree(q);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
