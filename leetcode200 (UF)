class Solution {
    class UnionFind{
        int m, n;
        int count = 0;
        int[] parent;
        public UnionFind(char[][] grid){
            m = grid.length;
            n = grid[0].length;
            parent = new int[m * n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1'){
                        int id = i * n + j;
                        parent[id] = id;
                        count++;
                    }
                }
            }
        }
        public void union(int node1, int node2){
            int find1 = find(node1);
            int find2 = find(node2);
            if(find1 != find2){
                parent[find1] = find2;
                count--;
            }
        }
        public int find(int node){
            if(parent[node] == node){
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }
    }
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    for(int[] dir : dirs){
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == '1'){
                            int id1 = i * col + j;
                            int id2 = x * col + y;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }
}
