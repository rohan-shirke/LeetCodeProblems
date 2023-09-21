class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        
        // First row always contains a single element '1'.
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> prevRow = triangle.get(rowNum - 1);
            List<Integer> currentRow = new ArrayList<>();
            
            // The first element of each row is always '1'.
            currentRow.add(1);
            
            for (int j = 1; j < rowNum; j++) {
                // Calculate the current element as the sum of the two elements above it.
                int sum = prevRow.get(j - 1) + prevRow.get(j);
                currentRow.add(sum);
            }
            
            // The last element of each row is always '1'.
            currentRow.add(1);
            
            // Add the current row to the triangle.
            triangle.add(currentRow);
        }
        
        return triangle;
    }
}