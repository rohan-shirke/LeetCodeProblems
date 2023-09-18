class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int countA = countSoldiers(mat[a]);
                int countB = countSoldiers(mat[b]);
                
                if (countA == countB) {
                    return a - b; // If counts are equal, compare by row index
                }
                return countA - countB; // Otherwise, compare by count
            }
        });
        
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = indices[i];
        }
        
        return result;
    }

    public int countSoldiers(int[] row) {
        int left = 0;
        int right = row.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (row[mid] == 1) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}