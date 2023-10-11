class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
       int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < n; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1; // Adding 1 to end time to include the ending moment
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int m = people.length;
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int arrivalTime = people[i];

            // Use binary search to find the position where the arrival time fits in the start and end arrays
            int startCount = binarySearch(start, arrivalTime);
            int endCount = binarySearch(end, arrivalTime);

            // Calculate the number of flowers in full bloom at the arrival time
            result[i] = startCount - endCount;
        }

        return result;
    }

    private int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}