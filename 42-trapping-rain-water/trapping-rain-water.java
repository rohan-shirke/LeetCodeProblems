class Solution {
    public int trap(int[] height) {
        int result = 0;
        //PREFIX
        int pf[] = new int[height.length];
        pf[0] = height[0];

        for(int i=1; i<height.length; i++){
            pf[i] = Math.max(pf[i-1], height[i]);
        }
        
        //SUFIX
        int[] sf = new int[height.length];
        sf[height.length-1] = height[height.length-1];

        for(int i=height.length-2; i>=0; i--){
            sf[i]= Math.max(sf[i+1], height[i]);
        }
        
        //Water stored in between Buliding
        for(int i=1; i<height.length; i++){
            int water = Math.min(pf[i], sf[i])-height[i];
            if(water>0){
                result+=water;
            }
        }
        return result;
    }
}