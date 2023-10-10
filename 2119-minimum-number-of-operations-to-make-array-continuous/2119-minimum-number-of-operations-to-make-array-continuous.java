class Solution {
    public int minOperations(int[] nums) {
         Arrays.sort(nums);
        int left = 0;
        int maxUnique = 0;
        int minOperations = nums.length;
        Set<Integer> uniqueElements = new HashSet<>();
        
        for (int right = 0; right < nums.length; right++) {
            uniqueElements.add(nums[right]);
            
            while (nums[right] - nums[left] >= nums.length) {
                uniqueElements.remove(nums[left]);
                left++;
            }
            
            maxUnique = Math.max(maxUnique, uniqueElements.size());
            minOperations = Math.min(minOperations, nums.length - maxUnique);
        }
        
        return minOperations;
    }
}