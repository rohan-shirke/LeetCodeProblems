class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        List<String> result = new ArrayList<>();

        // Build the graph from the given tickets
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }

        // Start DFS from "JFK"
        dfs(graph, "JFK", result);

        // Reverse the result to get the correct itinerary
        Collections.reverse(result);
        return result;
    }
    private void dfs(Map<String, PriorityQueue<String>> graph, String from, List<String> result) {
        PriorityQueue<String> destinations = graph.get(from);

        while (destinations != null && !destinations.isEmpty()) {
            String to = destinations.poll();
            dfs(graph, to, result);
        }

        // Add the current airport to the result
        result.add(from);
    }
}