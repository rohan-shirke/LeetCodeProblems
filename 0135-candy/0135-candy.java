class Solution {
    public int candy(int[] ratings) {
         int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        // Traverse from left to right
        for(int i=1; i<n; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1]+1;
            }
        }
        // Traverse from right to left
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1] && candies[i] <= candies[i+1]){
                candies[i] = candies[i+1] +1;
            }
        }

        // Calculate the sum of candies
        int sum = 0;

        for(int candy : candies){
            sum+=candy;
        }
        return sum;
    }
}