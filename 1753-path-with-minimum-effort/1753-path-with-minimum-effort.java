class Solution {
    public int minimumEffortPath(int[][] heights) {
       int m = heights.length;
        int n = heights[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Create a priority queue to store cells based on their efforts
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        // Initialize an array to store the minimum efforts required to reach each cell
        int[][] minEffort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }
        
        minEffort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            int effort = cell[2];
            
            if (x == m - 1 && y == n - 1) {
                return effort; // Reached the destination
            }
            
            // Explore all possible directions
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    // Calculate the maximum effort to reach the new cell
                    int newEffort = Math.max(effort, Math.abs(heights[newX][newY] - heights[x][y]));
                    
                    // If the new effort is less than the previously calculated effort for this cell
                    // update the minEffort array and add the cell to the priority queue
                    if (newEffort < minEffort[newX][newY]) {
                        minEffort[newX][newY] = newEffort;
                        pq.offer(new int[]{newX, newY, newEffort});
                    }
                }
            }
        }
        
        return -1; // No path found (this should not happen in a valid input) 
    }
}