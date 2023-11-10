class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        // Build adjacency map
        for (int[] pair : adjacentPairs) {
            adjacencyMap.putIfAbsent(pair[0], new ArrayList<>());
            adjacencyMap.putIfAbsent(pair[1], new ArrayList<>());
            adjacencyMap.get(pair[0]).add(pair[1]);
            adjacencyMap.get(pair[1]).add(pair[0]);
        }

        // Find the start point (a node with only one neighbor)
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        int n = adjacentPairs.length + 1; // Size of the original array
        int[] result = new int[n];
        Set<Integer> visited = new HashSet<>();

        // DFS to reconstruct the array
        dfs(start, adjacencyMap, visited, result, 0);

        return result;
    }
    private void dfs(int current, Map<Integer, List<Integer>> adjacencyMap, Set<Integer> visited, int[] result, int index) {
        visited.add(current);
        result[index] = current;

        for (int neighbor : adjacencyMap.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, adjacencyMap, visited, result, index + 1);
                break; // There should be only one unvisited neighbor for each node
            }
        }
    }
}