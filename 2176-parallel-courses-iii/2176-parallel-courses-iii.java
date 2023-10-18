class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegrees = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            graph.get(prevCourse).add(nextCourse);
            inDegrees[nextCourse]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegrees[i] == 0) {
queue.offer(i);
                dp[i] = time[i - 1];
            }
        }

        int result = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {
                inDegrees[next]--;
                dp[next] = Math.max(dp[next], dp[curr] + time[next - 1]);
                if (inDegrees[next] == 0) {
                    queue.offer(next);
                }
            }
            result = Math.max(result, dp[curr]);
        }

        return result;
    }
}