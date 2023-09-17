class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // Initialize a dp array to store the shortest path lengths for all possible node and state combinations.
        int[][] dp = new int[n][1<<n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);// Initialize to a large value (divided by 2 to avoid overflow).
            dp[i][1<<i] = 0;// Starting from node i.

        } 

        Queue<int[]> q = new LinkedList<>();
        // Initialize the queue with all nodes as starting points.
        for(int i=0; i<n; i++){
            q.offer(new int[]{i, 1<<i});
        }

        while(!q.isEmpty()){
            int[] current = q.poll();
            int node = current[0];
            int state = current[1];
            for(int neg : graph[node]){
                int next = state | (1<<neg);// Mark the neighbor node as visited.

                if(dp[neg][next] > dp[node][state]+1){
                    dp[neg][next] = dp[node][state] + 1;
                    q.offer(new int[]{neg, next}); 
                }
            }
        }
        int minPath = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            minPath = Math.min(minPath, dp[i][(1<<n)-1]);
        }

        return minPath;

    }
}