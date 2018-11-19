class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> start = new ArrayList();
        List<Integer> end = new ArrayList();
        return dfs(root, 0, 1, start, end);
    }
    public int dfs(TreeNode node, int level, int index, List<Integer> start, List<Integer> end){
        if(node == null)
            return 0;
        if(level == start.size()){
            start.add(index);
            end.add(index);
        }
        else{
            end.set(level, index);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(node.left, level + 1, index * 2, start, end);
        int right = dfs(node.right, level + 1, index * 2 + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}
