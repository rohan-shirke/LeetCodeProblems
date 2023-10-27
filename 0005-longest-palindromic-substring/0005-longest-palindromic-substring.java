class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        int start = 0, e = 0;

        for(int i = 0; i<s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > e - start){
                start = i - (len - 1) / 2;
                e = i + len / 2;
            }
        }

        return s.substring(start, e +1);
    }

    public int expand(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }

        return r - l - 1;
    }
}