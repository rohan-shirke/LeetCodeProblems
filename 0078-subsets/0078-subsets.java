class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        genrateSubsets(nums, 0, new ArrayList<Integer>(), result);
        return result;

    }

    public void genrateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result){
        result.add(new ArrayList<>(current));// Add the current subset to the result

        for(int i=index; i<nums.length; i++){
            current.add(nums[i]);// Include the current element in the subset
            genrateSubsets(nums, i+1, current, result);// Recursively generate subsets with the current element
            current.remove(current.size()-1);// Backtrack by removing the current element
        }


    }
}