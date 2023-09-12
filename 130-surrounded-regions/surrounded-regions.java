class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        // Step 1: Mark boundary 'O's and their neighbors as safe
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                markAsSafe(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                markAsSafe(board, i, n - 1);
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                markAsSafe(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                markAsSafe(board, m - 1, j);
            }
        }
        
        // Step 3: Flip 'O's that are not marked as safe to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'S') {
                    board[i][j]= 'O';
                }
            }
        }
    }
    public void markAsSafe(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') {
            return;
        }
        
        board[i][j] = 'S'; // Mark as safe
        
        // DFS in 4 directions
        markAsSafe(board, i - 1, j);
        markAsSafe(board, i + 1, j);
        markAsSafe(board, i, j - 1);
        markAsSafe(board, i, j + 1);
    }
}