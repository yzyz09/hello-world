class Solution {
    class UnionFind{
        int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int id){
            if(parent[id] == id)
                return id;
            parent[id] = find(parent[id]);
            return parent[id];
        }
        public boolean isConnected(int i, int j){
            return find(i) == find(j);
        }
        public void union(int i, int j){
            if(!isConnected(i, j)){
                parent[find(i)] = find(j);
            }
        }
    }
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        UnionFind uf = new UnionFind(N * N);
        int time = 0;
        while(!uf.isConnected(0, N * N - 1)){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(grid[i][j] > time)
                        continue;
                    if(i < N - 1 && grid[i + 1][j] <= time)
                        uf.union(i * N + j, (i + 1) * N + j);
                    if(j < N - 1 && grid[i][j + 1] <= time)
                        uf.union(i * N + j, i * N + j + 1);
                }
            }
            time++;
        }
        return time - 1;
    }
}
