class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // Define the eight possible directions
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        // Iterate through each cell in the board
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = 0;
                
                // Count the number of live neighbors
                for (int k = 0; k < 8; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    
                    if (x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)) {
                        liveNeighbors++;
                    }
                }
                
                // Apply the rules to determine the next state
                if (board[i][j] == 1) {
                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        board[i][j] = 2; // Cell dies
                    }
                } else {
                    if (liveNeighbors == 3) {
                        board[i][j] = -1; // Cell becomes alive
                    }
                }
            }
        }
        
        // Update the board with the next state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0; // Set dead cells to 0
                } else if (board[i][j] == -1) {
                    board[i][j] = 1; // Set live cells to 1
                }
            }
        }
    }
}
