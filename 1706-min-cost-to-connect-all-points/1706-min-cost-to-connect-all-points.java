class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        // Create edges and calculate Manhattan distance
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int distance = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                minHeap.offer(new Edge(i, j, distance));
            }
        }

        int minCost = 0;
        int connected = 0;
        UnionFind uf = new UnionFind(n);

        // Kruskal's algorithm using priority queue
        while (connected < n - 1) {
            Edge edge = minHeap.poll();
            int root1 = uf.find(edge.src);
            int root2 = uf.find(edge.dest);

            if (root1 != root2) {
                minCost += edge.weight;
                uf.union(root1, root2);
                connected++;
            }
        }

        return minCost;
    }

    class Edge {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
        }

        int find(int vertex) {
            if (parent[vertex] == -1) {
                return vertex;
            }
            return parent[vertex] = find(parent[vertex]);
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
}
