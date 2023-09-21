class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Create an array to keep track of the in-degrees of each course
        int[] inDegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adjList.get(prereq).add(course);
            inDegrees[course]++;
        }

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                queue.offer(i);
            }
        }

        // Initialize an array to store the course order
        int[] courseOrder = new int[numCourses];
        int index = 0;

        // Perform BFS to find the course order
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseOrder[index++] = course;

            for (int nextCourse : adjList.get(course)) {
                inDegrees[nextCourse]--;
                if (inDegrees[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Check if all courses have been taken
        if (index == numCourses) {
            return courseOrder;
        } else {
            // It's impossible to finish all courses
            return new int[0];
        }
    }
}