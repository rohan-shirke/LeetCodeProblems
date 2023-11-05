class Solution {
    public int getWinner(int[] arr, int k) {
        int currMax = arr[0];
        int wins = 0;

        for(int i=1; i<arr.length; i++){
            if(arr[i] > currMax){
                currMax = arr[i];
                wins = 1;
            }else{
                wins++;
            }
            if(wins == k){
                break;
            }
        }
        return currMax;
    }
}