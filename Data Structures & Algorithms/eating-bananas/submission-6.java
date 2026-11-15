class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int minval=1;
       int maxval=0;
       for(int pile : piles){
        maxval = Math.max(maxval,pile);
       }
       while(maxval > minval){
        int mid=minval + (maxval-minval)/2;
        if(canEats(piles,h,mid)){
            maxval= mid;
        }
        else {
            minval=mid+1;
        }
       }
       return minval;
    }
    private boolean canEats(int[] piles,int h,int k){
        int hours=0;
        for(int pile : piles){
            hours += (pile +(k-1))/k;
        }
        return hours <= h;
    }
}
