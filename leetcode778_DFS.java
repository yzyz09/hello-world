class Solution {
    public int swimInWater(int[][] grid) {
        int time = 0;
        int N = grid.length;
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(N*N - 1)){
            visited.clear();
            dfs(grid, visited, time, 0, 0);
            time++;
        }
        return time - 1;
    }
    public void dfs(int[][] grid, Set<Integer> visited, int time, int i, int j){
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || grid[i][j] > time || visited.contains(i * grid.length + j))
            return;
        visited.add(i * grid.length + j);
        dfs(grid, visited, time, i + 1, j);
        dfs(grid, visited, time, i - 1, j);
        dfs(grid, visited, time, i, j - 1);
        dfs(grid, visited, time, i, j + 1);
    }
}
