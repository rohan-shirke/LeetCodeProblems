class Solution {
    public int kthGrammar(int n, int k) {
        if (n==1){
            return 0;
        }
        // Check the parent's value
        int parent = kthGrammar(n-1, (k+1)/2);
        // Check if the parent is 0 or 1 and return accordingly
        if(parent == 0){
            return 1-k%2;
        }else{
            return k%2;
        }
    }
}