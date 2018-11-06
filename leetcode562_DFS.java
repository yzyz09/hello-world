class Solution {
    public int longestLine(int[][] M) {
        if(M == null)
            return 0;
        int res = 0;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    res = Math.max(res, getMaxOneLine(M, i, j));
                }
            }
        }
        return res;
    }
    int[][] dirs = {{0, 1}, {1, 0}, {1, 1}, {1, -1}};
    public int getMaxOneLine(int[][] M, int x, int y){
        int res = 1;
        for(int[] dir : dirs){
            int i = x + dir[0];
            int j = y + dir[1];
            int count = 1;
            while(isValidPosition(M, i, j) && M[i][j] == 1){
                i += dir[0];
                j += dir[1];
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    public boolean isValidPosition(int[][] M, int i, int j){
        return (i >= 0 && i < M.length && j >= 0 && j < M[0].length);
    }
}
