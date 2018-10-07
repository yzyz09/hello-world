/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)
            return new ArrayList<TreeNode>();
        return generate(1, n);
    }
    public List<TreeNode> generate(int left, int right){
        List<TreeNode> res = new ArrayList<>();
        if(left > right){
            res.add(null);
            return res;
        }
        for(int i = left; i <= right; i++){
            List<TreeNode> lefts = generate(left, i - 1);
            List<TreeNode> rights = generate(i + 1, right);
            for(int j = 0; j < lefts.size(); j++){
                for(int k = 0; k < rights.size(); k++){
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
