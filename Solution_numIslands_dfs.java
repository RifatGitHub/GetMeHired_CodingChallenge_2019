class Solution_numIslands_dfs {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0){
            return 0;
        }
        int isLand = 0;
        for (int i = 0; i < grid.length; i++){    // grid.length is the number of rows
            for (int j = 0; j < grid[0].length; j++){   // grid[0].length is the number of columns
                if (grid[i][j] == '1'){
                    isLand += dfs(grid, i, j);
                }   
            }
        }
        return isLand;
    }
    public static int dfs(char[][] grid, int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0'){
            return 0;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        return 1;
    }
}
