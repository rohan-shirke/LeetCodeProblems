class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                stopToRoutes.computeIfAbsent(stop, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visitedStops.add(source);

        int buses = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            buses++;

            for (int i = 0; i < size; i++) {
                int currentStop = queue.poll();

                for (int route : stopToRoutes.getOrDefault(currentStop, Collections.emptyList())) {
                    if (visitedBuses.contains(route)) {
                        continue;
                    }

                    visitedBuses.add(route);

                    for (int nextStop : routes[route]) {
                        if (visitedStops.contains(nextStop)) {
                            continue;
                        }

                        if (nextStop == target) {
                            return buses;
                        }

                        visitedStops.add(nextStop);
                        queue.offer(nextStop);
                    }
                }
            }
        }

        return -1; // Target not reachable
    }
}