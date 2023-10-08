class Solution {
    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        int isLandCOunt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == '1'){
                    exploreIsLandDFS(grid, i, j);
                    isLandCOunt++;
                }
            }
        }
        return isLandCOunt;
    }

    public void exploreIsLandDFS(char[][] grid, int row, int col){
        int N = grid.length;
        int M = grid[0].length;
         if (row < 0 || row >= N || col < 0 || col >= M || grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        exploreIsLandDFS(grid, row+1, col);
        exploreIsLandDFS(grid, row-1, col);
        exploreIsLandDFS(grid, row, col+1);
        exploreIsLandDFS(grid, row, col-1);


    }
}