class Solution {
    class UnionFind{
        int[] parent;
        int count = 0;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
                count++;
            }
        }
        public void union(int i, int j){
            int a = find(i);
            int b = find(j);
            if(a != b){
                parent[a] = b;
                count--;
            }
        }
        public int find(int a){
            if(parent[a] == a)
                return a;
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UnionFind uf = new UnionFind(N);
        for(int i = 0; i < N; i++){
            int a = row[2 * i];
            int b = row[2 * i + 1];
            uf.union(a/2, b/2);
        }
        return N - uf.count;
    }
}
