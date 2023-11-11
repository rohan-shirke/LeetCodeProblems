class Graph {
    public Map<Integer, List<int[]>> adList;

    public Graph(int n, int[][] edges) {
        adList = new HashMap<>();
        for(int i=0; i<n; i++){
            adList.put(i, new ArrayList<>());
        }

        for(int[] ed : edges){
            int from = ed[0];
            int to = ed[1];
            int cost = ed[2];
            adList.get(from).add(new int[]{to, cost});
        }
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int cost = edge[2];
        adList.get(from).add(new int[]{to, cost});
    }
    
    public int shortestPath(int node1, int node2) {
       PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> distance = new HashMap<>();

        minHeap.offer(new int[]{node1, 0});
        distance.put(node1, 0);

        while (!minHeap.isEmpty()) {
            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentNode == node2) {
                return currentCost;
            }

            for (int[] neighbor : adList.get(currentNode)) {
                int neighborNode = neighbor[0];
                int neighborCost = neighbor[1];

                int newCost = currentCost + neighborCost;

                if (!distance.containsKey(neighborNode) || newCost < distance.get(neighborNode)) {
                    distance.put(neighborNode, newCost);
                    minHeap.offer(new int[]{neighborNode, newCost});
                }
            }
        }

        return -1; // No path found 
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */