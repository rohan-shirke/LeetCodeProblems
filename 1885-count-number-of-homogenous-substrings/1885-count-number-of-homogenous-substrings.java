class Solution {
    public int countHomogenous(String s) {
        int count = 0;
        long result = 0;
        char prev = s.charAt(0);
        int currCount = 0;
        int mod = 1000000007;

        for(char c : s.toCharArray()){
            if(c == prev){
                currCount++;
            }else{
                currCount = 1;
                prev = c;
            }
            result = (result + currCount) % mod;
            count = (count + currCount) % mod;
            
        }

        return (int)result;
    }
}