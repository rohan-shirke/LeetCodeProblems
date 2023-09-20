class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph and populate the values
        Map<String, Map<String, Double>> graph = new HashMap<>();
        int index = 0;
        
        for (List<String> equation : equations) {
            String from = equation.get(0);
            String to = equation.get(1);
            double value = values[index++];
            
            // Create an entry for 'from' if it doesn't exist
            graph.putIfAbsent(from, new HashMap<>());
            graph.get(from).put(to, value);
            
            // Create an entry for 'to' if it doesn't exist
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(to).put(from, 1.0 / value);
        }
        
        // Perform DFS for each query
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            results[i] = dfs(graph, from, to, 1.0, new HashSet<>());
        }
        
        return results;
    }

    public double dfs(Map<String, Map<String, Double>> graph, String from, String to, double result, Set<String> visited) {
        // If 'from' or 'to' does not exist in the graph, return -1.0
        if (!graph.containsKey(from) || !graph.containsKey(to)) {
            return -1.0;
        }
        
        // If we reach 'to' node, return the result
        if (from.equals(to)) {
            return result;
        }
        
        visited.add(from);
        Map<String, Double> neighbors = graph.get(from);
        
        for (String neighbor : neighbors.keySet()) {
            if (!visited.contains(neighbor)) {
                double newResult = result * neighbors.get(neighbor);
                double subResult = dfs(graph, neighbor, to, newResult, visited);
                
                // If a valid result is found, return it
                if (subResult != -1.0) {
                    return subResult;
                }
            }
        }
        
        visited.remove(from);
        
        // If no valid result is found, return -1.0
        return -1.0;
    }
}