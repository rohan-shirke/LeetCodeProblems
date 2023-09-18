class Solution {
    int side, row, col, pos;
    public int snakesAndLadders(int[][] board) {
        int n = board.length*board.length;
        side = board.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        int moves = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k = 0; k < size; k++){
                int curr = q.poll();
                if(curr == n - 1){
                    return moves;
                }
                for(int next = curr + 1; next <= Math.min(curr + 6, n - 1); next++){
                    row = next/side; //Selecting the row
                    col = row%2 == 0 ? next%side : side - 1 - next%side; // checking if the row is odd and assigning the value accordingly
                    pos = board[side - 1 - row][col] != -1 ? board[side - 1 - row][col] - 1 : next;
                    if(visited[pos] == false){
                        visited[pos] = true;
                        q.offer(pos);
                    }
                }
            }
            moves++;
        }
        return -1;
    }


    public int[] getCoordinates(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (row % 2 == n % 2) ? (square - 1) % n : n - 1 - (square - 1) % n;
        return new int[]{row, col};
    }
    
}