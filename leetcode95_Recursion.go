/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func generateTrees(n int) []*TreeNode {
    if n == 0 {
        return []*TreeNode{}
    }
    return genTrees(1,n)
}

func genTrees(start int, end int) []*TreeNode {
    list := make([]*TreeNode, 0)
    if start > end {
        var n *TreeNode
        list = append(list, n)
        return list
    }
    
    var left []*TreeNode
    var right []*TreeNode
    for i:= start; i <= end; i++ {
        left= genTrees(start, i - 1)
        right= genTrees(i+1, end)
    
        for _, lNode := range left {
            for _, rNode := range right {
                root:= new(TreeNode)
                root.Val = i
                root.Left = lNode
                root.Right = rNode
                list = append(list, root)
            }
        }
    }
    return list
}
